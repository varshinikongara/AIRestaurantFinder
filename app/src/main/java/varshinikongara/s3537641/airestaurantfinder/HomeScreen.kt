package varshinikongara.s3537641.airestaurantfinder


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import varshinikongara.s3537641.airestaurantfinder.data.Restaurant
import varshinikongara.s3537641.airestaurantfinder.data.RestaurantViewModel
import varshinikongara.s3537641.airestaurantfinder.data.uploadRestaurantsWithMenuAndReviews
import varshinikongara.s3537641.airestaurantfinder.ui.theme.PrimaryColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: RestaurantViewModel = viewModel()
) {

    val userCity = "London"

    LaunchedEffect(Unit) {
//        uploadRestaurantsWithMenuAndReviews()
        viewModel.loadRestaurants(userCity)
    }

    val trendingList = viewModel.trendingList
    val nearbyList = viewModel.nearbyList

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Home", fontWeight = FontWeight.Bold)
                        Text("📍 London", fontSize = 12.sp, color = Color.DarkGray)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryColor,
                    titleContentColor = Color.Black
                ),
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Profile.route)
                    }) {
                        Icon(Icons.Default.Person, contentDescription = null)
                    }
                },
                modifier = Modifier.statusBarsPadding()
            )
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "🔥 Trending Restaurants",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

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
                Text(
                    "📍 Nearby Top Rated",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            items(nearbyList) {
                NearbyCard(it, navController)
            }
        }
    }
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
            .padding(vertical = 6.dp)
            .clickable {
                navController.navigate("detail/${restaurant.id}")
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
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
                    .padding(8.dp)
                    .weight(1f)
            ) {

                Text(
                    restaurant.name,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )

                Text("⭐ ${restaurant.rating}")
                Text(restaurant.cuisine, color = Color.Gray)
                Text("📍 ${restaurant.address}", maxLines = 1)
            }
        }
    }
}
