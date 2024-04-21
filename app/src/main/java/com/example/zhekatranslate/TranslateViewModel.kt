package com.example.zhekatranslate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zhekatranslate.data.LangList
import com.example.zhekatranslate.data.TransRepository
import com.example.zhekatranslate.data.Translate
import com.example.zhekatranslate.network.Data
import com.example.zhekatranslate.network.translateService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TranslateViewModel(
    private val transRepository: TransRepository = Graph.translateRepository
) : ViewModel() {
    private val _translateState = mutableStateOf(TranslateState())
    val translateState: State<TranslateState> = _translateState
    private val _translateData = mutableStateOf(TranslateData(text = ""))
    var inputLang by mutableStateOf("en")
    var outputLang by mutableStateOf("ru")




    fun fetchData() {
        viewModelScope.launch {
            try {
                val response = translateService.getTranslate(
                    _translateData.value.input,
                    _translateData.value.input2,
                    _translateData.value.text
                )
                _translateState.value = _translateState.value.copy(
                    list = response,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _translateState.value = _translateState.value.copy(
                    loading = false,
                    error = "Error"
                )
            }
        }
    }

    fun addLang(text: String) {

    }

    fun addText(orig: String, dest: String, text: String) {
        _translateData.value.input = orig
        _translateData.value.input2 = dest
        _translateData.value.text = text
    }

    lateinit var getAllTranslate: Flow<List<Translate>>

    init {
        viewModelScope.launch {
            getAllTranslate = transRepository.getAllTranslate()
        }
    }

    fun addTranslate(translate: Translate) {
        viewModelScope.launch {
            transRepository.addTranslate(translate)
        }
    }

    fun deleteTranslate(translate: Translate) {
        viewModelScope.launch {
            transRepository.deleteTranslate(translate)
        }
    }
    var focus = mutableStateOf(false)


    data class TranslateData(var input: String = "en", var input2: String = "ru", var text: String)
    data class TranslateState(
        val loading: Boolean = true,
        val list: Data? = null,
        val error: String? = null

    )


    val list = LangList()


}