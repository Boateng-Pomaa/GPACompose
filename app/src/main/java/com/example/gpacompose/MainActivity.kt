package com.example.gpacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gpacompose.ui.theme.GPAComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GPAComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val gpaText = remember { mutableStateOf("") }
    val nameText = remember { mutableStateOf("") }
    val resultText = remember { mutableStateOf("") }
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "GPA",
                fontSize = 28.sp,
                modifier = Modifier.padding(20.dp)
                    .width(80.dp)
                    .height(40.dp)
            )

            TextField(
                value = gpaText.value,
                onValueChange = { newText -> gpaText.value = newText },
                placeholder = { Text("Enter your GPA") },
                modifier = Modifier.padding(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Name",
                fontSize = 28.sp,
                modifier = Modifier.padding(20.dp)
                    .width(80.dp)
                    .height(40.dp)
            )

            TextField(
                value = nameText.value,
                onValueChange = { newText -> nameText.value = newText },
                placeholder = { Text("Enter your name") },
                modifier = Modifier.padding(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                val gpa = gpaText.value.toDouble()
                val name = nameText.value

                val gpaClass:String = displayClass(gpa)
                resultText.value = "$name your class is $gpaClass"
            },
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            contentPadding = ButtonDefaults.ContentPadding
        ) {
            Text(
                text = "Check",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Surface(
            modifier = Modifier
                .padding(20.dp)
                .width(300.dp)
                .height(100.dp)
                .align(Alignment.CenterHorizontally),
            shadowElevation = 2.dp
        ){
            Text(
                text = resultText.value,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

fun displayClass( gpa:Double):String{
    return when {
        gpa >= 3.6 -> "First Class"
        gpa >= 3.0 -> "Second Class Upper"
        gpa >= 2.5 -> "Second Class Lower"
        gpa >= 2.0 -> "Third Class"
        else -> "Pass"
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GPAComposeTheme {
        Greeting()
    }
}