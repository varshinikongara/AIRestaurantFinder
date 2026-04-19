package varshinikongara.s3537641.airestaurantfinder

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import varshinikongara.s3537641.airestaurantfinder.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController
) {

    val context = LocalContext.current

    val userName = UserAccountSP.getName(context)
    val userEmail = UserAccountSP.getEmail(context)
    val userPlace = UserAccountSP.getPlace(context)

    Scaffold(

        // 🔝 APP BAR
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Profile", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = PrimaryColor
                )
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // 👤 PROFILE CARD
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // 👤 Avatar
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(
                                PrimaryColor,
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            userName!!,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    Text(
                        userName!!,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        userEmail!!,
                        color = Color.Gray
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            // 📍 DETAILS CARD
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {

                Column(Modifier.padding(16.dp)) {

                    ProfileItem("📧 Email", userEmail!!)
                    Divider(Modifier.padding(vertical = 8.dp))
                    ProfileItem("📍 Location", userPlace!!)
                }
            }

            Spacer(Modifier.height(30.dp))

            // 🚪 LOGOUT BUTTON
            Button(
                onClick = {

                    UserAccountSP.saveUserLoginStatus(context,false)

                    Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show()

                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) // clear backstack
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text("Logout")
            }
        }
    }
}

@Composable
fun ProfileItem(title: String, value: String) {

    Column {
        Text(title, fontSize = 12.sp, color = Color.Gray)
        Text(
            value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}