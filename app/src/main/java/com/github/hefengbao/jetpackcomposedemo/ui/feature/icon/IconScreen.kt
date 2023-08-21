package com.github.hefengbao.jetpackcomposedemo.ui.feature.icon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hefengbao.jetpackcomposedemo.R

@Composable
fun IconScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            modifier = modifier.size(100.dp),
            tint = Color.Red
        )

        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            modifier = modifier.align(Alignment.CenterHorizontally),
            tint = Color.Cyan
        )

        Icon(
            bitmap = ImageBitmap.imageResource(R.drawable.ic_avatar),
            contentDescription = "",
            modifier = modifier,
            tint = Color.Green
        )
    }
}

@Preview
@Composable
private fun IconScreenPreview() {
    IconScreen()
}