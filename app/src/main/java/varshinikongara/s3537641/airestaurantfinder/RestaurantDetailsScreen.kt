package varshinikongara.s3537641.airestaurantfinder

import android.R.attr.data
import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import varshinikongara.s3537641.airestaurantfinder.data.DetailViewModel
import androidx.core.net.toUri


@Composable
fun DetailScreen(
    id: String,
    navController: NavController,
    viewModel: DetailViewModel = viewModel()
) {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.loadRestaurantById(id,context)
    }

    val restaurant = viewModel.restaurant
    val isLoading = viewModel.isLoading

    if (isLoading) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    if (restaurant == null) return

//    val data = restaurant

    Box {

        LazyColumn {

            // 🔥 HERO IMAGE + OVERLAY
            item {
                Box {

                    AsyncImage(
                        model = restaurant.image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp),
                        contentScale = ContentScale.Crop
                    )

                    // 🔥 Gradient overlay
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Black.copy(0.6f)
                                    )
                                )
                            )
                    )

                    // 🔙 Back
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color.Black.copy(0.5f), CircleShape)
                    ) {
                        Icon(Icons.Default.ArrowBack, null, tint = Color.White)
                    }

                    // ❤️ Favorite
                    IconButton(
                        onClick = { viewModel.toggleFavorite(context) },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp)
                            .background(Color.White, CircleShape)
                    ) {
                        Icon(
                            imageVector = if (viewModel.isFavorite)
                                Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            tint = Color.Red,
                            contentDescription = null
                        )
                    }

                    // 📍 Title on image
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    ) {
                        Text(
                            restaurant.name,
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "⭐ ${restaurant.rating} • ${restaurant.cuisine}",
                            color = Color.White.copy(0.9f)
                        )
                    }
                }
            }

            // 🔥 INFO CARD
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {

                    Column(Modifier.padding(16.dp)) {

                        Text(restaurant.address, color = Color.Gray)

                        Spacer(Modifier.height(12.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {

                            OutlinedButton(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_DIAL).apply {
                                        data = "tel:${restaurant.phone}".toUri()
                                    }
                                    context.startActivity(intent)
                                }
                            ) {
                                Icon(Icons.Default.Call, null)
                                Spacer(Modifier.width(6.dp))
                                Text("Call")
                            }

                            OutlinedButton(
                                onClick = {
                                    val uri =
                                        Uri.parse("geo:${restaurant.latitude},${restaurant.longitude}")
                                    context.startActivity(Intent(Intent.ACTION_VIEW, uri))
                                }
                            ) {
                                Icon(Icons.Default.LocationOn, null)
                                Spacer(Modifier.width(6.dp))
                                Text("Map")
                            }
                        }
                    }
                }
            }

            // 🍽 MENU
            item {
                SectionTitle("Menu")
            }

            items(restaurant.menu) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Row {

                        AsyncImage(
                            model = item.image,
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .weight(1f)
                        ) {

                            Text(item.name, fontWeight = FontWeight.Bold)

                            Text(
                                item.description,
                                fontSize = 12.sp,
                                color = Color.Gray
                            )

                            Spacer(Modifier.height(6.dp))

                            Text(
                                "£${item.price}",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }

            // ⭐ REVIEWS
            item {
                SectionTitle("Reviews")
            }

            items(restaurant.reviews) { review ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {

                    Column(Modifier.padding(12.dp)) {

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(review.userName, fontWeight = FontWeight.Bold)
                            Text("⭐ ${review.rating}")
                        }

                        Spacer(Modifier.height(4.dp))

                        Text(review.comment)

                        Spacer(Modifier.height(4.dp))

                        Text(
                            review.date,
                            fontSize = 11.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            item { Spacer(Modifier.height(80.dp)) }
        }

        Button(
            onClick = {
                navController.navigate("book/${restaurant.id}/${restaurant.name}")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Book Table")
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp)
    )
}