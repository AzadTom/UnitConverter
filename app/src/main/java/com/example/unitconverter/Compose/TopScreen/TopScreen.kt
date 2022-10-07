package com.example.unitconverter.Compose.TopScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.unitconverter.Compose.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat


@Composable
fun TopScreen(
    list: List<Conversion>,
    save:(String,String) -> Unit
) {

    val selectedConversion: MutableState<Conversion?> = remember { mutableStateOf(null) }

    val inputText: MutableState<String> = remember { mutableStateOf("") }

    val typedvalue = remember { mutableStateOf("0.0") }


    ConversionMenu(list) {

        selectedConversion.value = it
        typedvalue.value = "0.0"


    }

    selectedConversion.value?.let {

        InputBlock(conversion = it, inputText = inputText) { input ->

            typedvalue.value = input


        }


    }

    if (typedvalue.value != "0.0") {
        val input = typedvalue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy
        val result = input * multiply


        //rounding
        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundedResult = df.format(result)


        val message1 = "${typedvalue.value} ${selectedConversion.value!!.convertFrom} "

        val message2 = "${roundedResult} ${selectedConversion.value!!.convertTo}"
        save(message1,message2)


        ResultBlock(message1, message2)


    }


}