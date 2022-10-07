package com.example.unitconverter.Compose.TopScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.Compose.data.Conversion
import kotlin.math.sin
import kotlin.system.exitProcess


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputBlock(
    conversion: Conversion,
    inputText:MutableState<String>,
    modifier: Modifier = Modifier,
    context:Context = LocalContext.current,
    calculate:(String) ->Unit

){


    val keyboardController = LocalFocusManager.current


    Column(
        modifier = modifier.padding(0.dp,20.dp,0.dp,0.dp)

    ) {

        Row(modifier = modifier.fillMaxWidth()){

            OutlinedTextField(
                value = inputText.value,
                onValueChange = {
                    inputText.value = it
                },

                maxLines = 1,

                modifier = modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType =  KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = {

                       keyboardController.clearFocus()

                    }

                ),
                singleLine = true
                ,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black

                ),



                textStyle = TextStyle(color = Color.DarkGray, fontSize = 20.sp),
                placeholder = { Text("${conversion.convertFrom}", color = Color.DarkGray)}

            )


        }


        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {

            if (inputText.value != "")
            {
                calculate(inputText.value)
            }
            else
            {

                Toast.makeText(context,"Please! enter your value",Toast.LENGTH_SHORT).show()


            }



        },

            modifier = modifier.fillMaxWidth(1F),

            colors = ButtonDefaults.textButtonColors(
                Color.Black
            )


        ){

            Text(text = "TAB",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }


    }


}