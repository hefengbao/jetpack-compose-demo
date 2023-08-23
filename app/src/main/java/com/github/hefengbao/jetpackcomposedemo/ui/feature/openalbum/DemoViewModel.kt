package com.github.hefengbao.jetpackcomposedemo.ui.feature.openalbum

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DemoViewModel : ViewModel() {
    val list = listOf<String>("星期一", "星期二", "星期三", "星期四", "星期五")

    val loading: StateFlow<Boolean> = MutableStateFlow(true)
    fun send() {
        viewModelScope.launch {
            // TODO
        }
    }
}