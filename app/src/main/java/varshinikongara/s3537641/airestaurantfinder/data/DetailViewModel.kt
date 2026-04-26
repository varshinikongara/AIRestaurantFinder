package varshinikongara.s3537641.airestaurantfinder.data

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import varshinikongara.s3537641.airestaurantfinder.DatabaseProvider
import varshinikongara.s3537641.airestaurantfinder.FavoriteRestaurant

class DetailViewModel : ViewModel() {

    var restaurant by mutableStateOf<Restaurant?>(null)
    var isLoading by mutableStateOf(true)
    var isFavorite by mutableStateOf(false)


    fun loadRestaurantById(id: String, context: Context) {

        val dao = DatabaseProvider.getDatabase(context).favoriteDao()

        isLoading = true

        FirebaseFirestore.getInstance()
            .collection("restaurants")
            .document(id)
            .get()
            .addOnSuccessListener { doc ->

                val data = doc.toObject(Restaurant::class.java)

                restaurant = data

                viewModelScope.launch {
                    isFavorite = dao.isFavorite(id)
                }

                isLoading = false
            }
    }

    fun toggleFavorite(context: Context) {

        val dao = DatabaseProvider.getDatabase(context).favoriteDao()
        val data = restaurant ?: return

        viewModelScope.launch {

            val fav = FavoriteRestaurant(
                id = data.id,
                name = data.name,
                image = data.image,
                rating = data.rating,
                cuisine = data.cuisine,
                address = data.address
            )

            if (isFavorite) {
                dao.delete(fav)
            } else {
                dao.insert(fav)
            }

            isFavorite = dao.isFavorite(data.id)
        }
    }
}
