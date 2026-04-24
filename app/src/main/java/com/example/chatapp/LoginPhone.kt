package com.example.chatapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginPhone(navController: NavController? = null) {
    var countryCode by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(horizontal = 20.dp).fillMaxSize()) {
        Image(imageVector = Icons.Filled.Close, modifier = Modifier.size(50.dp).clickable {
            navController?.popBackStack()
        }, contentDescription = null, contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(120.dp))
        Text("手机号登录", modifier = Modifier.wrapContentSize().align(Alignment.CenterHorizontally), fontSize = 25.sp)
        Row(modifier = Modifier.padding(20.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text("国家/地区", fontSize = 20.sp, color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            TextField(value = countryCode, modifier = Modifier.wrapContentWidth().clickable {  },
                onValueChange = { countryCode = it }, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                ))
        }
        HorizontalDivider(modifier = Modifier.padding(horizontal = 20.dp), color = Color.LightGray)
        Row(modifier = Modifier.padding(20.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text("手机号", fontSize = 20.sp, color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                )
            )
        }
        HorizontalDivider(modifier = Modifier.padding(horizontal = 20.dp), color = Color.LightGray)
        Text("微信号/QQ号/邮箱登录", modifier = Modifier.padding(20.dp), color = Color(0xFF5586E1), fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text("上述手机号仅用于验证登录", modifier = Modifier.align(Alignment.CenterHorizontally), color = Color(0xFF3B3939))
        Button(onClick = {}, modifier = Modifier.width(300.dp).padding(top = 20.dp, bottom = 40.dp).align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0AAF7C))) {
            Text("同意并继续", color = Color.White, fontSize = 25.sp)
        }
        Row(modifier = Modifier.padding(20.dp).wrapContentSize().align(Alignment.CenterHorizontally), verticalAlignment = Alignment.CenterVertically) {
            Text("找回密码", modifier = Modifier.padding(horizontal = 20.dp), color = Color(0xFF5586E1), fontSize = 16.sp)
            VerticalDivider(modifier = Modifier.height(40.dp), color = Color.Black)
            Text("更多选项", modifier = Modifier.padding(horizontal = 20.dp), color = Color(0xFF5586E1), fontSize = 16.sp)
        }
    }
}

// ====================== 预览函数，单独写 ======================
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginPhoneScreen() {
    LoginPhone()
}