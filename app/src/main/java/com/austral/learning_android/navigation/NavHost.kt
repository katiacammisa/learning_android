package com.austral.learning_android.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.austral.learning_android.MainMenu
import com.austral.learning_android.tabs.Basic
import com.austral.learning_android.tabs.Buttons
import com.austral.learning_android.tabs.Cards
import com.austral.learning_android.tabs.Checkboxes
import com.austral.learning_android.tabs.Chips
import com.austral.learning_android.tabs.Columns
import com.austral.learning_android.tabs.FABs
import com.austral.learning_android.tabs.Icons
import com.austral.learning_android.tabs.Rows
import com.austral.learning_android.tabs.Switches
import com.austral.learning_android.tabs.Tabs
import com.austral.learning_android.tabs.Texts

@Composable
fun NavHostComposable(innerPadding: PaddingValues, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = LearningAndroidScreen.Home.name,
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(20.dp)
    ) {
        composable(route = LearningAndroidScreen.Home.name) {
            MainMenu(
                onClick = { navController.navigate(it) }
            )
        }

        composable(route = LearningAndroidScreen.Basics.name) {
            Basic(
                onClick = { navController.navigate(it) }
            )
        }
        composable(route = LearningAndroidScreen.Texts.name) {
            Texts()
        }
        composable(route = LearningAndroidScreen.Buttons.name) {
            Buttons()
        }
        composable(route = LearningAndroidScreen.Columns.name) {
            Columns()
        }
        composable(route = LearningAndroidScreen.Rows.name) {
            Rows()
        }
        composable(route = LearningAndroidScreen.Cards.name) {
            Cards()
        }
        composable(route = LearningAndroidScreen.Icons.name) {
            Icons()
        }
        composable(route = LearningAndroidScreen.Chips.name) {
            Chips()
        }
        composable(route = LearningAndroidScreen.Switches.name) {
            Switches()
        }
        composable(route = LearningAndroidScreen.Tabs.name) {
            Tabs()
        }
        composable(route = LearningAndroidScreen.FABs.name) {
            FABs()
        }
        composable(route = LearningAndroidScreen.Checkboxes.name) {
            Checkboxes()
        }
    }
}