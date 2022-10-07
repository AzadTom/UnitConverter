package com.example.unitconverter.Compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.Compose.HistoryScreen.HistoryScreen
import com.example.unitconverter.Compose.TopScreen.TopScreen
import com.example.unitconverter.ConverterViewModalFactory
import com.example.unitconverter.ConverterViewModel


@Composable
fun BaseScreen(

    factory: ConverterViewModalFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)

) {

    // to get list of desired data
    val list = converterViewModel.getConversions()

    val historyList = converterViewModel.result.collectAsState(initial = emptyList() )

    Column(modifier = modifier.padding(30.dp))
    {
        TopScreen(list){ message1 ,message2 ->

            converterViewModel.addResult(message1,message2)


        }
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen(historyList,{  item ->

            converterViewModel.removeResult(item)

        },
            {

                converterViewModel.clearAll()


            })






    }


}