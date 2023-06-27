package com.github.hefengbao.jetpackcomposedemo.ui.feature.textfiled

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen(
    modifier: Modifier = Modifier
) {
    var account by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = account,
            onValueChange = { account = it},
            label = {
                Text(text = "账号")
            }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(text = "密码")
            }
        )
        TextField(value = "", onValueChange = {}, enabled = false)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            maxLines = 15,
            placeholder = {
                Text(text = "请输入...")
            }
        )
    }
}

@Preview
@Composable
private fun TextFieldScreenPreview() {
    TextFieldScreen()
}