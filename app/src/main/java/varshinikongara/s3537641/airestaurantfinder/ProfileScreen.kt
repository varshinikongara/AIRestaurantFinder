package varshinikongara.s3537641.airestaurantfinder

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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.database.FirebaseDatabase
import varshinikongara.s3537641.airestaurantfinder.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController
) {

    val context = LocalContext.current

    var isEditing by remember { mutableStateOf(false) }
    var showLogoutDialog by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    // 🔥 Load from SP
    var name by remember { mutableStateOf(UserAccountSP.getName(context) ?: "") }
    var email by remember { mutableStateOf(UserAccountSP.getEmail(context) ?: "") }
    var place by remember { mutableStateOf(UserAccountSP.getPlace(context) ?: "") }

    val db = FirebaseDatabase.getInstance()
        .getReference("UserAccounts")

    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Profile", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    TextButton(
                        onClick = { isEditing = !isEditing },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color.Black
                        )

                    ) {
                        Text(if (isEditing) "Cancel" else "Edit")
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Avatar
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(PrimaryColor, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            name.firstOrNull()?.toString() ?: "",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    if (isEditing) {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = { Text("Name") }
                        )
                    } else {
                        Text(name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(Modifier.height(6.dp))

                    Text(email, color = Color.Gray)
                }
            }

            Spacer(Modifier.height(20.dp))

            // 📍 PLACE CARD
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {

                Column(Modifier.padding(16.dp)) {

                    Text("📍 Location", fontSize = 12.sp, color = Color.Gray)

                    Spacer(Modifier.height(4.dp))

                    if (isEditing) {
                        OutlinedTextField(
                            value = place,
                            onValueChange = { place = it },
                            modifier = Modifier.fillMaxWidth()
                        )
                    } else {
                        Text(place, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }

            Spacer(Modifier.height(30.dp))

            // 💾 SAVE BUTTON (only in edit mode)
            if (isEditing) {
                Button(
                    onClick = {

                        val updatedUser = UserDetails(
                            name = name,
                            emailid = email,
                            place = place
                        )

                        db.child(email.replace(".", ","))
                            .setValue(updatedUser)
                            .addOnSuccessListener {

                                // update local SP
                                UserAccountSP.saveName(context, name)
                                UserAccountSP.savePlace(context, place)

                                showSuccessDialog = true
                                isEditing = false
                            }

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Save Changes")
                }

                Spacer(Modifier.height(20.dp))
            }

            // 🚪 LOGOUT
            Button(
                onClick = { showLogoutDialog = true },
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

    // ✅ SUCCESS DIALOG
    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = { showSuccessDialog = false },
            confirmButton = {
                Button(onClick = { showSuccessDialog = false }) {
                    Text("OK")
                }
            },
            title = { Text("Success 🎉") },
            text = { Text("Profile updated successfully") }
        )
    }

    // 🚪 LOGOUT CONFIRMATION
    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            confirmButton = {
                Button(
                    onClick = {
                        UserAccountSP.saveUserLoginStatus(context, false)
                        navController.navigate(Screen.Login.route) {
                            popUpTo(0)
                        }
                    }
                ) {
                    Text("Logout")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showLogoutDialog = false }) {
                    Text("Cancel")
                }
            },
            title = { Text("Logout") },
            text = { Text("Are you sure you want to logout?") }
        )
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