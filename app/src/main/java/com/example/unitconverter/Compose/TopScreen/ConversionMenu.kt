package com.example.unitconverter.Compose.TopScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.unitconverter.Compose.data.Conversion

@Composable
fun ConversionMenu(list: List<Conversion>, modifier: Modifier = Modifier, convert:(Conversion)->Unit) {

    var displayingText by remember { mutableStateOf("Select the conversion type") }


    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    var expanded by remember { mutableStateOf(false) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column {


          OutlinedTextField(
            value = displayingText,
            onValueChange = { displayingText = it },
            textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = modifier.fillMaxWidth()
                .onGloballyPositioned { cordinates ->
                    textFieldSize = cordinates.size.toSize()
                },

            trailingIcon = {
                Icon(icon,contentDescription = "icon", modifier.clickable {

                   expanded = !expanded

                })
            },

              label = { Text("Conversion Type", color = Color.Black, fontWeight = FontWeight.Bold)},
              colors = TextFieldDefaults.outlinedTextFieldColors(
                  focusedBorderColor = Color.Black,
                  unfocusedBorderColor = Color.Black
              ),

            readOnly = true
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false  },
            modifier = modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        )
        {
            list.forEach { conversion ->

                DropdownMenuItem(onClick = {

                    displayingText = conversion.description
                    expanded = false
                    convert(conversion)

                }) {

                    Text(
                        text = conversion.description,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }

    }




}