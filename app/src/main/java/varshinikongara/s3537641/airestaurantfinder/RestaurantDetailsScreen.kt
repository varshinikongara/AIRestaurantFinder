package varshinikongara.s3537641.airestaurantfinder

import android.R.attr.data
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.firebase.firestore.FirebaseFirestore
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.tasks.await


class DetailViewModel : ViewModel() {

    var restaurant by mutableStateOf<Restaurant?>(null)
    var isLoading by mutableStateOf(true)

    fun loadRestaurant(name: String) {

        FirebaseFirestore.getInstance()
            .collection("restaurants")
            .whereEqualTo("name", name)
            .get()
            .addOnSuccessListener {

                restaurant = it.documents.firstOrNull()
                    ?.toObject(Restaurant::class.java)

                isLoading = false
            }
    }
}


@Composable
fun DetailScreen(name: String, navController: NavController) {

//    val context = LocalContext.current
//    var restaurant by rememberSaveable { mutableStateOf<Restaurant?>(null) }
    var isFavorite by remember { mutableStateOf(false) }

    val viewModel: DetailViewModel = viewModel()
    val context = LocalContext.current

    LaunchedEffect(name) {
        viewModel.loadRestaurant(name)
    }

    // ✅ Loader
    if (viewModel.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    val restaurantData = viewModel.restaurant ?: return

    Box {

        LazyColumn {

            // 🔥 IMAGE HEADER
            item {
                Box {

                    AsyncImage(
                        model = restaurantData.image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        contentScale = ContentScale.Crop
                    )

                    // 🔙 Back Button
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color.Black.copy(0.5f), CircleShape)
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                    }

                    // ❤️ Favorite Button
                    IconButton(
                        onClick = {
                            isFavorite = !isFavorite

                            FirebaseFirestore.getInstance()
                                .collection("restaurants")
                                .whereEqualTo("name", name)
                                .get()
                                .addOnSuccessListener { result ->
                                    val doc = result.documents.firstOrNull()
                                    doc?.reference?.update("isFavorite", isFavorite)
                                }
                        },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp)
                            .background(Color.Black.copy(0.5f), CircleShape)
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = Color.Red
                        )
                    }
                }
            }

            // 📄 INFO CARD
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-20).dp),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                ) {

                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(
                            restaurantData.name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "⭐ ${restaurantData.rating} • ${restaurantData.cuisine}",
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("📍 ${restaurantData.address}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("🕒 ${restaurantData.openTime} - ${restaurantData.closeTime}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("💰 ${restaurantData.priceRange}")

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(restaurantData.description)
                    }
                }
            }

            // 🔘 ACTION BUTTONS
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    // 📞 CALL
                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = "tel:${restaurantData.phone}".toUri()
                            }
                            context.startActivity(intent)
                        }
                    ) {
                        Text("Call")
                    }

                    // 🧭 MAP
                    Button(
                        onClick = {
                            val uri = "geo:0,0?q=${restaurantData.address}".toUri()
                            val intent = Intent(Intent.ACTION_VIEW, uri)
                            intent.setPackage("com.google.android.apps.maps")
                            context.startActivity(intent)
                        }
                    ) {
                        Text("View Map")
                    }
                }
            }
        }
    }
}