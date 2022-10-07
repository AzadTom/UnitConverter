package com.example.unitconverter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unitconverter.Compose.data.ConverterRepositery

class ConverterViewModalFactory(private val repositery: ConverterRepositery): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = ConverterViewModel(repositery) as T




}