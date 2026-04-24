package com.example.chatapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController? = null) {
    var pwdTxt by remember { mutableStateOf("") }
    var showMore by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(horizontal = 20.dp).fillMaxSize()) {
        Image(imageVector = Icons.Default.AccountBox,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(110.dp).size(80.dp).align(Alignment.CenterHorizontally))
        Text("18812347865", modifier = Modifier.padding(top = 20.dp).align(Alignment.CenterHorizontally), textAlign = TextAlign.Center, fontSize = 20.sp)
        Row(modifier = Modifier.padding(top = 50.dp, bottom = 20.dp).fillMaxWidth().align(Alignment.CenterHorizontally)) {
            Text("密码", modifier = Modifier.wrapContentSize().align(Alignment.CenterVertically), color = Color.Black, fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
            TextField(
                value = pwdTxt,
                placeholder = {
                    Text("请输入密码", color = Color.LightGray, fontSize = 12.sp)
                },
                onValueChange = {
                    pwdTxt = it
                },
                textStyle = TextStyle(color = Color.Black),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )
        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth().background(color = Color.LightGray))
        Text("用短信验证码登录", modifier = Modifier.padding(vertical = 25.dp).clickable {
            navController?.navigate(LOGIN_PHONE, navOptions = navOptions {
                // todo 导航配置
            })
        }, color = Color(0xFF5586E1), fontSize = 16.sp)
        Button(onClick = {
            navController?.navigate(MAIN_PAGE)
        },
            modifier = Modifier.width(300.dp).align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0AAF7C))) {
            Text("登录", color = Color.White, fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.wrapContentSize().padding(bottom = 20.dp).align(Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically) {
            Text("找回密码", color = Color(0xFF5586E1), fontSize = 16.sp)
            VerticalDivider(modifier = Modifier.height(40.dp).padding(horizontal = 20.dp), color = Color.Black)
            Text("紧急冻结", color = Color(0xFF5586E1), fontSize = 16.sp)
            VerticalDivider(modifier = Modifier.height(40.dp).padding(horizontal = 20.dp), color = Color.Black)
            Text("更多", modifier = Modifier.clickable {
                showMore = true
            }, color = Color(0xFF5586E1), fontSize = 16.sp)
        }
        if (showMore) {
            InitBottomSheet() {
                showMore = false
            }
        }
    }

    /**
     * 可用于首页切换不同的页面
     */
    fun switchPage(navController: NavController) {
        navOptions {
            // 弹出到导航图的起始目的地，避免堆栈堆积
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // 避免多次点击产生多个实例
            launchSingleTop = true
            // 重新进入时恢复之前的状态
            restoreState = true
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitBottomSheet(onDismiss: () -> Unit) {
    // 禁止半展开
    val state = rememberModalBottomSheetState(true)
    ModalBottomSheet(onDismissRequest = {
        onDismiss.invoke()
    }, modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        containerColor = Color.White,
        sheetState = state) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("登录其他账号", modifier = Modifier.height(50.dp).wrapContentHeight(Alignment.CenterVertically), textAlign = TextAlign.Center, color = Color.Black, fontSize = 20.sp)
            HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
            Text("注册", modifier = Modifier.height(50.dp).wrapContentHeight(Alignment.CenterVertically), textAlign = TextAlign.Center, color = Color.Black, fontSize = 20.sp)
            HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
            Text("安全问题", modifier = Modifier.height(50.dp).wrapContentHeight(Alignment.CenterVertically), textAlign = TextAlign.Center, color = Color.Black, fontSize = 20.sp)
            HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
            Box(modifier = Modifier.fillMaxWidth().height(30.dp).background(color = Color.Gray))
            Text("取消", modifier = Modifier.height(50.dp).wrapContentHeight(Alignment.CenterVertically).clickable {
                onDismiss.invoke()
            }, color = Color.Black, fontSize = 20.sp)
        }

    }
}

// ====================== 预览函数，单独写 ======================
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
