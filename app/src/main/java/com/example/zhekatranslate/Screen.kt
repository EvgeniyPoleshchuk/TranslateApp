package com.example.zhekatranslate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route:String,val title: String, val icon: ImageVector) {

    object FavoriteScreen:Screen("favorite_screen","", Icons.AutoMirrored.Filled.ArrowBack)
    object OriginLangScreen:Screen("origin_lang_screen","",Icons.AutoMirrored.Filled.ArrowBack)
    object TranslatedLangScreen:Screen("translated_lang_screen","",Icons.AutoMirrored.Filled.ArrowBack)
    object MainView:Screen("main_screen","Жека Переводчик",Icons.Default.Star)


}
val screens = listOf(
    Screen.MainView,
    Screen.FavoriteScreen,
    Screen.OriginLangScreen,
    Screen.TranslatedLangScreen

)



