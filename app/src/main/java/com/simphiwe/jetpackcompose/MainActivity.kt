package com.simphiwe.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simphiwe.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
            ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(thickness = 1.5.dp)
            }
            CreateInfo()
            Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        Log.d("Clicked", "CreateBizCard: Clicked!")
                    },
                    modifier = Modifier.width(150.dp),
                ) {
                    Text(text = "Portfolio",
                    style = MaterialTheme.typography.labelLarge)
                }
                Divider(thickness = 0.1.dp)


            }

        }
    }

}
@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)) {
        Surface(modifier = Modifier.padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp,color = Color.LightGray)
        ) {
                Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {

}

@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier.padding(start = 20.dp, top = 10.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Simphiwe R.",
            textAlign = TextAlign.Start,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = "Android Developer",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "@simphiweradebe__",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyMedium
        )

    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile_icon),
            contentDescription = "profile image",
            modifier = Modifier.size(135.dp)
        )

    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        CreateBizCard()
    }
}