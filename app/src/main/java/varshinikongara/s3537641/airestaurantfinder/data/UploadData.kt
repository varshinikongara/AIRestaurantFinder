package varshinikongara.s3537641.airestaurantfinder.data

import com.google.firebase.firestore.FirebaseFirestore

fun uploadRestaurantsWithMenuAndReviews() {

    val db = FirebaseFirestore.getInstance()

    val restaurants = listOf(

        // 1️⃣ Dishoom
        Restaurant(
            id = "1",
            name = "Dishoom Covent Garden",
            image = "https://images.unsplash.com/photo-1555396273-367ea4eb4db5",
            rating = 4.7,
            cuisine = "Indian",
            city = "London",
            address = "12 Upper St Martin's Ln, London",
            description = "Bombay-style cafe",
            priceRange = "££",
            openTime = "9:00 AM",
            closeTime = "11:00 PM",
            phone = "+44 20 7420 9320",
            trending = true,
            latitude = 51.511,
            longitude = -0.128,
            isOpen = true,
            menu = sampleMenu("Indian"),
            reviews = sampleReviews()
        ),

        // 2️⃣ Flat Iron
        Restaurant(
            id = "2",
            name = "Flat Iron Soho",
            image = "https://images.unsplash.com/photo-1555992336-03a23c7b20ee",
            rating = 4.6,
            cuisine = "Steakhouse",
            city = "London",
            address = "17 Beak St, Soho",
            description = "Affordable steakhouse",
            priceRange = "££",
            openTime = "12:00 PM",
            closeTime = "11:30 PM",
            phone = "+44 20 3019 3494",
            trending = true,
            latitude = 51.5136,
            longitude = -0.1365,
            isOpen = true,
            menu = sampleMenu("Steak"),
            reviews = sampleReviews()
        ),

        // 3️⃣ Gymkhana
        Restaurant(
            id = "3",
            name = "Gymkhana London",
            image = "https://images.unsplash.com/photo-1600891964599-f61ba0e24092",
            rating = 4.8,
            cuisine = "Indian",
            city = "London",
            address = "42 Albemarle St",
            description = "Michelin-star Indian cuisine",
            priceRange = "££££",
            openTime = "12:00 PM",
            closeTime = "11:00 PM",
            phone = "+44 20 3011 5900",
            trending = false,
            latitude = 51.5096,
            longitude = -0.1420,
            isOpen = true,
            menu = sampleMenu("Indian"),
            reviews = sampleReviews()
        ),

        // 4️⃣ Padella
        Restaurant(
            id = "4",
            name = "Padella Borough Market",
            image = "https://images.unsplash.com/photo-1528605248644-14dd04022da1",
            rating = 4.8,
            cuisine = "Italian",
            city = "London",
            address = "6 Southwark St",
            description = "Fresh pasta",
            priceRange = "££",
            openTime = "11:30 AM",
            closeTime = "10:00 PM",
            phone = "+44 20 3602 7000",
            trending = false,
            latitude = 51.5055,
            longitude = -0.0904,
            isOpen = true,
            menu = sampleMenu("Italian"),
            reviews = sampleReviews()
        ),

        // 5️⃣ Rudy's Pizza
        Restaurant(
            id = "5",
            name = "Rudy's Pizza Manchester",
            image = "https://images.unsplash.com/photo-1548365328-9f547fb0953d",
            rating = 4.8,
            cuisine = "Pizza",
            city = "Manchester",
            address = "9 Cotton St",
            description = "Neapolitan pizza",
            priceRange = "££",
            openTime = "12:00 PM",
            closeTime = "11:00 PM",
            phone = "+44 161 832 4664",
            trending = true,
            latitude = 53.4830,
            longitude = -2.2426,
            isOpen = true,
            menu = sampleMenu("Pizza"),
            reviews = sampleReviews()
        ),

        // 6️⃣ Bundobust
        Restaurant(
            id = "6",
            name = "Bundobust Manchester",
            image = "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d",
            rating = 4.7,
            cuisine = "Indian Street Food",
            city = "Manchester",
            address = "61 Piccadilly",
            description = "Street food & beer",
            priceRange = "££",
            openTime = "11:00 AM",
            closeTime = "11:00 PM",
            phone = "+44 161 359 6757",
            trending = false,
            latitude = 53.4808,
            longitude = -2.2374,
            isOpen = true,
            menu = sampleMenu("Street"),
            reviews = sampleReviews()
        ),

        // 7️⃣ Almost Famous
        Restaurant(
            id = "7",
            name = "Almost Famous Leeds",
            image = "https://images.unsplash.com/photo-1550547660-d9450f859349",
            rating = 4.6,
            cuisine = "Burgers",
            city = "Leeds",
            address = "23 Great George St",
            description = "Loaded burgers",
            priceRange = "££",
            openTime = "12:00 PM",
            closeTime = "10:30 PM",
            phone = "+44 113 244 9444",
            trending = false,
            latitude = 53.8013,
            longitude = -1.5486,
            isOpen = true,
            menu = sampleMenu("Burger"),
            reviews = sampleReviews()
        ),

        // 8️⃣ Sushi Samba
        Restaurant(
            id = "8",
            name = "Sushi Samba",
            image = "https://images.unsplash.com/photo-1553621042-f6e147245754",
            rating = 4.7,
            cuisine = "Japanese",
            city = "London",
            address = "Heron Tower",
            description = "Sushi & skyline views",
            priceRange = "£££",
            openTime = "12:00 PM",
            closeTime = "11:00 PM",
            phone = "+44 20 3640 7330",
            trending = true,
            latitude = 51.516,
            longitude = -0.081,
            isOpen = true,
            menu = sampleMenu("Japanese"),
            reviews = sampleReviews()
        ),

        // 9️⃣ The Ivy
        Restaurant(
            id = "9",
            name = "The Ivy London",
            image = "https://images.unsplash.com/photo-1414235077428-338989a2e8c0",
            rating = 4.5,
            cuisine = "British",
            city = "London",
            address = "1-5 West St",
            description = "Classic British dining",
            priceRange = "£££",
            openTime = "10:00 AM",
            closeTime = "11:30 PM",
            phone = "+44 20 7836 4751",
            trending = false,
            latitude = 51.512,
            longitude = -0.127,
            isOpen = true,
            menu = sampleMenu("British"),
            reviews = sampleReviews()
        ),

        // 🔟 Hawksmoor
        Restaurant(
            id = "10",
            name = "Hawksmoor Manchester",
            image = "https://images.unsplash.com/photo-1551183053-bf91a1d81141",
            rating = 4.7,
            cuisine = "Steakhouse",
            city = "Manchester",
            address = "184 Deansgate",
            description = "Premium steakhouse",
            priceRange = "£££",
            openTime = "12:00 PM",
            closeTime = "11:00 PM",
            phone = "+44 161 836 6980",
            trending = true,
            latitude = 53.479,
            longitude = -2.246,
            isOpen = true,
            menu = sampleMenu("Steak"),
            reviews = sampleReviews()
        )
    )

    restaurants.forEach {
        db.collection("restaurants")
            .document(it.id)
            .set(it)
    }
}

fun sampleMenu(type: String): List<MenuItem> {
    return listOf(
        MenuItem("$type Special Dish", 12.0, "Popular dish", ""),
        MenuItem("$type Deluxe", 15.0, "Chef special", "")
    )
}

fun sampleReviews(): List<Review> {
    return listOf(
        Review("John", 4.5, "Great food!", "2026-04-01"),
        Review("Emma", 4.8, "Amazing experience!", "2026-04-02")
    )
}