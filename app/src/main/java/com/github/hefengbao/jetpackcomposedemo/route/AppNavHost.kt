package com.github.hefengbao.jetpackcomposedemo.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.hefengbao.jetpackcomposedemo.ui.feature.HomeScreen
import com.github.hefengbao.jetpackcomposedemo.ui.feature.appbar.AppBarScreen
import com.github.hefengbao.jetpackcomposedemo.ui.feature.basic.BasicScreen
import com.github.hefengbao.jetpackcomposedemo.ui.feature.button.ButtonScreen
import com.github.hefengbao.jetpackcomposedemo.ui.feature.icon.IconScreen
import com.github.hefengbao.jetpackcomposedemo.ui.feature.image.ImageScreen
import com.github.hefengbao.jetpackcomposedemo.ui.feature.radiobutton_checkbox_switch.RadioButtonCheckBoxSwitchScreen
import com.github.hefengbao.jetpackcomposedemo.ui.feature.scaffold.ScaffoldScreen
import com.github.hefengbao.jetpackcomposedemo.ui.feature.text.TextScreen
import com.github.hefengbao.jetpackcomposedemo.ui.feature.textfiled.TextFieldScreen

private const val ROUTE_HOME = "home"
private const val ROUTE_BASIC = "basic"
private const val ROUTE_TEXT= "text"
private const val ROUTE_TEXT_FIELD= "text_field"
private const val ROUTE_IMAGE= "image"
private const val ROUTE_ICON= "icon"
private const val ROUTE_BUTTON= "button"
private const val ROUTE_SELECTION= "selection"
private const val ROUTE_APPBAR= "appbar"
private const val ROUTE_SCAFFOLD= "scaffold"

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ROUTE_HOME
    ){
        composable(route = ROUTE_HOME){
            HomeScreen(
                onBasicClick = { navController.navigate(ROUTE_BASIC) },
                onTextClick = { navController.navigate(ROUTE_TEXT) },
                onTextFieldClick = { navController.navigate(ROUTE_TEXT_FIELD)},
                onImageClick = { navController.navigate(ROUTE_IMAGE) },
                onIconClick = { navController.navigate(ROUTE_ICON) },
                onButtonClick = { navController.navigate(ROUTE_BUTTON) },
                onSelectionClick = { navController.navigate(ROUTE_SELECTION) },
                onAppBarClick = { navController.navigate(ROUTE_APPBAR) },
                onScaffoldClick = { navController.navigate(ROUTE_SCAFFOLD)}
            )
        }

        composable(route = ROUTE_BASIC){
            BasicScreen()
        }

        composable(ROUTE_TEXT){
            TextScreen()
        }

        composable(ROUTE_TEXT_FIELD){
            TextFieldScreen()
        }

        composable(ROUTE_IMAGE){
            ImageScreen()
        }

        composable(ROUTE_ICON) {
            IconScreen()
        }

        composable(ROUTE_BUTTON){
            ButtonScreen()
        }

        composable(ROUTE_SELECTION){
            RadioButtonCheckBoxSwitchScreen()
        }

        composable(ROUTE_APPBAR){
            AppBarScreen()
        }

        composable(ROUTE_SCAFFOLD){
            ScaffoldScreen(
                onBackClick = navController::navigateUp
            )
        }
    }
}