package com.github.hefengbao.jetpackcomposedemo.ui.feature.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.TransformableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.hefengbao.jetpackcomposedemo.R

@Composable
fun ImageScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().scrollable(rememberScrollState(),Orientation.Vertical),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            modifier = modifier.size(48.dp),
            imageVector = androidx.compose.material.icons.Icons.Default.Add,
            contentDescription = "Notifications",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary)
        )

        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "painterResource")

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
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )

        AsyncImage(
            model = "https://pic.616pic.com/ys_bnew_img/00/28/60/6p82GlZ565.jpg",
            contentDescription = null,
            modifier = modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Inside
        )
    }
}

@Preview
@Composable
private fun ImageScreenPreview() {
    ImageScreen()
}