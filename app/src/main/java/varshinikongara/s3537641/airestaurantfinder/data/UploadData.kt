package varshinikongara.s3537641.airestaurantfinder.data

import com.google.firebase.firestore.FirebaseFirestore

fun uploadRestaurantsWithMenuAndReviews() {

    val db = FirebaseFirestore.getInstance()

    val restaurants = listOf(

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

            menu = listOf(
                MenuItem("Butter Chicken", 13.5, "Creamy curry", "https://images.unsplash.com/photo-1603894584373-5ac82b2ae398"),
                MenuItem("Chicken Biryani", 14.0, "Aromatic rice", "https://images.unsplash.com/photo-1600628422019-6b8c0c9b3c9c"),
                MenuItem("Paneer Tikka", 10.0, "Grilled paneer", "https://images.unsplash.com/photo-1601050690597-df0568f70950"),
                MenuItem("Masala Dosa", 9.0, "Crispy dosa", "https://images.unsplash.com/photo-1631515242808-497c3fbd3977"),
                MenuItem("Chole Bhature", 11.0, "Spicy chickpeas", "https://images.unsplash.com/photo-1626132647523-66a9c54e07c2"),
                MenuItem("Dal Makhani", 10.5, "Lentil curry", "https://images.unsplash.com/photo-1625944237212-9d98a8e1e2ef"),
                MenuItem("Tandoori Chicken", 15.0, "Grilled chicken", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Naan Basket", 6.0, "Indian breads", "https://images.unsplash.com/photo-1605475121337-6b4b8e79c9f2"),
                MenuItem("Mango Lassi", 5.0, "Sweet drink", "https://images.unsplash.com/photo-1626082927389-6cd097cdc6ec"),
                MenuItem("Gulab Jamun", 6.5, "Dessert", "https://images.unsplash.com/photo-1627308595229-7830a5c91f9f")
            ),

            reviews = listOf(
                Review("John", 4.5, "Amazing Indian food!", "2026-04-01"),
                Review("Emma", 4.8, "Loved the biryani!", "2026-04-02"),
                Review("Alex", 4.6, "Authentic taste", "2026-04-03"),
                Review("Sophia", 4.7, "Great ambience", "2026-04-04"),
                Review("Daniel", 4.9, "Highly recommended!", "2026-04-05")
            )
        ),

        Restaurant(
            id = "2",
            name = "Flat Iron Soho",
            image = "https://images.unsplash.com/photo-1555992336-03a23c7b20ee",
            rating = 4.6,
            cuisine = "Steakhouse",
            city = "London",
            address = "17 Beak St",
            description = "Affordable steakhouse",
            priceRange = "££",
            openTime = "12:00 PM",
            closeTime = "11:30 PM",
            phone = "+44 20 3019 3494",
            trending = true,
            latitude = 51.5136,
            longitude = -0.1365,
            isOpen = true,

            menu = listOf(
                MenuItem("Ribeye Steak", 18.0, "Juicy ribeye", "https://images.unsplash.com/photo-1551183053-bf91a1d81141"),
                MenuItem("Sirloin Steak", 16.0, "Tender sirloin", "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"),
                MenuItem("Flat Iron Steak", 14.0, "Signature steak", "https://images.unsplash.com/photo-1555992336-03a23c7b20ee"),
                MenuItem("Steak & Eggs", 12.0, "Classic combo", "https://images.unsplash.com/photo-1504674900247-0877df9cc836"),
                MenuItem("Garlic Butter Steak", 17.0, "Rich flavor", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Fries", 5.0, "Crispy fries", "https://images.unsplash.com/photo-1541592106381-b31e9677c0e5"),
                MenuItem("Steak Sandwich", 11.0, "Loaded sandwich", "https://images.unsplash.com/photo-1550547660-d9450f859349"),
                MenuItem("Mac & Cheese", 7.0, "Cheesy pasta", "https://images.unsplash.com/photo-1604908554023-85b9c8bcae55"),
                MenuItem("Onion Rings", 6.0, "Crunchy rings", "https://images.unsplash.com/photo-1550547660-d9450f859349"),
                MenuItem("Chocolate Cake", 6.5, "Dessert", "https://images.unsplash.com/photo-1578985545062-69928b1d9587")
            ),

            reviews = listOf(
                Review("Mark", 4.6, "Great steaks!", "2026-04-01"),
                Review("Lucy", 4.7, "Affordable and tasty", "2026-04-02"),
                Review("Tom", 4.5, "Good service", "2026-04-03"),
                Review("Anna", 4.8, "Loved it!", "2026-04-04"),
                Review("Chris", 4.6, "Best steakhouse!", "2026-04-05")
            )
        ),

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

            menu = listOf(
                MenuItem("Butter Chicken Masala", 18.0, "Rich creamy curry", "https://images.unsplash.com/photo-1603894584373-5ac82b2ae398"),
                MenuItem("Lamb Rogan Josh", 20.0, "Spicy lamb curry", "https://images.unsplash.com/photo-1600628422019-6b8c0c9b3c9c"),
                MenuItem("Paneer Butter Masala", 15.0, "Vegetarian delight", "https://images.unsplash.com/photo-1601050690597-df0568f70950"),
                MenuItem("Chicken Tikka", 17.0, "Grilled chicken", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Dal Tadka", 12.0, "Yellow lentils", "https://images.unsplash.com/photo-1625944237212-9d98a8e1e2ef"),
                MenuItem("Garlic Naan", 5.5, "Soft naan", "https://images.unsplash.com/photo-1605475121337-6b4b8e79c9f2"),
                MenuItem("Vegetable Biryani", 14.0, "Veg rice dish", "https://images.unsplash.com/photo-1626132647523-66a9c54e07c2"),
                MenuItem("Tandoori Prawns", 22.0, "Grilled prawns", "https://images.unsplash.com/photo-1553621042-f6e147245754"),
                MenuItem("Masala Chai", 4.0, "Indian tea", "https://images.unsplash.com/photo-1589308078054-8326b3e5d4d2"),
                MenuItem("Rasmalai", 7.0, "Milk dessert", "https://images.unsplash.com/photo-1627308595229-7830a5c91f9f")
            ),

            reviews = listOf(
                Review("Arjun", 4.9, "Fine dining experience!", "2026-04-01"),
                Review("Emily", 4.8, "Best Indian food ever!", "2026-04-02"),
                Review("Raj", 4.7, "Authentic flavors", "2026-04-03"),
                Review("Sophia", 4.9, "Loved everything!", "2026-04-04"),
                Review("James", 4.8, "Worth every penny", "2026-04-05")
            )
        ),

        Restaurant(
            id = "4",
            name = "Padella Borough Market",
            image = "https://images.unsplash.com/photo-1528605248644-14dd04022da1",
            rating = 4.8,
            cuisine = "Italian",
            city = "London",
            address = "6 Southwark St",
            description = "Fresh handmade pasta",
            priceRange = "££",
            openTime = "11:30 AM",
            closeTime = "10:00 PM",
            phone = "+44 20 3602 7000",
            trending = false,
            latitude = 51.5055,
            longitude = -0.0904,
            isOpen = true,

            menu = listOf(
                MenuItem("Spaghetti Carbonara", 13.0, "Classic Italian pasta", "https://images.unsplash.com/photo-1608759266118-b8d9c7d7a1a4"),
                MenuItem("Pesto Pasta", 12.5, "Basil pesto sauce", "https://images.unsplash.com/photo-1523986371872-9d3ba2e2f642"),
                MenuItem("Lasagna", 14.0, "Layered pasta dish", "https://images.unsplash.com/photo-1603133872878-684f208fb84b"),
                MenuItem("Fettuccine Alfredo", 13.5, "Creamy pasta", "https://images.unsplash.com/photo-1621996346565-e3dbc353d2e5"),
                MenuItem("Margherita Pizza", 11.0, "Classic pizza", "https://images.unsplash.com/photo-1548365328-9f547fb0953d"),
                MenuItem("Bruschetta", 7.0, "Toasted bread starter", "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38"),
                MenuItem("Mushroom Risotto", 12.0, "Creamy rice dish", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Garlic Bread", 5.0, "Side dish", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Tiramisu", 6.5, "Coffee dessert", "https://images.unsplash.com/photo-1571877227200-a0d98ea607e9"),
                MenuItem("Gelato", 5.0, "Italian ice cream", "https://images.unsplash.com/photo-1563805042-7684c019e1cb")
            ),

            reviews = listOf(
                Review("Luca", 4.8, "Authentic Italian pasta!", "2026-04-01"),
                Review("Maria", 4.9, "Loved the carbonara", "2026-04-02"),
                Review("John", 4.7, "Great ambiance", "2026-04-03"),
                Review("Emma", 4.8, "Delicious food", "2026-04-04"),
                Review("Oliver", 4.9, "Highly recommended!", "2026-04-05")
            )
        ),

        Restaurant(
            id = "5",
            name = "Rudy's Pizza Manchester",
            image = "https://images.unsplash.com/photo-1548365328-9f547fb0953d",
            rating = 4.8,
            cuisine = "Pizza",
            city = "Manchester",
            address = "9 Cotton St",
            description = "Authentic Neapolitan pizza",
            priceRange = "££",
            openTime = "12:00 PM",
            closeTime = "11:00 PM",
            phone = "+44 161 832 4664",
            trending = true,
            latitude = 53.4839,
            longitude = -2.2446,
            isOpen = true,

            menu = listOf(
                MenuItem("Margherita Pizza", 9.0, "Classic tomato & cheese", "https://images.unsplash.com/photo-1548365328-9f547fb0953d"),
                MenuItem("Pepperoni Pizza", 11.0, "Loaded pepperoni", "https://images.unsplash.com/photo-1601924582975-7e43e4c8e0b4"),
                MenuItem("Napoli Pizza", 12.0, "Anchovies & olives", "https://images.unsplash.com/photo-1594007654729-407eedc4be65"),
                MenuItem("Four Cheese Pizza", 11.5, "Cheese lovers delight", "https://images.unsplash.com/photo-1603079845281-6e9e4c1c5bfa"),
                MenuItem("BBQ Chicken Pizza", 13.0, "Chicken & BBQ sauce", "https://images.unsplash.com/photo-1601924928376-7e76c2c9b76f"),
                MenuItem("Vegetarian Pizza", 10.5, "Fresh veggies", "https://images.unsplash.com/photo-1593560708920-61dd98c46a4e"),
                MenuItem("Garlic Bread", 5.0, "Side dish", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Pasta Arrabiata", 9.5, "Spicy pasta", "https://images.unsplash.com/photo-1523986371872-9d3ba2e2f642"),
                MenuItem("Tiramisu", 6.0, "Italian dessert", "https://images.unsplash.com/photo-1571877227200-a0d98ea607e9"),
                MenuItem("Lemonade", 3.5, "Refreshing drink", "https://images.unsplash.com/photo-1551024601-bec78aea704b")
            ),

            reviews = listOf(
                Review("Jack", 4.8, "Best pizza in Manchester!", "2026-04-01"),
                Review("Sophia", 4.9, "Loved the crust!", "2026-04-02"),
                Review("Leo", 4.7, "Authentic Italian taste", "2026-04-03"),
                Review("Mia", 4.8, "Great atmosphere", "2026-04-04"),
                Review("Noah", 4.9, "Highly recommend!", "2026-04-05")
            )
        ),

        Restaurant(
            id = "6",
            name = "Bundobust Manchester",
            image = "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d",
            rating = 4.7,
            cuisine = "Indian Street Food",
            city = "Manchester",
            address = "61 Piccadilly",
            description = "Indian street food & craft beer",
            priceRange = "££",
            openTime = "11:00 AM",
            closeTime = "11:00 PM",
            phone = "+44 161 359 6757",
            trending = false,
            latitude = 53.4808,
            longitude = -2.2426,
            isOpen = true,

            menu = listOf(
                MenuItem("Pav Bhaji", 8.5, "Spicy mashed veggies with bread", "https://images.unsplash.com/photo-1626132647523-66a9c54e07c2"),
                MenuItem("Vada Pav", 6.0, "Indian burger", "https://images.unsplash.com/photo-1631515242808-497c3fbd3977"),
                MenuItem("Samosa Chaat", 7.0, "Crunchy & tangy", "https://images.unsplash.com/photo-1601050690597-df0568f70950"),
                MenuItem("Paneer Wrap", 9.0, "Grilled paneer wrap", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Chole Kulcha", 8.0, "Spicy chickpeas", "https://images.unsplash.com/photo-1626132647523-66a9c54e07c2"),
                MenuItem("Dahi Puri", 6.5, "Sweet & spicy snack", "https://images.unsplash.com/photo-1601050690597-df0568f70950"),
                MenuItem("Masala Fries", 5.5, "Indian style fries", "https://images.unsplash.com/photo-1541592106381-b31e9677c0e5"),
                MenuItem("Butter Naan", 4.0, "Soft bread", "https://images.unsplash.com/photo-1605475121337-6b4b8e79c9f2"),
                MenuItem("Mango Lassi", 4.5, "Sweet yogurt drink", "https://images.unsplash.com/photo-1626082927389-6cd097cdc6ec"),
                MenuItem("Gulab Jamun", 5.5, "Dessert", "https://images.unsplash.com/photo-1627308595229-7830a5c91f9f")
            ),

            reviews = listOf(
                Review("Aman", 4.7, "Amazing street food!", "2026-04-01"),
                Review("Olivia", 4.8, "Loved the pav bhaji", "2026-04-02"),
                Review("Ethan", 4.6, "Great flavors", "2026-04-03"),
                Review("Isla", 4.7, "Nice concept", "2026-04-04"),
                Review("Liam", 4.8, "Will visit again!", "2026-04-05")
            )
        ),

        Restaurant(
            id = "7",
            name = "Almost Famous Leeds",
            image = "https://images.unsplash.com/photo-1550547660-d9450f859349",
            rating = 4.6,
            cuisine = "Burgers",
            city = "Leeds",
            address = "23-25 Great George St",
            description = "Famous for loaded burgers",
            priceRange = "££",
            openTime = "12:00 PM",
            closeTime = "10:30 PM",
            phone = "+44 113 244 9444",
            trending = false,
            latitude = 53.8013,
            longitude = -1.5486,
            isOpen = true,

            menu = listOf(
                MenuItem("Classic Cheeseburger", 9.5, "Beef patty with cheese", "https://images.unsplash.com/photo-1550547660-d9450f859349"),
                MenuItem("Double Beef Burger", 12.0, "Two patties loaded", "https://images.unsplash.com/photo-1568901346375-23c9450c58cd"),
                MenuItem("Chicken Burger", 10.0, "Crispy chicken burger", "https://images.unsplash.com/photo-1606755962773-d324e2db3f6f"),
                MenuItem("BBQ Bacon Burger", 11.5, "Smoky bacon burger", "https://images.unsplash.com/photo-1550547660-d9450f859349"),
                MenuItem("Veggie Burger", 9.0, "Plant-based patty", "https://images.unsplash.com/photo-1544025162-d76694265947"),
                MenuItem("Loaded Fries", 6.5, "Cheese & bacon fries", "https://images.unsplash.com/photo-1541592106381-b31e9677c0e5"),
                MenuItem("Onion Rings", 5.5, "Crispy rings", "https://images.unsplash.com/photo-1550547660-d9450f859349"),
                MenuItem("Milkshake", 4.5, "Chocolate shake", "https://images.unsplash.com/photo-1572490122747-3968b75cc699"),
                MenuItem("Hot Wings", 7.0, "Spicy wings", "https://images.unsplash.com/photo-1606755962773-d324e2db3f6f"),
                MenuItem("Brownie", 5.0, "Chocolate dessert", "https://images.unsplash.com/photo-1606313564200-e75d5e30476c")
            ),

            reviews = listOf(
                Review("Jake", 4.6, "Best burgers in Leeds!", "2026-04-01"),
                Review("Emily", 4.7, "Loved the loaded fries", "2026-04-02"),
                Review("Ryan", 4.5, "Juicy burgers", "2026-04-03"),
                Review("Chloe", 4.6, "Great vibe", "2026-04-04"),
                Review("Harry", 4.7, "Must try place!", "2026-04-05")
            )
        ),
        Restaurant(
            id = "8",
            name = "Sushi Samba London",
            image = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c",
            rating = 4.7,
            cuisine = "Japanese",
            city = "London",
            address = "Heron Tower, London",
            description = "Japanese-Brazilian fusion dining",
            priceRange = "£££",
            openTime = "12:00 PM",
            closeTime = "11:30 PM",
            phone = "+44 20 3640 7330",
            trending = true,
            latitude = 51.516,
            longitude = -0.081,
            isOpen = true,

            menu = listOf(
                MenuItem("Salmon Sushi", 12.0, "Fresh salmon sushi", "https://images.unsplash.com/photo-1553621042-f6e147245754"),
                MenuItem("Tuna Roll", 13.0, "Classic tuna roll", "https://images.unsplash.com/photo-1562158070-57f4b7f1f6c6"),
                MenuItem("Tempura Shrimp", 11.5, "Crispy shrimp", "https://images.unsplash.com/photo-1553621042-f6e147245754"),
                MenuItem("Chicken Teriyaki", 14.0, "Sweet glazed chicken", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Ramen Bowl", 13.5, "Hot noodle soup", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Avocado Roll", 10.0, "Veg sushi", "https://images.unsplash.com/photo-1562158070-57f4b7f1f6c6"),
                MenuItem("Sashimi Platter", 18.0, "Assorted fish", "https://images.unsplash.com/photo-1553621042-f6e147245754"),
                MenuItem("Miso Soup", 4.0, "Light soup", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Green Tea Ice Cream", 5.5, "Dessert", "https://images.unsplash.com/photo-1563805042-7684c019e1cb"),
                MenuItem("Matcha Latte", 4.5, "Japanese drink", "https://images.unsplash.com/photo-1551024601-bec78aea704b")
            ),

            reviews = listOf(
                Review("Kenji", 4.8, "Amazing sushi quality!", "2026-04-01"),
                Review("Sophia", 4.7, "Loved the fusion menu", "2026-04-02"),
                Review("Liam", 4.6, "Great presentation", "2026-04-03"),
                Review("Emma", 4.7, "Fresh and tasty", "2026-04-04"),
                Review("Oliver", 4.8, "Premium experience", "2026-04-05")
            )
        ),
        Restaurant(
            id = "9",
            name = "The Ivy London",
            image = "https://images.unsplash.com/photo-1414235077428-338989a2e8c0",
            rating = 4.5,
            cuisine = "British",
            city = "London",
            address = "1-5 West St, London",
            description = "Classic British fine dining experience",
            priceRange = "£££",
            openTime = "10:00 AM",
            closeTime = "11:30 PM",
            phone = "+44 20 7836 4751",
            trending = false,
            latitude = 51.512,
            longitude = -0.127,
            isOpen = true,

            menu = listOf(
                MenuItem("Fish & Chips", 14.0, "Classic British dish", "https://images.unsplash.com/photo-1576777647209-e8733d7b851d"),
                MenuItem("Roast Chicken", 16.5, "Served with vegetables", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Steak Pie", 15.0, "Traditional pie", "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"),
                MenuItem("Shepherd’s Pie", 13.5, "Lamb & mashed potatoes", "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"),
                MenuItem("Caesar Salad", 9.0, "Fresh salad", "https://images.unsplash.com/photo-1550304943-4f24f54ddde9"),
                MenuItem("Grilled Salmon", 17.0, "Healthy option", "https://images.unsplash.com/photo-1467003909585-2f8a72700288"),
                MenuItem("Soup of the Day", 6.5, "Chef special", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Beef Burger", 12.0, "Juicy burger", "https://images.unsplash.com/photo-1550547660-d9450f859349"),
                MenuItem("Sticky Toffee Pudding", 7.0, "Classic dessert", "https://images.unsplash.com/photo-1578985545062-69928b1d9587"),
                MenuItem("English Breakfast Tea", 4.0, "Hot beverage", "https://images.unsplash.com/photo-1589308078054-8326b3e5d4d2")
            ),

            reviews = listOf(
                Review("Oliver", 4.6, "Elegant dining experience", "2026-04-01"),
                Review("Charlotte", 4.5, "Loved the ambience", "2026-04-02"),
                Review("George", 4.4, "Great British classics", "2026-04-03"),
                Review("Amelia", 4.6, "Service was excellent", "2026-04-04"),
                Review("Henry", 4.5, "Perfect for dinner dates", "2026-04-05")
            )
        ),
        Restaurant(
            id = "10",
            name = "Hawksmoor Manchester",
            image = "https://images.unsplash.com/photo-1551183053-bf91a1d81141",
            rating = 4.7,
            cuisine = "Steakhouse",
            city = "Manchester",
            address = "184 Deansgate, Manchester",
            description = "Premium steakhouse with top-quality cuts",
            priceRange = "£££",
            openTime = "12:00 PM",
            closeTime = "11:00 PM",
            phone = "+44 161 836 6980",
            trending = true,
            latitude = 53.479,
            longitude = -2.246,
            isOpen = true,

            menu = listOf(
                MenuItem("Ribeye Steak", 22.0, "Juicy premium steak", "https://images.unsplash.com/photo-1551183053-bf91a1d81141"),
                MenuItem("Sirloin Steak", 20.0, "Tender cut", "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"),
                MenuItem("Fillet Steak", 24.0, "Lean & soft", "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"),
                MenuItem("Wagyu Beef", 30.0, "Luxury steak", "https://images.unsplash.com/photo-1551183053-bf91a1d81141"),
                MenuItem("Steak & Eggs", 16.0, "Classic combo", "https://images.unsplash.com/photo-1504674900247-0877df9cc836"),
                MenuItem("Grilled Chicken", 14.0, "Healthy option", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                MenuItem("Mac & Cheese", 8.0, "Creamy side", "https://images.unsplash.com/photo-1604908554023-85b9c8bcae55"),
                MenuItem("Fries", 5.5, "Crispy fries", "https://images.unsplash.com/photo-1541592106381-b31e9677c0e5"),
                MenuItem("Cheesecake", 7.0, "Dessert", "https://images.unsplash.com/photo-1551024506-0bccd828d307"),
                MenuItem("Red Wine", 8.0, "Premium drink", "https://images.unsplash.com/photo-1510626176961-4b37d0b73f23")
            ),

            reviews = listOf(
                Review("Daniel", 4.8, "Best steak ever!", "2026-04-01"),
                Review("Emily", 4.7, "Loved the wagyu", "2026-04-02"),
                Review("Jack", 4.6, "Perfectly cooked steaks", "2026-04-03"),
                Review("Sophia", 4.7, "Great service", "2026-04-04"),
                Review("Noah", 4.8, "Premium experience", "2026-04-05")
            )
        )
    )

    restaurants.forEach {
        db.collection("restaurants")
            .document(it.id)
            .set(it)
    }
}