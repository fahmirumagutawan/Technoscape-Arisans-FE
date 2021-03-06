package com.fahgutawan.arisans.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fahgutawan.arisans.navigation.BaseLayerNav
import com.fahgutawan.arisans.util.MyBottomMenu
import com.tahutelor.arisans.ui.theme.White
import kotlinx.coroutines.CoroutineScope

@Composable
fun BasePage(scope: CoroutineScope, scaffoldState: ScaffoldState, firstLayerNavController:NavController) {
    val height = LocalConfiguration.current.screenHeightDp
    val bottomNavBarHeight = height / 10

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White
    ) {
        val baseNavController = rememberNavController()

        //For the content
        Column(modifier = Modifier.fillMaxSize()) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((height - bottomNavBarHeight).dp),
                color = White
            ) {
                BaseLayerNav(
                    scope = scope,
                    scaffoldState = scaffoldState,
                    firstLayerNavController = firstLayerNavController,
                    baseNavController = baseNavController
                )
            }

            //Bottom navBar
            MyBottomMenu(
                height = bottomNavBarHeight.dp,
                scope = scope,
                firstNavController = firstLayerNavController,
                navController = baseNavController
            )
        }
    }
}