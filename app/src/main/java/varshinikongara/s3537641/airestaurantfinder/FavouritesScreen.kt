package varshinikongara.s3537641.airestaurantfinder

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import coil.compose.AsyncImage
import kotlinx.coroutines.flow.Flow
import varshinikongara.s3537641.airestaurantfinder.data.Restaurant
import varshinikongara.s3537641.airestaurantfinder.ui.theme.PrimaryColor

@Entity(tableName = "favorites")
data class FavoriteRestaurant(
    @PrimaryKey val id: String,
    val name: String,
    val image: String,
    val rating: Double,
    val cuisine: String,
    val address: String
)

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(fav: FavoriteRestaurant)

    @Delete
    suspend fun delete(fav: FavoriteRestaurant)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): Flow<List<FavoriteRestaurant>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE id = :id)")
    suspend fun isFavorite(id: String): Boolean
}

@Database(entities = [FavoriteRestaurant::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}

object DatabaseProvider {

    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_db"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}

fun FavoriteRestaurant.toRestaurant(): Restaurant {
    return Restaurant(
        id = id,
        name = name,
        image = image,
        rating = rating,
        cuisine = cuisine,
        city = "",
        address = address,
        description = "",
        priceRange = "",
        openTime = "",
        closeTime = "",
        phone = "",
        trending = false,
        isFavorite = true,
        latitude = 0.0,
        longitude = 0.0,
        isOpen = true,
        menu = emptyList(),
        reviews = emptyList()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    navController: NavController
) {

    val context = LocalContext.current
    val dao = DatabaseProvider.getDatabase(context).favoriteDao()

    val favorites by dao.getAllFavorites()
        .collectAsState(initial = emptyList())

    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Favorite Restaurants",
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

        if (favorites.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No favorites yet ❤️",
                    fontSize = 18.sp
                )
            }

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(12.dp)
            ) {

                items(favorites) { fav ->

                    val restaurant = fav.toRestaurant()

                    NearbyCard(
                        restaurant = restaurant,
                        navController = navController
                    )
                }
            }
        }
    }
}