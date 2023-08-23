package com.github.hefengbao.jetpackcomposedemo.ui.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    onCardClick: () -> Unit,
    onAlertDialogClick: () -> Unit,
    onNavigationBarClick: () -> Unit,
    onOpenAlbumClick: () -> Unit,
    onPermissionClick: () -> Unit,
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
        onCardClick = onCardClick,
        onAlertDialogClick = onAlertDialogClick,
        onNavigationBarClick = onNavigationBarClick,
        onOpenAlbumClick = onOpenAlbumClick,
        onPermissionClick = onPermissionClick,
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
    onCardClick: () -> Unit,
    onAlertDialogClick: () -> Unit,
    onNavigationBarClick: () -> Unit,
    onOpenAlbumClick: () -> Unit,
    onPermissionClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Item(title = "Modifier、Box、Colum、Row", onClick = onBasicClick)
        Item(title = "Text & ClickableText", onClick = onTextClick)
        Item(title = "TextField & OutlinedTextField", onClick = onTextFieldClick)
        Item(title = "Image", onClick = onImageClick)
        Item(title = "Icon", onClick = onIconClick)
        Item(
            title = "Button、OutlinedButton、TextButton、IconButton、FilledTonalButton、ElevatedButton",
            onClick = onButtonClick
        )
        Item(title = "RadioButton、Checkbox、Switch", onClick = onSelectionClick)
        Item(title = "TopAppBar & BottomAppBar", onClick = onAppBarClick)
        Item(title = "Scaffold & SnackBar", onClick = onScaffoldClick)
        Item(title = "LazyColumn & LazyRow", onClick = onListClick)
        Item(title = "LazyVerticalGrid & LazyHorizontalGrid", onClick = onGridClick)
        Item(title = "Card", onClick = onCardClick)
        Item(title = "AlertDialog", onClick = onAlertDialogClick)
        Item(title = "NavigationBar", onClick = onNavigationBarClick)
        Item(title = "打开相册（Open Album）", onClick = onOpenAlbumClick)
        Item(title = "权限请求", onClick = onPermissionClick)
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