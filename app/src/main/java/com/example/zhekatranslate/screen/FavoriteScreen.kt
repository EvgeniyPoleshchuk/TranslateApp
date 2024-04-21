package com.example.zhekatranslate.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.zhekatranslate.R
import com.example.zhekatranslate.TranslateViewModel
import com.example.zhekatranslate.data.Translate
import com.example.zhekatranslate.ui.theme.ZhekaTranslateTheme

@Composable
fun FavoriteScreen(viewModel: TranslateViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            "Сохранено",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontSize = 30.sp
        )
        val data = viewModel.getAllTranslate.collectAsState(initial = listOf())
        if (data.value.isEmpty()) {

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {

                    Icon(Icons.Default.Star, "", tint = Color.White)
                    Text(
                        stringResource(R.string.empty),
                        color = Color.White,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        stringResource(R.string.empry2),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        LazyColumn(
            Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            items(data.value) { item ->
                TranslateItem(item, viewModel)

            }
        }
    }
}


@Composable
fun TranslateItem(translate: Translate, viewModel: TranslateViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(Color.Black)
    ) {
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "${translate.original}\n${translate.translated}",
                    color = Color.White,
                    fontSize = 20.sp
                )
                IconButton({ viewModel.deleteTranslate(translate) }) {
                    Icon(Icons.Default.Star, "", tint = Color.White)
                }
            }
        }

    }
}