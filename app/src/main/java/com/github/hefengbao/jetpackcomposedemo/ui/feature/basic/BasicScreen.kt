package com.github.hefengbao.jetpackcomposedemo.ui.feature.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BasicScreen(
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        BoxSample(modifier = modifier)
        ColumSample(modifier = modifier)
        RowSample(modifier = modifier)
    }
}

@Composable
fun BoxSample(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .size(250.dp)
            .background(Color.White)
    ){
        Box(
            modifier = modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Green)
        )
        Box(
            modifier = modifier
                .width(150.dp)
                .height(150.dp)
                .background(Color.Cyan)
        )
        Box(
            modifier = modifier
                .padding(10.dp)
                .width(100.dp)
                .height(100.dp)
                .background(Color.Red)
        )
        Box(
            modifier = modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.Red)
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview
@Composable
private fun BoxSamplePreview() {
    BoxSample(modifier = Modifier)
}

@Composable
fun ColumSample(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(modifier = modifier
            .height(20.dp)
            .fillMaxWidth()
            .background(Color.Green))
        Box(modifier = modifier
            .padding(start = 8.dp, end = 4.dp, top = 10.dp, bottom = 6.dp)
            .height(20.dp)
            .fillMaxWidth()
            .background(Color.Red))
        Box(modifier = modifier
            .padding(horizontal = 16.dp, vertical = 0.dp)
            .height(20.dp)
            .fillMaxWidth()
            .background(Color.Blue))
    }
}

@Preview
@Composable
private fun ColumSamplePreview() {
    ColumSample(modifier = Modifier)
}

@Composable
fun RowSample(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(modifier = modifier
            .width(20.dp)
            .height(40.dp)
            .background(Color.Green))
        Box(modifier = modifier
            .width(30.dp)
            .height(30.dp)
            .background(Color.Red))
        Box(modifier = modifier
            .height(50.dp)
            .weight(2f)
            .background(Color.Blue))
        Box(modifier = modifier
            .height(50.dp)
            .weight(1f)
            .background(Color.Cyan))
    }
}

@Preview
@Composable
private fun RowSamplePreview() {
    RowSample(modifier = Modifier)
}