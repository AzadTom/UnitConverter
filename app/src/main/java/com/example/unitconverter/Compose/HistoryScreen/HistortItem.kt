package com.example.unitconverter.Compose.HistoryScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HistoryItem(

    message1: String,
    message2: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier

) {

    Row(
        modifier = modifier.fillMaxWidth().border(border =  BorderStroke(0.5.dp, Color.Gray)),
        verticalAlignment =  Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    )
    {

        Column {

            Text(text = message1 , fontSize = 20.sp, modifier = modifier.padding(start = 5.dp, top = 5.dp))
            Text(text = message2 , fontSize = 20.sp, modifier = modifier.padding(start = 5.dp, bottom = 5.dp))
        }

        IconButton(onClick = { onClose()}){

            Icon(Icons.Filled.Close, contentDescription = "close")

        }

    }




}
