package com.example.unitconverter.Compose.data

import kotlinx.coroutines.flow.Flow

interface ConverterRepositery {



    suspend fun insertResult(result: ConversionResult)

    suspend fun deleteResult(result: ConversionResult)


    suspend fun deleteAllResult()


    fun getAllResult() :Flow<List<ConversionResult>>





}