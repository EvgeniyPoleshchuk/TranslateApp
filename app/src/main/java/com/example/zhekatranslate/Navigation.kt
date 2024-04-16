package com.example.zhekatranslate

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.zhekatranslate.screen.FavoriteScreen
import com.example.zhekatranslate.screen.MainScreen

@Composable
fun Navigation(
    viewModel: TranslateViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            MainScreen(navController, viewModel)
        }
        composable(
            Screen.FavoriteScreen.route + "{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.LongType
                defaultValue = 0L
                nullable = false
            })){
            entry ->
            val id = if(entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            FavoriteScreen(id,viewModel,navController)
        }
    }
}