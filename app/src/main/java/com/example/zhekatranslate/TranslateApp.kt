package com.example.zhekatranslate

import android.app.Application

class ZhekaTranslate: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}