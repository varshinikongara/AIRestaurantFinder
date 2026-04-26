package varshinikongara.s3537641.airestaurantfinder.data

data class MenuItem(
    val name: String = "",
    val price: Double = 0.0,
    val description: String = "",
    val image: String = ""
)

data class Review(
    val userName: String = "",
    val rating: Double = 0.0,
    val comment: String = "",
    val date: String = ""
)

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
    val isOpen: Boolean = true,

    val menu: List<MenuItem> = emptyList(),
    val reviews: List<Review> = emptyList()
)

data class Booking(
    val id: String = "",
    val restaurantId: String = "",
    val restaurantName: String = "",
    val date: String = "",
    val time: String = "",
    val people: Int = 1,
    val specialRequest: String = "",

    val selectedItems: List<MenuItem> = emptyList(),
    val totalAmount: Double = 0.0,

    val bookingDateTime: String = "",
    val createdDateTime: String = "",
    val createdAt: Long = 0L
)