package com.github.hefengbao.jetpackcomposedemo.ui.feature.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.github.hefengbao.jetpackcomposedemo.R

@Composable
fun ImageScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .scrollable(rememberScrollState(), Orientation.Vertical)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            modifier = modifier.size(48.dp),
            imageVector = androidx.compose.material.icons.Icons.Default.Add,
            contentDescription = "Notifications",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "painterResource"
        )

        AsyncImage(
            model = "https://pic.616pic.com/ys_bnew_img/00/28/60/6p82GlZ565.jpg",
            contentDescription = null
        )

        AsyncImage(
            model = "https://pic.616pic.com/ys_bnew_img/00/28/60/6p82GlZ565.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp))
                .align(Alignment.CenterHorizontally)
        )

        AsyncImage(
            model = "https://pic.616pic.com/ys_bnew_img/00/28/60/6p82GlZ565.jpg",
            contentDescription = null,
            modifier = modifier
                .size(100.dp)
                .clip(CircleShape),
            onState = { state ->
                when (state) {
                    AsyncImagePainter.State.Empty -> {
                        // 如果图片链接不存在，这里可以设置提示
                    }

                    is AsyncImagePainter.State.Error -> {
                        // 如果加载出错，这里可先设置显示错误提示或图片
                    }

                    is AsyncImagePainter.State.Loading -> {
                        // 比如显示加载进度条等
                    }

                    is AsyncImagePainter.State.Success -> {
                        // 比如隐藏加载进度条等
                    }
                }
            },
            contentScale = ContentScale.Inside,
            alpha = 0.1f,
        )

        AsyncImage(
            model = "https://pic.616pic.com/ys_bnew_img/00/28/60/6p82GlZ565.jpg",
            contentDescription = null,
            modifier = modifier
                .size(100.dp)
                .clip(CircleShape),
            placeholder = painterResource(id = R.drawable.ic_launcher_background), // 占位符，即加载时显示的图像，可选
            error = painterResource(id = R.drawable.ic_launcher_foreground), // 加载图片出错时显示的图像，可选
            fallback = painterResource(id = R.drawable.ic_launcher_foreground), // 加载的图像链接不存在时指定要显示的图像，可选
            onLoading = {
                // 显示进度条等
            },
            onSuccess = {
                // 隐藏进度条等
            },
            onError = {
                // 隐藏进度条,错误提示等
            },
            alignment = Alignment.Center, // 图像对其位置,默认居中显示
            contentScale = ContentScale.Fit, // 图像填充模式
            alpha = 0.5f, // 设置透明度
        )
    }
}

@Preview
@Composable
private fun ImageScreenPreview() {
    ImageScreen()
}