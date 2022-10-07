package com.example.unitconverter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unitconverter.Compose.data.Conversion
import com.example.unitconverter.Compose.data.ConversionResult
import com.example.unitconverter.Compose.data.ConverterRepositery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ConverterViewModel(private val repositery: ConverterRepositery):ViewModel() {


    fun getConversions() = listOf(
        Conversion(1, "Pounds to kilograms", "LBS", "KG", 0.453592),
        Conversion(2, "Kilograms to Pounds", "KG", "LBS", 2.20462),
        Conversion(3,"Yards to Meters","YD","M",0.9144),
        Conversion(4,"Meters to Yards","M","YD",1.09361),
        Conversion(5,"Miles to Kilometers","MI","KM",1.60934),
        Conversion(6,"Kilometers to Miles","KM","MI",0.621371),

    )


    fun addResult(message1:String,message2:String){

        viewModelScope.launch(Dispatchers.IO) {

            repositery.insertResult(ConversionResult(0,message1,message2))

        }

    }

    val result = repositery.getAllResult()


    fun removeResult(item:ConversionResult){

        viewModelScope.launch(Dispatchers.IO) {

            repositery.deleteResult(item)
        }

    }



    fun clearAll(){

        viewModelScope.launch(Dispatchers.IO) {

            repositery.deleteAllResult()
        }
    }










}