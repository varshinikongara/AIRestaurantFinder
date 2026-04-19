package varshinikongara.s3537641.airestaurantfinder.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

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