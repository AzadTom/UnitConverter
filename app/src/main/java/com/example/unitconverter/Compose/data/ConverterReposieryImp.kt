package com.example.unitconverter.Compose.data

import kotlinx.coroutines.flow.Flow

class ConverterReposieryImp(private val dao: ConvertDao) :ConverterRepositery {





    override suspend fun insertResult(result: ConversionResult) {

        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {

        dao.deleteResult(result)
    }

    override suspend fun deleteAllResult() {

        dao.deleteAll()
    }

    override fun getAllResult(): Flow<List<ConversionResult>> {

        return dao.getResult()

    }
}