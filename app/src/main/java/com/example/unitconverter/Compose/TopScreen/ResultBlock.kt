package com.example.unitconverter.Compose.TopScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ResultBlock(message1:String , message2 :String ,modifier: Modifier = Modifier){


    Card(elevation = 10.dp,
        modifier = modifier.padding(top = 20.dp).fillMaxWidth()
    ){
        Column(
            modifier =modifier.padding(10.dp)
        ){

            Text(text =message1 ,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = message2,
                fontSize = 24.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )

        }

    }


}