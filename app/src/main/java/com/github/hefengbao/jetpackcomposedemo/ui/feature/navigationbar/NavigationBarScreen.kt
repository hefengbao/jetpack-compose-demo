package com.github.hefengbao.jetpackcomposedemo.ui.feature.navigationbar

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarScreen(
    modifier: Modifier = Modifier
) {
    val list = listOf(
        NavigationItem(icon = Icons.Default.Home, label = "主页", hasNew = false, count = 10),
        NavigationItem(icon = Icons.Default.Chat, label = "消息", hasNew = false, count = 100),
        NavigationItem(icon = Icons.Default.Person, label = "我", hasNew = true, count = null),
    )

    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {},
        bottomBar = {
            NavigationBar {
                list.forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = {
                            if (navigationItem.hasNew || navigationItem.count != null) {
                                BadgedBox(
                                    badge = {
                                        if (navigationItem.count != null) {
                                            Badge {
                                                Text(
                                                    text = if (navigationItem.count >= 100){
                                                        "99+"
                                                    }else{
                                                        navigationItem.count.toString()
                                                    }
                                                )
                                            }
                                        } else {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector = navigationItem.icon, contentDescription = null)
                                }
                            }

                        },
                        label = {
                            Text(text = navigationItem.label)
                        }
                    )
                }
            }
        }
    ) {paddingValues ->
        Box(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = list[selectedItem].label)
        }
    }
}

data class NavigationItem(
    val icon: ImageVector,
    val label: String,
    val hasNew: Boolean = false,
    val count: Int? = null
)