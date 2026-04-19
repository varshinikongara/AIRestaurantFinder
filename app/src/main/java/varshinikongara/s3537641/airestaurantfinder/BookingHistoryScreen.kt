package varshinikongara.s3537641.airestaurantfinder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import varshinikongara.s3537641.airestaurantfinder.data.Booking
import varshinikongara.s3537641.airestaurantfinder.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingHistoryScreen() {

    val db = FirebaseFirestore.getInstance()

    var bookings by remember { mutableStateOf<List<Booking>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    val userEmail = UserAccountSP.getEmail(LocalContext.current)

    LaunchedEffect(Unit) {

        if (userEmail == null) return@LaunchedEffect

        db.collection("bookings")
            .document(userEmail)
            .collection("userBookings")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
                bookings = it.documents.mapNotNull { doc ->
                    doc.toObject(Booking::class.java)
                }
                isLoading = false
            }
    }


    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Booking History",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = PrimaryColor,
                    titleContentColor = Color.Black
                )
            )
        }

    ) { padding ->

        when {
            isLoading -> {
                Box(Modifier
                    .fillMaxSize()
                    .padding(padding), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            bookings.isEmpty() -> {
                EmptyState()
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(12.dp)
                ) {
                    items(bookings) { booking ->

                        BookingCardItem(
                            booking = booking,
                            onCancel = {
//                            val userEmail = FirebaseAuth.getInstance().currentUser?.email

                                db.collection("bookings")
                                    .document(userEmail!!)
                                    .collection("userBookings")
                                    .document(booking.id)
                                    .delete()
                            }
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun EmptyState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text("No bookings yet 😔", fontSize = 18.sp)

            Spacer(Modifier.height(8.dp))

            Text(
                "Book a table to see it here",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun BookingCardItem(
    booking: Booking,
    onCancel: () -> Unit
) {

    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            // 🔥 TOP ROW (Restaurant + Status)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    booking.restaurantName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 1
                )

                // ✅ Status Badge
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFE8F5E9),
                            shape = RoundedCornerShape(50)
                        )
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        "Confirmed",
                        color = Color(0xFF2E7D32),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(Modifier.height(10.dp))

            // 📅 DATE & TIME (Highlighted Row)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFFF5F5F5),
                        RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("📅 ${booking.date}", fontWeight = FontWeight.Medium)
                Text("⏰ ${booking.time}", fontWeight = FontWeight.Medium)
            }

            Spacer(Modifier.height(10.dp))

            // 👥 PEOPLE
            Text(
                "👥 ${booking.people} people",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            // 📝 SPECIAL REQUEST
            if (booking.specialRequest.isNotEmpty()) {
                Spacer(Modifier.height(6.dp))

                Text(
                    "📝 ${booking.specialRequest}",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }

            Spacer(Modifier.height(10.dp))

            Divider()

            Spacer(Modifier.height(8.dp))

            // 🕒 META INFO
            Text(
                "Booked on ${booking.createdDateTime}",
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(Modifier.height(12.dp))

            // ❌ CANCEL BUTTON
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                OutlinedButton(
                    onClick = { showDialog = true },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Red
                    )
                ) {
                    Text("Cancel")
                }
            }
        }
    }

    if (showDialog) {

        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(
                    onClick = {
                        onCancel()
                        showDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    )
                ) {
                    Text("Yes, Cancel")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showDialog = false }) {
                    Text("No")
                }
            },
            title = { Text("Cancel Booking") },
            text = { Text("Do you really want to cancel this reservation?") }
        )
    }
}