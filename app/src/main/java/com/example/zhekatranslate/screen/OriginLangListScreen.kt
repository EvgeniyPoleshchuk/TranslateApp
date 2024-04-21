package com.example.zhekatranslate.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zhekatranslate.TranslateViewModel
import com.example.zhekatranslate.ui.theme.grey_white

@Composable
fun OriginLangScreen(viewModel: TranslateViewModel, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Text(
            "Язык оригинала",
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
            fontSize = 30.sp
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
        ) {
            items(viewModel.list.size) {
                LangItem(viewModel, it, navController)

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LangItem(viewModel: TranslateViewModel, count: Int, navController: NavController) {
    var check by remember { mutableStateOf(false) }
    val data2 = viewModel.list.keys.elementAt(count)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            if (viewModel.inputLang == data2) {
                check = true
                Color.DarkGray
            } else {
                check = false
                Color.Black
            }
        ),

        onClick = {
            viewModel.inputLang = data2
            navController.navigateUp()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (check) {
                Icon(Icons.Default.Check, "",Modifier.padding(start = 15.dp, end = 5.dp), tint = grey_white)
            }
            Text(viewModel.list.values.elementAt(count), color = grey_white, fontSize = 20.sp, modifier = Modifier.padding(start = 10.dp))
        }
    }
}
