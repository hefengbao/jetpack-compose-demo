package com.github.hefengbao.jetpackcomposedemo.ui.feature.alertdialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AlertDialogScreen(
    modifier: Modifier = Modifier
) {
    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text(text = "显示对话框")
    }

    if (showDialog) {
        AlertDialog(
            modifier = modifier,
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text(text = "确认")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(text = "取消")
                }
            },
            icon = {
                Icon(imageVector = Icons.Default.PrivacyTip, contentDescription = null)
            },
            title = {
                Text(text = "用户协议")
            },
            text = {
                Column {
                    Text(
                        text = """
                        1、关于我们；
                        2、账号安全；
                        3、隐私政策
                        4、生效时间
                    """.trimIndent()
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(checked = false, onCheckedChange = {})
                        Text(text = "请阅读并同意用于协议")
                    }
                }
            },
        )
    }
}