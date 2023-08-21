package com.github.hefengbao.jetpackcomposedemo.ui.feature.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = "基本按钮")
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = "外边款按钮")
        }

        TextButton(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = "文本按钮")
        }

        FilledTonalButton(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = "FilledTonalButton")
        }

        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = "ElevatedButton")
        }

        IconButton(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "返回")
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(text = "默认是 RowScope,从左至右排列")
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            enabled = true,
            shape = ButtonDefaults.elevatedShape,
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
                disabledContainerColor = Color.Blue.copy(alpha = 0.5f),
                disabledContentColor = Color.LightGray
            ),
            elevation = null,
            border = BorderStroke(8.dp, Brush.horizontalGradient(listOf(Color.Cyan, Color.Green))),
            contentPadding = PaddingValues(32.dp)
        ) {
            Text(text = "自定义属性的按钮")
        }
    }
}

@Preview
@Composable
fun ButtonScreenPreview() {
    ButtonScreen()
}