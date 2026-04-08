package varshinikongara.s3537641.airestaurantfinder


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.firebase.firestore.FirebaseFirestore

data class Restaurant(
    val id: String = "",
    val name: String = "",
    val image: String = "",
    val rating: Double = 0.0,
    val cuisine: String = "",
    val city: String = "",
    val address: String = "",
    val description: String = "",
    val priceRange: String = "",
    val openTime: String = "",
    val closeTime: String = "",
    val phone: String = "",
    val trending: Boolean = false,
    var isFavorite: Boolean = false,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val isOpen: Boolean = true
)


class RestaurantViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    var trendingList by mutableStateOf<List<Restaurant>>(emptyList())
    var nearbyList by mutableStateOf<List<Restaurant>>(emptyList())

    fun loadRestaurants(userCity: String) {
        db.collection("restaurants")
            .get()
            .addOnSuccessListener { result ->

                val list = result.map {
                    it.toObject(Restaurant::class.java)
                }

                val cityFiltered = list.filter {
                    it.city.equals(userCity, ignoreCase = true)
                }

                trendingList = cityFiltered.filter { it.trending }

                nearbyList = cityFiltered
                    .filter { it.rating >= 4.5 }
                    .sortedByDescending { it.rating }
            }
    }
}



@Composable
fun HomeScreen(navController: NavController, viewModel: RestaurantViewModel = viewModel()) {

    val userCity = "London"

    LaunchedEffect(Unit) {
//        uploadRestaurantsToFirestore()
        viewModel.loadRestaurants(userCity)
    }

    val trendingList = viewModel.trendingList
    val nearbyList = viewModel.nearbyList

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {

        item { SearchBar() }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text("🔥 Trending Restaurants", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        item {
            LazyRow {
                items(trendingList) {
                    TrendingCard(it, navController)
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text("📍 Nearby Top Rated", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        items(nearbyList) {
            NearbyCard(it, navController)
        }
    }
}


@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search restaurants...") },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        }
    )
}


@Composable
fun TrendingCard(
    restaurant: Restaurant,
    navController: NavController
) {

    Card(
        modifier = Modifier
            .width(220.dp)
            .padding(end = 12.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = {
            navController.navigate(Screen.Detail.createRoute(restaurant.name))
        }
    ) {

        Column {

            Box {

                AsyncImage(
                    model = restaurant.image,
                    contentDescription = null,
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                // ⭐ Rating Badge
                Text(
                    text = "⭐ ${restaurant.rating}",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(Color.Black.copy(alpha = 0.7f), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp),
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

            Column(modifier = Modifier.padding(10.dp)) {

                Text(
                    restaurant.name,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    restaurant.cuisine,
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Composable
fun NearbyCard(
    restaurant: Restaurant,
    navController: NavController
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = {
            navController.navigate(Screen.Detail.createRoute(restaurant.name))

        }
    ) {

        Row(
            modifier = Modifier.height(110.dp)
        ) {

            AsyncImage(
                model = restaurant.image,
                contentDescription = null,
                modifier = Modifier
                    .width(110.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(
                    restaurant.name,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    "⭐ ${restaurant.rating} • ${restaurant.cuisine}",
                    color = Color.Gray,
                    fontSize = 13.sp
                )

                Text(
                    restaurant.address,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 1
                )
            }
        }
    }
}


fun uploadRestaurantsToFirestore() {

    val db = FirebaseFirestore.getInstance()

    val restaurants = listOf(

        Restaurant(
            name = "Dishoom Covent Garden",
            rating = 4.7,
            cuisine = "Indian",
            city = "London",
            address = "12 Upper St Martin's Ln, London",
            description = "Famous Bombay-style cafe serving iconic Indian dishes.",
            priceRange = "££",
            openTime = "9:00 AM",
            closeTime = "11:00 PM",
            phone = "+44 20 7420 9320",
            image = "https://images.unsplash.com/photo-1555396273-367ea4eb4db5",
            latitude = 51.5129,
            longitude = -0.1273,
            isOpen = true,
            trending = true
        ),

        Restaurant(
            name = "Flat Iron Soho",
            rating = 4.6,
            cuisine = "Steakhouse",
            city = "London",
            address = "17 Beak St, Soho, London",
            description = "Affordable steakhouse known for quality cuts.",
            priceRange = "££",
            openTime = "12:00 PM",
            closeTime = "11:30 PM",
            phone = "+44 20 3019 3494",
            image = "https://images.unsplash.com/photo-1555992336-03a23c7b20ee",
            latitude = 51.5136,
            longitude = -0.1365,
            isOpen = true,
            trending = true
        ),

        Restaurant(
            name = "Gymkhana London",
            rating = 4.8,
            cuisine = "Indian",
            city = "London",
            address = "42 Albemarle St, London",
            description = "Michelin-star Indian cuisine.",
            priceRange = "££££",
            openTime = "12:00 PM",
            closeTime = "11:00 PM",
            phone = "+44 20 3011 5900",
            image = "https://images.unsplash.com/photo-1600891964599-f61ba0e24092",
            latitude = 51.5096,
            longitude = -0.1420,
            isOpen = true,
            trending = false
        ),

        Restaurant(
            name = "Padella Borough Market",
            rating = 4.8,
            cuisine = "Italian",
            city = "London",
            address = "6 Southwark St, London",
            description = "Fresh handmade pasta restaurant.",
            priceRange = "££",
            openTime = "11:30 AM",
            closeTime = "10:00 PM",
            phone = "+44 20 3602 7000",
            image = "https://images.unsplash.com/photo-1528605248644-14dd04022da1",
            latitude = 51.5055,
            longitude = -0.0904,
            isOpen = true,
            trending = false
        ),

        Restaurant(
            name = "Rudy's Pizza Manchester",
            rating = 4.8,
            cuisine = "Pizza",
            city = "Manchester",
            address = "9 Cotton St, Manchester",
            description = "Authentic Neapolitan pizza.",
            priceRange = "££",
            openTime = "12:00 PM",
            closeTime = "11:00 PM",
            phone = "+44 161 832 4664",
            image = "https://images.unsplash.com/photo-1548365328-9f547fb0953d",
            latitude = 53.4830,
            longitude = -2.2426,
            isOpen = true,
            trending = true
        ),

        Restaurant(
            name = "Bundobust Manchester",
            rating = 4.7,
            cuisine = "Indian Street Food",
            city = "Manchester",
            address = "61 Piccadilly, Manchester",
            description = "Indian street food & craft beer.",
            priceRange = "££",
            openTime = "11:00 AM",
            closeTime = "11:00 PM",
            phone = "+44 161 359 6757",
            image = "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d",
            latitude = 53.4808,
            longitude = -2.2374,
            isOpen = true,
            trending = false
        ),

        Restaurant(
            name = "Almost Famous Leeds",
            rating = 4.6,
            cuisine = "Burgers",
            city = "Leeds",
            address = "23-25 Great George St, Leeds",
            description = "Famous for loaded burgers.",
            priceRange = "££",
            openTime = "12:00 PM",
            closeTime = "10:30 PM",
            phone = "+44 113 244 9444",
            image = "https://images.unsplash.com/photo-1550547660-d9450f859349",
            latitude = 53.8013,
            longitude = -1.5486,
            isOpen = true,
            trending = false
        )
    )

    restaurants.forEach {
        db.collection("restaurants").add(it)
    }
}