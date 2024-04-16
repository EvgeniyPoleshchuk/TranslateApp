package com.example.zhekatranslate

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    title: String,
    onBackNavClicked: () -> Unit = {}
) {
    val navigationIcon: (@Composable () -> Unit)? =
        if (!title.contains("Женя Переводчик")) {
            {
                IconButton(onClick = { onBackNavClicked() }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        tint = colorResource(R.color.grey_white),
                        contentDescription = ""
                    )
                }
            }
        } else {
            null
        }

    TopAppBar(
        title = {
            Text(title,
                color = colorResource(R.color.grey_white),
                modifier = Modifier.padding(start = 50.dp)
            )
        }
    )



    }

