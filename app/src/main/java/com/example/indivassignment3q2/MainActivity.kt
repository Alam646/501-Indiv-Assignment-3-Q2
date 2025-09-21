package com.example.indivassignment3q2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer // Added
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height // Added
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button // Added
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.* // Added for state management
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    var showBadge by remember { mutableStateOf(true) } // State for badge visibility

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
        ) {
            // Profile Picture
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text("Pic")
            }

            // Notification Badge (Now conditional)
            if (showBadge) { // Conditionally display the badge
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                        .align(Alignment.BottomEnd)
                ) {
                    // Badge content can be added here if needed
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp)) // Spacer for visual separation

        // Button to toggle badge visibility
        Button(onClick = { showBadge = !showBadge }) {
            Text(if (showBadge) "Hide Badge" else "Show Badge")
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
