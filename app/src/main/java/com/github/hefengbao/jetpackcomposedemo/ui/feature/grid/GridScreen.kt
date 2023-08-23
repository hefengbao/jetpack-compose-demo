package com.github.hefengbao.jetpackcomposedemo.ui.feature.grid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GridScreen(
    modifier: Modifier = Modifier
) {
    val lazyVerticalGridState = rememberLazyGridState()
    val lazyHorizontalState = rememberLazyGridState()

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        LazyHorizontalGrid(
            modifier = modifier.height(120.dp),
            rows = GridCells.Fixed(2),
            state = lazyHorizontalState,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(
                    items = list,
                ) { item ->
                    Text(
                        text = "Grid $item",
                        modifier = modifier
                            .height(50.dp)
                            .width(100.dp)
                            .background(Color.Yellow),
                    )
                }
            }
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = lazyVerticalGridState,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(
                    items = list,
                ) { item ->
                    Text(
                        text = "Grid $item",
                        modifier = modifier
                            .height(200.dp)
                            .width(100.dp)
                            .background(Color.Green),
                    )
                }
            }
        )
    }
}