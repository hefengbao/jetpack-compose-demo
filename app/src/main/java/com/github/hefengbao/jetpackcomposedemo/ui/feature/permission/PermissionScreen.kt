package com.github.hefengbao.jetpackcomposedemo.ui.feature.permission

import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionScreen(
    modifier: Modifier = Modifier
) {
    var permissionRequested = false

    val permissionState = rememberPermissionState(
        android.Manifest.permission.ACCESS_FINE_LOCATION
    ){
        Log.i("Permission","State = $it")
        permissionRequested = true
    }

    val context = LocalContext.current

    var shouldOpenLocationSettings by remember { mutableStateOf(false) }

    var shouldShowRationale by remember { mutableStateOf(false) }

    var shouldShowAppSettings by remember { mutableStateOf(false) }

    Button(
        onClick = {
            if (locationServiceEnabled(context)){
                if (permissionState.status.isGranted){
                    // 定位逻辑
                    Log.i("Permission","定位逻辑")
                }else{
                    if (permissionState.status.shouldShowRationale){
                        Log.i("Permission", "shouldShowRationale")
                        shouldShowRationale = true
                    }else{
                        Log.i("Permission","第一次请求亦或者是第三次请求？")
                        if (!permissionRequested){
                            permissionState.launchPermissionRequest()
                        }else{
                            Log.i("Permission","去设置")
                            shouldShowAppSettings = true
                        }
                    }
                }
            }else{
                // 没有开启 【位置信息】，则提示去设置
                shouldOpenLocationSettings = true
            }
        }
    ) {
        Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
        Text(text = "获取位置")
    }

    if (shouldOpenLocationSettings){
        AlertDialog(
            onDismissRequest = { shouldOpenLocationSettings = false },
            confirmButton = {
                Button(
                    onClick = {
                        try {
                            context.startActivity(
                                Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                            )
                        }catch (e: Exception){
                            context.startActivity(
                                Intent(Settings.ACTION_SETTINGS)
                            )
                        }
                    }
                ) {
                    Text(text = "设置")
                }
            },
            dismissButton = {
                TextButton(onClick = { shouldOpenLocationSettings = false }) {
                    Text(text = "取消")
                }
            },
            text = {
                Text(text = "您的系统设置没有开启【位置信息】，请前往设置界面开启")
            }
        )
    }

    if (shouldShowAppSettings){
        AlertDialog(
            onDismissRequest = { shouldShowAppSettings = false },
            confirmButton = {
                Button(
                    onClick = {
                        context.startActivity(
                            Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                                data = Uri.fromParts("package", context.packageName, null)
                            }
                        )
                        shouldShowAppSettings = false
                    }
                ) {
                    Text(text = "去设置")
                }
            },
            dismissButton = {
                TextButton(onClick = { shouldShowAppSettings = false }) {
                    Text(text = "取消")
                }
            },
            text = {
                Text(text = "您已拒绝授予定位权限，请前往设置界面授权")
            }
        )
    }

    if (shouldShowRationale){
        AlertDialog(
            onDismissRequest = { shouldShowRationale = false },
            confirmButton = {
                Button(
                    onClick = {
                        shouldShowRationale = false
                        permissionState.launchPermissionRequest()
                    }
                ) {
                    Text(text = "授权")
                }
            },
            dismissButton = {
                TextButton(onClick = { shouldShowRationale = false }) {
                    Text(text = "取消")
                }
            },
            text = {
                Text(text = "定位需要您授予权限才嗯能使用")
            }
        )
    }
}

private fun locationServiceEnabled(context: Context): Boolean = when{
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.P -> {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.isLocationEnabled
    }
    else -> {
        try {
            Settings.Secure.getInt(
                context.contentResolver, Settings.Secure.LOCATION_MODE
            ) != Settings.Secure.LOCATION_MODE_OFF
        }catch (e: Settings.SettingNotFoundException){
            false
        }
    }
}