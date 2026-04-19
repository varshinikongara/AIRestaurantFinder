package varshinikongara.s3537641.airestaurantfinder

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.google.firebase.firestore.FirebaseFirestore
import varshinikongara.s3537641.airestaurantfinder.data.Booking
import java.util.Date
import java.util.Locale
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun BookTableScreen(
    restaurantId: String,
    restaurantName: String,
    navController: NavController
) {

    val context = LocalContext.current
    val db = FirebaseFirestore.getInstance()

    var selectedDate by remember { mutableStateOf("") }
    var selectedTime by remember { mutableStateOf("") }
    var peopleCount by remember { mutableIntStateOf(2) }
    var specialRequest by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }

    val timeSlots = listOf(
        "12:00 PM", "1:00 PM", "2:00 PM",
        "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM"
    )

    Scaffold(

        // 🔥 APP BAR
        topBar = {
            TopAppBar(
                title = { Text("Book Table") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        },

        // 🔥 STICKY BUTTON
        bottomBar = {
            Button(
                onClick = {

                    val userEmail = UserAccountSP.getEmail(context)

                    if (selectedDate.isEmpty() || selectedTime.isEmpty()) {
                        Toast.makeText(context, "Select date & time", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    val bookingId = UUID.randomUUID().toString()

                    val bookingDateTime = "$selectedDate at $selectedTime" // ✅ user selected
                    val createdDateTime = getCurrentDateTime() // ✅ current time

                    val booking = Booking(
                        id = bookingId,
                        restaurantId = restaurantId,
                        restaurantName = restaurantName,
                        date = selectedDate,
                        time = selectedTime,
                        people = peopleCount,
                        specialRequest = specialRequest,

                        bookingDateTime = bookingDateTime,
                        createdDateTime = createdDateTime,

                        createdAt = System.currentTimeMillis()
                    )

                    db.collection("bookings")
                        .document(userEmail!!)
                        .collection("userBookings")
                        .document(bookingId)
                        .set(booking)
                        .addOnSuccessListener {
                            showDialog = true
                        }
                        .addOnFailureListener {
                            Toast.makeText(context, "Booking failed", Toast.LENGTH_SHORT).show()
                        }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Confirm Booking", fontSize = 16.sp)
            }
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            // 🏪 RESTAURANT CARD
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(18.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(
                            restaurantName,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text("Table Reservation", color = Color.Gray)
                    }
                }
            }

            // 📅 DATE CARD
            item {
                BookingCard(title = "Select Date") {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            selectedDate.ifEmpty { "Choose Date" },
                            color = if (selectedDate.isEmpty()) Color.Gray else Color.Black
                        )

                        IconButton(onClick = {
                            val picker = DatePickerDialog(
                                context,
                                { _, year, month, day ->
                                    selectedDate = "$day/${month + 1}/$year"
                                },
                                2026, 3, 20
                            )
                            picker.show()
                        }) {
                            Icon(Icons.Default.DateRange, null)
                        }
                    }
                }
            }

            // ⏰ TIME CARD
            item {
                BookingCard(title = "Select Time") {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        timeSlots.chunked(3).forEach { rowItems ->

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {

                                rowItems.forEach { time ->

                                    val selected = selectedTime == time

                                    FilterChip(
                                        selected = selected,
                                        onClick = { selectedTime = time },
                                        label = { Text(time) },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 👥 PEOPLE CARD
            item {
                BookingCard(title = "Number of People") {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        IconButton(onClick = {
                            if (peopleCount > 1) peopleCount--
                        }) {
                            Icon(Icons.Outlined.Delete, null)
                        }

                        Text(
                            "$peopleCount",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        IconButton(onClick = {
                            peopleCount++
                        }) {
                            Icon(Icons.Default.Add, null)
                        }
                    }
                }
            }

            // 📝 NOTES CARD
            item {
                BookingCard(title = "Special Request") {

                    OutlinedTextField(
                        value = specialRequest,
                        onValueChange = { specialRequest = it },
                        placeholder = { Text("Birthday, window seat, etc.") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(80.dp)) }
        }
    }

    // 🎉 SUCCESS DIALOG (PREMIUM)
    if (showDialog) {

        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    navController.popBackStack()
                }) {
                    Text("Done")
                }
            },
            title = {
                Text("🎉 Booking Confirmed")
            },
            text = {
                Text("Your table has been reserved successfully.\nEnjoy your meal!")
            }
        )
    }
}


@Composable
fun BookingCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Text(
            title,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 6.dp)
        )

        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(Modifier.padding(16.dp), content = content)
        }
    }
}

fun getCurrentDateTime(): String {
    val sdf = java.text.SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
    return sdf.format(Date())
}