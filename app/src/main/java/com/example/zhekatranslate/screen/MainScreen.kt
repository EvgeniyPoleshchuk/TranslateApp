package com.example.zhekatranslate.screen


import androidx.collection.emptyLongSet
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.zhekatranslate.R
import com.example.zhekatranslate.Screen
import com.example.zhekatranslate.TranslateViewModel
import com.example.zhekatranslate.data.Translate
import com.example.zhekatranslate.screens
import com.example.zhekatranslate.ui.theme.ZhekaTranslateTheme
import com.example.zhekatranslate.ui.theme.grey_white


@Composable
fun MainScreen() {
    var viewModel: TranslateViewModel = viewModel()
    val controller: NavController = rememberNavController()
    val ScaffoldState = rememberScaffoldState()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var title = screens.firstOrNull() { it.route == currentRoute }?.title
        ?: "Unknown"

    if (currentRoute == Screen.MainView.route)
        ZhekaTranslateTheme(Color.Black.toArgb(), Color.DarkGray.toArgb())
    else
        ZhekaTranslateTheme(Color.Black.toArgb(), Color.Black.toArgb())

    Scaffold(
        scaffoldState = ScaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title, color = grey_white
                    )
                },
                navigationIcon = {
                    IconButton({
                        if (currentRoute == Screen.MainView.route) {
                            controller.navigate(Screen.FavoriteScreen.route)
                        } else {
                            controller.navigateUp()
                        }
                    }) {
                        Icon(
                            screens.firstOrNull() { it.route == currentRoute }?.icon
                                ?: Icons.Default.Star, "", tint = grey_white
                        )
                    }
                },
                backgroundColor = colorResource(R.color.black),
            )
        }

    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(color = Color.Black)) {
            Navigation(controller, viewModel, it)
        }

    }
}

@Composable
fun Navigation(
    navController: NavController,
    viewModel: TranslateViewModel,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.MainView.route, modifier = Modifier.padding(paddingValues),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(Screen.MainView.route) {
            MainView(viewModel, navController)
        }
        composable(Screen.FavoriteScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        200, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(200, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        200, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }) {
            FavoriteScreen(viewModel)
        }
        composable(Screen.OriginLangScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        200, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(200, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Up
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        200, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.Down
                )
            }) {
            OriginLangScreen(viewModel, navController)
        }
        composable(Screen.TranslatedLangScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        200, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(200, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Up
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        200, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.Down
                )
            }) {
            TranslatedLangScreen(viewModel, navController)
        }

    }
}




