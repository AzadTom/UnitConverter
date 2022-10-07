package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.unitconverter.Compose.BaseScreen
import com.example.unitconverter.Compose.data.ConverterDatabase
import com.example.unitconverter.Compose.data.ConverterReposieryImp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val  dao = ConverterDatabase.getInstance(applicationContext).ConvertDao
        val repositery = ConverterReposieryImp(dao)
        val factory = ConverterViewModalFactory(repositery)
        setContent {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                BaseScreen(factory)

            }
        }
    }
}


