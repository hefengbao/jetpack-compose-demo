package com.github.hefengbao.jetpackcomposedemo.ui.feature.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Redo
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Undo
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    var showSnackbar by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "ww.8ug.icu")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Undo, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Redo, contentDescription = null)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState)}
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {
            Button(onClick = { showSnackbar = true }) {
                Text(text = "Show Snackbar")
            }
        }

        LaunchedEffect(showSnackbar){
            if (showSnackbar){
                val result = snackbarHostState.showSnackbar(
                    message = "欢迎来到 www.8ug.icu",
                    actionLabel = "关闭",
                    duration = SnackbarDuration.Indefinite,
                    withDismissAction = true
                )

                showSnackbar = when(result){
                    SnackbarResult.Dismissed -> {
                        false
                    }

                    SnackbarResult.ActionPerformed -> {
                        false
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ScaffoldScreenPreview() {
    ScaffoldScreen(
        onBackClick = {}
    )
}