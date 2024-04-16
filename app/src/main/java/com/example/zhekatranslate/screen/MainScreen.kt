package com.example.zhekatranslate.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.zhekatranslate.R
import com.example.zhekatranslate.Screen
import com.example.zhekatranslate.TranslateViewModel


@Composable
fun MainScreen(navController: NavHostController, viewModel: TranslateViewModel) {

    var inputText by remember { mutableStateOf("") }
    var outputText by remember { mutableStateOf("") }


    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row() {
                    Text("Женя ", fontWeight = FontWeight.ExtraBold, color = Color.White)
                    Text("Переводчик", color = Color.White)
                }
            },
            navigationIcon = {
                IconButton({navController.navigate(Screen.FavoriteScreen.route)}) {
                    Icon(Icons.Default.Star, "", tint = Color.White)
                }
            },
            backgroundColor = colorResource(R.color.black)
        )
    }

    ) {
        var l = viewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn(Modifier.padding(it)){
            items(l.value){
                item ->
                Text(item.title)

            }
        }
    }

//        Column(
//            Modifier
//                .padding(it)
//                .fillMaxSize()
//                .background(Color.Black)
//        ) {
//            Spacer(Modifier.padding(top = 20.dp))
//
//
//            TextField(modifier = Modifier.fillMaxWidth(),
//                value = inputText,
//                onValueChange = {
//                    inputText = it
//                },
//                placeholder = {
//                              Text("Введите текст", color = colorResource(R.color.grey_white), fontSize = 30.sp,)
//                },
//                colors = OutlinedTextFieldDefaults.colors(
//                    unfocusedBorderColor = Transparent,
//                    focusedBorderColor = Transparent,
//                    unfocusedTextColor = colorResource(R.color.grey_white),
//                    focusedTextColor = colorResource(R.color.grey_white)
//                ),
//                textStyle = TextStyle.Default.copy(fontSize = 34.sp)
//            )
//            if(inputText != "") {
//                Divider(
//                    Modifier.padding(start = 100.dp, end = 100.dp, bottom = 22.dp, top = 22.dp),
//                    color = colorResource(R.color.white)
//                )
//            }
//
//            Text(inputText, color = colorResource(R.color.grey_white), fontSize = 30.sp, modifier = Modifier.padding(start = 15.dp))
//        }
//    }

}