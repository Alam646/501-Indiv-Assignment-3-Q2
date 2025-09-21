package com.example.indivassignment3q2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape // Added
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text // Added (or ensured)
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip // Added
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.indivassignment3q2.ui.theme.IndivAssignment3Q2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndivAssignment3Q2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileWithBadgeScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileWithBadgeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // This Box now acts as a container for the profile picture and the badge.
        // The size defined here (120.dp) will be for the overall profile area.
        Box(
            modifier = Modifier
                .size(120.dp)
            // .background(Color.Gray) // Background removed, children will provide visuals
        ) {
            // Profile Picture
            Box(
                modifier = Modifier
                    .fillMaxSize() // Fills the 120.dp container
                    .clip(CircleShape) // Makes it circular
                    .background(Color.LightGray), // Background for the profile picture
                contentAlignment = Alignment.Center // Center the placeholder text
            ) {
                Text("Pic") // Placeholder for an actual image
            }

            // Notification Badge (Static for now)
            Box(
                modifier = Modifier
                    .size(30.dp) // Size of the badge
                    .clip(CircleShape) // Makes badge circular
                    .background(Color.Red) // Badge color
                    .align(Alignment.BottomEnd) // Aligns this Box to the bottom-end of the parent Box
                // To add text or a number inside the badge later, you might add:
                // .padding(4.dp),
                // contentAlignment = Alignment.Center
            ) {
                // Example badge content (can be added in a later step if needed):
                // Text(text = "1", color = Color.White, fontSize = 10.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileWithBadgeScreenPreview() {
    IndivAssignment3Q2Theme {
        ProfileWithBadgeScreen(modifier = Modifier.fillMaxSize())
    }
}
