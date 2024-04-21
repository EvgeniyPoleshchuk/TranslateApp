package com.example.zhekatranslate.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zhekatranslate.R
import com.example.zhekatranslate.Screen
import com.example.zhekatranslate.TranslateViewModel
import com.example.zhekatranslate.data.Translate
import com.example.zhekatranslate.ui.theme.grey_white

@Composable
fun MainView(viewModel: TranslateViewModel, navController: NavController) {
    var inputText by rememberSaveable { mutableStateOf("") }
    var outputText by rememberSaveable { mutableStateOf("") }
    val viewState by viewModel.translateState
    val focusManager = LocalFocusManager.current
    var temp by remember { mutableStateOf("") }
    var context = LocalContext.current
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black)

    ) {
        Spacer(Modifier.padding(top = 20.dp))


        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(remember { FocusRequester() })
                .onFocusChanged {
                    viewModel.focus.value = false
                },
            value = inputText,
            onValueChange = {
                inputText = it
                viewModel.addText(viewModel.inputLang, viewModel.outputLang, inputText)
                viewModel.fetchData()
            },
            placeholder = {
                Text(
                    "Введите текст",
                    color = colorResource(R.color.grey_white),
                    fontSize = 30.sp,
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedTextColor = colorResource(R.color.grey_white),
                focusedTextColor = colorResource(R.color.grey_white)
            ),
            textStyle = TextStyle.Default.copy(fontSize = 34.sp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
                viewModel.focus.value = true

            }),
            trailingIcon = {
                if (inputText != "" && viewModel.focus.value) {
                    IconButton({
                        viewModel.addTranslate(
                            translate = Translate(
                                original = inputText,
                                translated = outputText
                            )
                        )
                        Toast.makeText(context, "Добавлен в избранное", Toast.LENGTH_LONG).show()
                    }) {
                        Icon(Icons.Default.Star, "", tint = Color.White)
                    }
                } else if (inputText != "") {
                    IconButton({ inputText = "" }) {
                        Icon(Icons.Default.Clear, "", tint = grey_white)

                    }
                }
            }

        )
        if (inputText != "") {
            Divider(
                Modifier.padding(
                    start = 100.dp,
                    end = 100.dp,
                    bottom = 22.dp,
                    top = 22.dp
                ),
                color = colorResource(R.color.white)
            )
        }

        Text(
            outputText,
            color = colorResource(R.color.grey_white),
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 15.dp)
        )
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
            ) {
                Button(modifier = Modifier.size(170.dp, 40.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.Black
                    ),
                    onClick = {
                        navController.navigate(Screen.OriginLangScreen.route)

                    }) {
                    Text(viewModel.list[viewModel.inputLang].toString(), color = Color.White,)
                }
                IconButton({
                    temp = viewModel.inputLang
                    viewModel.inputLang = viewModel.outputLang
                    viewModel.outputLang = temp
                    viewModel.addText(viewModel.inputLang, viewModel.outputLang, inputText)
                    viewModel.fetchData()
                }) {
                    Image(painterResource(R.drawable.baseline_compare_arrows_24), "")
                }
                Button(modifier = Modifier.size(170.dp, 40.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.Black
                    ),
                    onClick = {
                        navController.navigate(Screen.TranslatedLangScreen.route)
                    }) {
                    Text(viewModel.list[viewModel.outputLang].toString(), color = Color.White)
                }
            }
        }

        when {
            viewState.loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Start),
                    color = Color.Black
                )
            }

            else -> {
                outputText =
                    if (inputText != "") viewModel.translateState.value.list?.destinationText.toString()
                    else ""
            }

        }
    }


}
