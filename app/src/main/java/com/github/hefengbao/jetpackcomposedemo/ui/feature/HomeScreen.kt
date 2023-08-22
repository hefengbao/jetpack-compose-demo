package com.github.hefengbao.jetpackcomposedemo.ui.feature

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onBasicClick: () -> Unit,
    onTextClick: () -> Unit,
    onTextFieldClick: () -> Unit,
    onImageClick: () -> Unit,
    onIconClick: () -> Unit,
    onButtonClick: () -> Unit,
    onSelectionClick: () -> Unit,
    onAppBarClick: () -> Unit,
    onScaffoldClick: () -> Unit,
    onListClick: () -> Unit,
    onGridClick: () -> Unit,
) {
    FeatureList(
        onBasicClick = onBasicClick,
        onTextClick = onTextClick,
        onTextFieldClick = onTextFieldClick,
        onImageClick = onImageClick,
        onIconClick = onIconClick,
        onButtonClick = onButtonClick,
        onSelectionClick = onSelectionClick,
        onAppBarClick = onAppBarClick,
        onScaffoldClick = onScaffoldClick,
        onListClick = onListClick,
        onGridClick = onGridClick,
    )
}


@Composable
private fun FeatureList(
    modifier: Modifier = Modifier,
    onBasicClick: () -> Unit,
    onTextClick: () -> Unit,
    onTextFieldClick: () -> Unit,
    onImageClick: () -> Unit,
    onIconClick: () -> Unit,
    onButtonClick: () -> Unit,
    onSelectionClick: () -> Unit,
    onAppBarClick: () -> Unit,
    onScaffoldClick: () -> Unit,
    onListClick: () -> Unit,
    onGridClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .scrollable(rememberScrollState(), Orientation.Vertical)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Item(title = "Modifier、Box、Colum、Row", onClick = onBasicClick)
        Item(title = "Text & ClickableText", onClick = onTextClick)
        Item(title = "TextField & OutlinedTextField", onClick = onTextFieldClick)
        Item(title = "Image", onClick = onImageClick)
        Item(title = "Icon", onClick = onIconClick)
        Item(title = "Button、OutlinedButton、TextButton、IconButton、FilledTonalButton、ElevatedButton", onClick = onButtonClick)
        Item(title = "RadioButton、Checkbox、Switch", onClick = onSelectionClick)
        Item(title = "TopAppBar & BottomAppBar", onClick = onAppBarClick)
        Item(title = "Scaffold & SnackBar", onClick = onScaffoldClick)
        Item(title = "LazyColumn & LazyRow", onClick = onListClick)
        Item(title = "LazyVerticalGrid & LazyHorizontalGrid", onClick = onGridClick)
    }
}

@Composable
private fun Item(title: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
        )
    }
}