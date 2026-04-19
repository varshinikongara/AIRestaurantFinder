package varshinikongara.s3537641.airestaurantfinder.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import varshinikongara.s3537641.airestaurantfinder.calculateDistance

class SearchViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    var allRestaurants by mutableStateOf<List<Restaurant>>(emptyList())
    var filteredList by mutableStateOf<List<Restaurant>>(emptyList())

    fun loadRestaurants(userCity: String) {
        db.collection("restaurants")
            .get()
            .addOnSuccessListener {

                val list = it.map { doc ->
                    doc.toObject(Restaurant::class.java)
                }

                allRestaurants = list.filter {
                    it.city.equals(userCity, true)
                }

                filteredList = allRestaurants
            }
    }

    fun applyFilters(
        query: String,
        minRating: Double,
        selectedCuisines: List<String>,
        maxDistance: Double,
        isOpen: Boolean,
        userLat: Double,
        userLng: Double
    ) {

        filteredList = allRestaurants.filter { r ->

            val matchesSearch =
                r.name.contains(query, true) ||
                        r.cuisine.contains(query, true)

            val matchesRating = r.rating >= minRating

            val matchesCuisine =
                selectedCuisines.isEmpty() || selectedCuisines.contains(r.cuisine)

            val matchesOpen = !isOpen || r.isOpen

            val matchesDistance =
                calculateDistance(userLat, userLng, r.latitude, r.longitude) <= maxDistance

            matchesSearch && matchesRating && matchesCuisine && matchesOpen  && matchesDistance
        }
    }
}
