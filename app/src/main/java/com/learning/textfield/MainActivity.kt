package com.learning.textfield

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learning.textfield.ui.theme.TextFieldTheme
import java.io.OutputStreamWriter
import java.lang.annotation.Repeatable

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                  ColumnArrangement()
                }
            }
        }
    }
@Composable
fun ColumnArrangement(){

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            FirstName()
            Lastname()
            PhoneNumber()
            EmailAddress()
                DOB()
            ResetButton()
            SubmitButton()}}


    @Composable
    fun DOB() {
        Row(horizontalArrangement = Arrangement.Center){
            var text by remember {
                mutableStateOf(TextFieldValue(""))
            }
            OutlinedTextField(value = text,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                text = it
            }, placeholder = {Text("dd/mm/yyyy")},
                enabled = true,
                readOnly = false,
                label = {
                    Text(text = "Date of birth")
                },
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick ={/*TODO*/}){
                        Icon(imageVector= Icons.Filled.DateRange, contentDescription = "Date icon")

                    }
            }
                )

        }
    }


    @Composable
   fun SubmitButton() {Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 15.dp),
                onClick ={
                            if(FirstName().toString().isNotEmpty()){



                // For First time: Creates a text file and writes string into it

                // Else: Opens the text file and writes the string

                try {
                    val fileOutputStream = openFileOutput("TextFile.txt", Context.MODE_PRIVATE)
                    val outputWriter = OutputStreamWriter(fileOutputStream)
                    outputWriter.write(FirstName().toString())
                    outputWriter.close()
                    Toast.makeText(baseContext, "Text saved successfully!", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            } else {
                Toast.makeText(applicationContext, "No input?", Toast.LENGTH_SHORT).show()
            }
        }
                ,
            colors = buttonColors(backgroundColor = Color.Blue,
            contentColor = Color.White),
            ) {
            Text(text = "Submit")
        }

        }
    }

        @Composable
   fun ResetButton() {Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 15.dp),onClick={/*TODO*/},
            colors = buttonColors(backgroundColor = Color.Blue,
            contentColor = Color.White),
            ) {
                Text(text = "Reset")
            }

        }
    }

    @Composable
    fun EmailAddress() {Row(horizontalArrangement = Arrangement.Center){
            var text by remember {
                mutableStateOf(TextFieldValue(""))
            }
            OutlinedTextField(value = text,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onValueChange = {
                text = it
            }, placeholder = {Text("Enter your email")},
                enabled = true,
                readOnly = false,
                label = {
                    Text(text = "Email Address")
                },
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick ={/*TODO*/}){
                        Icon(imageVector= Icons.Filled.Email, contentDescription = "Email Icon")

                    }
            }
                )

        }
    }
     @Composable
   fun Lastname() {Row(horizontalArrangement = Arrangement.Center){
            var text by remember {
                mutableStateOf(TextFieldValue(""))
            }
            OutlinedTextField(value = text,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = {
                text = it
            }, placeholder = {Text("Enter your Lastname")},
                enabled = true,
                readOnly = false,
                label = {
                    Text(text = "Lastname")
                },
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick ={/*TODO*/}){
                        Icon(imageVector= Icons.Filled.Person, contentDescription = "Person")

                    }
            }
                )

        }
    }

    @Composable
     fun FirstName() {Row(horizontalArrangement = Arrangement.Center){
            var text by remember {
                mutableStateOf(TextFieldValue(""))
            }
            OutlinedTextField(value = text,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = {
                text = it
            }, placeholder = {Text("Enter your email")},
                enabled = true,
                readOnly = false,
                label = {
                    Text(text = "Firstname")
                },
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick ={/*TODO*/}){
                        Icon(imageVector= Icons.Filled.Person, contentDescription = "Person")

                    }
            }
                )

        }
    }

    @Composable
    fun PhoneNumber() {Row(horizontalArrangement = Arrangement.Center){
            var text by remember {
                mutableStateOf(TextFieldValue(""))
            }
           OutlinedTextField(value = text,
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
               onValueChange = {
                text = it
            },
                enabled = true,
                readOnly = false,
                label = {
                    Text(text = "Phone number")
                },
               placeholder = {Text("Enter your phone number")},
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick ={/*TODO*/}){
                        Icon(imageVector= Icons.Filled.Phone, contentDescription = "Phone Icon")

                    }
            }
                )

        }
    }

    @Preview(showBackground = true)
        @Composable
        fun DefaultPreview() {
            TextFieldTheme {
      ColumnArrangement()
            }
        }



}

