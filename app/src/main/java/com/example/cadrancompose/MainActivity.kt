package com.example.cadrancompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cadrancompose.ui.theme.CadranComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CadranComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    CardGrid(modifier = Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
fun CardGrid(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            InfoCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFEADDFF)
            )
            InfoCard(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFD0BCFF)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            InfoCard(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFB69DF8)
            )
            InfoCard(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFF6EDFF)
            )
        }
    }
}

@Composable
fun InfoCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    Card(
        modifier = modifier
            .fillMaxHeight()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardGridPreview() {
    CadranComposeTheme {
        CardGrid()
    }
}
