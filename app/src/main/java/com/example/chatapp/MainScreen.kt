package com.example.chatapp

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController: NavController? = null) {
    val titles = listOf("微信", "通讯录", "发现", "我")
    val pagerState = rememberPagerState(pageCount = { titles.size })
    val scope = rememberCoroutineScope()
    var curIndex by remember { mutableIntStateOf(0) }
    var curTitle by remember { mutableStateOf(titles[curIndex]) }

    Scaffold( topBar = { InitAppBar(curTitle) }, bottomBar = {
        InitTabBar(titles) { index ->
            curIndex = index
            curTitle = titles[index]
            scope.launch {
                pagerState.animateScrollToPage(index)
            }
        }
    }) { padding ->
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false,
            modifier = Modifier.padding(padding)
        ) { index ->
            Box(modifier = Modifier.fillMaxWidth()) {
                Text("加入我们 · 加入我们 · 加入我们 · page $index", modifier = Modifier.width(100.dp)
                    .basicMarquee(velocity = 50.dp) // 走马灯50dp/s
                    .align(Alignment.Center) // align必须写在宽、高之后，因为只有确定了宽、高后，才知道怎么居中
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitAppBar(title: String) {
    CenterAlignedTopAppBar(
        title = { Text(title, modifier = Modifier.wrapContentSize()) },
        navigationIcon = {

        },
        actions = {
            IconButton(onClick = {

            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
            IconButton(onClick = {

            }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = null)
            }
        }
    )
}

@Composable
fun InitTabBar(titles: List<String>, tabClick: (Int) -> Unit) {
    var selectIndex by remember { mutableIntStateOf(0) }
    NavigationBar (modifier = Modifier.fillMaxWidth()) {
        titles.forEachIndexed { index, title ->
            NavigationBarItem(
                selected = selectIndex == index,
                onClick = { tabClick.invoke(index) },
                label = {
                    Text(title, fontSize = 20.sp)
                },
                icon = {
                    val icon = when (index) {
                        0 -> Icons.Default.Search
                        1 -> Icons.Default.AccountCircle
                        3 -> Icons.Default.Settings
                        else -> Icons.Default.AccountBox
                    }
                    Icon(imageVector = icon, null)
                }
            )
        }
    }
}