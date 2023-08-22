package com.github.hefengbao.jetpackcomposedemo.ui.feature.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen(
    modifier: Modifier = Modifier
) {
    val lazyColumnState = rememberLazyListState()
    val lazyRowState = rememberLazyListState()

    val list = listOf(1,2,3,4,5,6,7,8,9,10)
    LazyColumn(
        state = lazyColumnState,
        content = {
            item {
                LazyRow(
                    modifier = modifier.height(250.dp),
                    state = lazyRowState,
                    content = {
                        itemsIndexed(
                            items = list,
                            key = {index: Int, item: Int -> index },
                        ){index,item ->
                            Text(
                                text = "Row $item",
                                modifier = modifier
                                    .padding(16.dp)
                                    .background(Color.Yellow)
                                    .width(100.dp)
                                    .fillMaxHeight(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                )
            }

            itemsIndexed(
                items = list,
                key = { index: Int, item: Int ->  index}
            ){index: Int, item: Int ->  
                Text(
                    text = "Column itemsIndexed：index = $index,item = $item",
                    modifier = modifier
                        .padding(16.dp)
                        .background(Color.Cyan)
                        .fillMaxWidth()
                )
            }
            item {
                Divider( modifier = modifier.fillMaxWidth())
            }

            items(
                items = list,
                key = null
            ){item: Int ->
                Text(
                    text = "Column items：item = $item",
                    modifier = modifier
                        .padding(16.dp)
                        .background(Color.Green)
                        .fillMaxWidth()
                )
            }

            item {
                Divider( modifier = modifier.fillMaxWidth())
            }
        }
    )
}