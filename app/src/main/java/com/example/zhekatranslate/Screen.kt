package com.example.zhekatranslate

sealed class Screen(val route:String) {

    object HomeScreen:Screen("home_screen")
    object FavoriteScreen:Screen("FavoriteScreen")

}



