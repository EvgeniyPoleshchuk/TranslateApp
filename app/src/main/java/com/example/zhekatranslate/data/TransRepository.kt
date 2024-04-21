package com.example.zhekatranslate.data

import kotlinx.coroutines.flow.Flow

class TransRepository(
    private val translateDao: TranslateDao
) {
    suspend fun addTranslate(translate: Translate) {
        translateDao.addTranslate(translate)
    }

    fun getAllTranslate(): Flow<List<Translate>> = translateDao.getAllTranslate()

    suspend fun deleteTranslate(translate: Translate) {
        translateDao.deleteTranslate(translate)
    }
}