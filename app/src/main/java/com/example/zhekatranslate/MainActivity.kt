package com.example.zhekatranslate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.zhekatranslate.screen.MainScreen


import com.example.zhekatranslate.ui.theme.ZhekaTranslateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZhekaTranslateTheme()
            MainScreen()
        }
    }
}

