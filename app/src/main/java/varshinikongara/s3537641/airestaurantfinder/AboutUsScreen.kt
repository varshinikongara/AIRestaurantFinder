package varshinikongara.s3537641.airestaurantfinder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import varshinikongara.s3537641.airestaurantfinder.ui.theme.PrimaryColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUsScreen(navController: NavController) {

    Scaffold(

        // 🔝 App Bar
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("About Us", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = PrimaryColor
                )
            )
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // 🍽️ APP INTRO CARD
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {

                        Text(
                            "AI Restaurant Finder",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            "AI Restaurant Finder is a smart mobile app designed to help users quickly discover the best restaurants based on their location, budget, and preferences.",
                            lineHeight = 20.sp
                        )

                        Spacer(Modifier.height(6.dp))

                        Text(
                            "Using AI-powered recommendations, the app provides personalized suggestions, making dining decisions easier and faster.",
                            lineHeight = 20.sp
                        )
                    }
                }
            }

            // 👩‍💻 DEVELOPER CARD
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(Modifier
                        .fillMaxWidth()
                        .padding(16.dp)) {

                        Text(
                            "Developed By",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        Spacer(Modifier.height(6.dp))

                        Text(
                            "Varsha Varshini Kongara",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            "(S3537641)",
                            color = Color.Gray
                        )
                    }
                }
            }

            // 📞 CONTACT CARD
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(Modifier
                        .fillMaxWidth()
                        .padding(16.dp)) {

                        Text(
                            "Contact Us",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(10.dp))

                        Text("📧 Varshinikongara@gmail.com")
                        Spacer(Modifier.height(6.dp))
                        Text("📍 Teesside University, Middlesbrough, UK")
                    }
                }
            }
        }
    }
}