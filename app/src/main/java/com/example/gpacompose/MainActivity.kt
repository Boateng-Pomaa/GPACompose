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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
    Row {
        Column {
            Text(
                text = "GPA",
                fontSize = 28.sp,
                modifier = Modifier.padding(20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "name",
                fontSize = 28.sp,
                modifier = Modifier.padding(20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { /* TODO */ } ,
                modifier = Modifier.padding(100.dp)
                    .align(Alignment.CenterHorizontally)) {
               Text(text = "Check",
                   fontSize = 18.sp,
                   textAlign = TextAlign.Center ,
                   modifier =  Modifier.padding(10.dp)
                       .align(Alignment.CenterVertically))
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    GPAComposeTheme {
//        Greeting("Android")
//    }
//}