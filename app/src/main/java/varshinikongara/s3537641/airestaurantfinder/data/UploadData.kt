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
                MenuItem(
                    "Butter Chicken",
                    13.5,
                    "Creamy curry",
                    "https://www.indianhealthyrecipes.com/wp-content/uploads/2022/07/chicken-butter-masala-recipe.jpg"
                ),
                MenuItem(
                    "Chicken Biryani",
                    14.0,
                    "Aromatic rice",
                    "https://www.cubesnjuliennes.com/wp-content/uploads/2020/07/Chicken-Biryani-Recipe.jpg"
                ),
                MenuItem(
                    "Paneer Tikka",
                    10.0,
                    "Grilled paneer",
                    "https://spicecravings.com/wp-content/uploads/2020/10/Paneer-Tikka-Featured-1.jpg"
                ),
                MenuItem(
                    "Masala Dosa",
                    9.0,
                    "Crispy dosa",
                    "https://vismaifood.com/storage/app/uploads/public/8b4/19e/427/thumb__1200_0_0_0_auto.jpg"
                ),
                MenuItem(
                    "Chole Bhature",
                    11.0,
                    "Spicy chickpeas",
                    "https://cdn.uengage.io/uploads/65216/image-2485-1772527191.jpg"
                ),
                MenuItem(
                    "Dal Makhani",
                    10.5,
                    "Lentil curry",
                    "https://www.funfoodfrolic.com/wp-content/uploads/2023/04/Dal-Makhani-Blog.jpg"
                ),
                MenuItem(
                    "Tandoori Chicken",
                    15.0,
                    "Grilled chicken",
                    "https://www.cubesnjuliennes.com/wp-content/uploads/2022/12/Tandoori-Chicken-Recipe.jpg"
                ),
                MenuItem(
                    "Naan Basket",
                    6.0,
                    "Indian breads",
                    "https://foodess.com/wp-content/uploads/2023/02/Butter-Naan-3.jpg"
                ),
                MenuItem(
                    "Mango Lassi",
                    5.0,
                    "Sweet drink",
                    "https://ministryofcurry.com/wp-content/uploads/2020/04/mango-lassi-2.jpg"
                ),
                MenuItem(
                    "Gulab Jamun",
                    6.5,
                    "Dessert",
                    "https://www.cookwithkushi.com/wp-content/uploads/2023/07/easy-juicy-gulab-jamun.jpg"
                )
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
                MenuItem(
                    "Ribeye Steak",
                    18.0,
                    "Juicy ribeye",
                    "https://justcook.butcherbox.com/wp-content/uploads/2019/11/Perfect-Pan-Seared-Ribeye-Steak.jpg"
                ),
                MenuItem(
                    "Sirloin Steak",
                    16.0,
                    "Tender sirloin",
                    "https://www.dinneratthezoo.com/wp-content/uploads/2019/12/sirloin-steak-4.jpg"
                ),
                MenuItem(
                    "Flat Iron Steak",
                    14.0,
                    "Signature steak",
                    "https://www.butterandthings.com/wp-content/uploads/2019/05/Grilled-Flat-Iron-Steak-Asian-Marinade.jpg"
                ),
                MenuItem(
                    "Steak & Eggs",
                    12.0,
                    "Classic combo",
                    "https://www.wholesomeyum.com/wp-content/uploads/2023/01/wholesomeyum-Steak-And-Eggs-19.jpg"
                ),
                MenuItem(
                    "Garlic Butter Steak",
                    17.0,
                    "Rich flavor",
                    "https://ohsweetbasil.com/wp-content/uploads/easy-garlic-butter-steak-at-home-6.jpg"
                ),
                MenuItem(
                    "Fries",
                    5.0,
                    "Crispy fries",
                    "https://thecozycook.com/wp-content/uploads/2020/02/Copycat-McDonalds-French-Fries-.jpg"
                ),
                MenuItem(
                    "Steak Sandwich",
                    11.0,
                    "Loaded sandwich",
                    "https://inkristaskitchen.com/wp-content/uploads/2024/08/ribeye-steak-sandwich-13-1.jpg"
                ),
                MenuItem(
                    "Mac & Cheese",
                    7.0,
                    "Cheesy pasta",
                    "https://www.yummytummyaarthi.com/wp-content/uploads/2024/01/mac-and-cheese-1.jpg"
                ),
                MenuItem(
                    "Onion Rings",
                    6.0,
                    "Crunchy rings",
                    "https://kitchenfunwithmy3sons.com/wp-content/uploads/2025/08/onion-rings-feature.jpg"
                ),
                MenuItem(
                    "Chocolate Cake",
                    6.5,
                    "Dessert",
                    "https://sugarspunrun.com/wp-content/uploads/2024/01/Chocolate-cake-recipe-1-of-1-copy.jpg"
                )
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
                MenuItem(
                    "Butter Chicken Masala",
                    18.0,
                    "Rich creamy curry",
                    "https://vismaifood.com/storage/app/uploads/public/ad2/3c9/7ee/thumb__1200_0_0_0_auto.jpg"
                ),
                MenuItem(
                    "Lamb Rogan Josh",
                    20.0,
                    "Spicy lamb curry",
                    "https://www.indianhealthyrecipes.com/wp-content/uploads/2022/04/rogan-josh.jpg"
                ),
                MenuItem(
                    "Paneer Butter Masala",
                    15.0,
                    "Vegetarian delight",
                    "https://www.indianhealthyrecipes.com/wp-content/uploads/2023/07/paneer-butter-masala-recipe.jpg"
                ),
                MenuItem(
                    "Chicken Tikka",
                    17.0,
                    "Grilled chicken",
                    "https://media-cdn.tripadvisor.com/media/photo-s/0f/a8/f2/cb/tandoori-chicken-tikka.jpg"
                ),
                MenuItem(
                    "Dal Tadka",
                    12.0,
                    "Yellow lentils",
                    "https://www.vegrecipesofindia.com/wp-content/uploads/2025/03/dal-tadka-3.jpg"
                ),
                MenuItem(
                    "Garlic Naan",
                    5.5,
                    "Soft naan",
//                    "https://images.unsplash.com/photo-1605475121337-6b4b8e79c9f2"
                    "https://kashkandhaba.com/wp-content/uploads/2025/01/plain-naan.jpg"
                ),
                MenuItem(
                    "Vegetable Biryani",
                    14.0,
                    "Veg rice dish",
                    "https://t4.ftcdn.net/jpg/05/70/58/65/360_F_570586537_TnIgWdCnaTYpgg9gsTyloz5bnvfCtdLl.jpg"
                ),
                MenuItem(
                    "Tandoori Prawns",
                    22.0,
                    "Grilled prawns",
                    "https://myfoodstory.com/wp-content/uploads/2015/06/the-best-tandoori-prawns-recipe.1024x1024-3.jpg"
                ),
                MenuItem(
                    "Masala Chai",
                    4.0,
                    "Indian tea",
                    "https://www.indianhealthyrecipes.com/wp-content/uploads/2023/05/indian-masala-chai-tea.jpg"
                ),
                MenuItem(
                    "Rasmalai",
                    7.0,
                    "Milk dessert",
                    "https://mariasmenu.com/wp-content/uploads/Rasmalai.jpg"
                )
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
                MenuItem(
                    "Spaghetti Carbonara",
                    13.0,
                    "Classic Italian pasta",
                    "https://www.fifteenspatulas.com/wp-content/uploads/2012/03/Spaghetti-Carbonara-Fifteen-Spatulas-1-640x959.jpg"
                ),
                MenuItem(
                    "Pesto Pasta",
                    12.5,
                    "Basil pesto sauce",
                    "https://assets-jpcust.jwpsrv.com/thumbnails/04u8qgh5-720.jpg"
                ),
                MenuItem(
                    "Lasagna",
                    14.0,
                    "Layered pasta dish",
                    "https://amandascookin.com/wp-content/uploads/2025/08/Italian-Lasagna-RCSQ.jpg"
                ),
                MenuItem(
                    "Fettuccine Alfredo",
                    13.5,
                    "Creamy pasta",
                    "https://www.sharmispassions.com/wp-content/uploads/2015/12/alfredopasta2.jpg"
                ),
                MenuItem(
                    "Margherita Pizza",
                    11.0,
                    "Classic pizza",
                    "https://thumbs.dreamstime.com/b/pizza-margherita-27409337.jpg"
                ),
                MenuItem(
                    "Bruschetta",
                    7.0,
                    "Toasted bread starter",
                    "https://cdn.pixabay.com/photo/2020/10/01/22/39/gourmet-5619887_1280.jpg"
                ),
                MenuItem(
                    "Mushroom Risotto",
                    12.0,
                    "Creamy rice dish",
                    "https://cdn.loveandlemons.com/wp-content/uploads/2023/01/mushroom-risotto.jpg"
                ),
                MenuItem(
                    "Garlic Bread",
                    5.0,
                    "Side dish",
                    "https://www.ambitiouskitchen.com/wp-content/uploads/2023/02/Garlic-Bread-4.jpg"
                ),
                MenuItem(
                    "Tiramisu",
                    6.5,
                    "Coffee dessert",
                    "https://t4.ftcdn.net/jpg/00/39/01/57/360_F_39015733_RlkPhCskQTJuLc8idgn7mpBajaViWqtn.jpg"
                ),
                MenuItem(
                    "Gelato",
                    5.0,
                    "Italian ice cream",
                    "https://upload.wikimedia.org/wikipedia/commons/d/d6/Gelato_ice_cream.jpg"
                )
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
                MenuItem(
                    "Margherita Pizza",
                    9.0,
                    "Classic tomato & cheese",
                    "https://t3.ftcdn.net/jpg/04/44/86/70/360_F_444867086_79U7yvSiS6LaEWo8nN0ZYX8CJ7NhvhJh.jpg"
                ),
                MenuItem(
                    "Pepperoni Pizza",
                    11.0,
                    "Loaded pepperoni",
                    "https://www.tablefortwoblog.com/wp-content/uploads/2025/06/pepperoni-pizza-recipe-photos-tablefortwoblog-6.jpg"
                ),
                MenuItem(
                    "Napoli Pizza",
                    12.0,
                    "Anchovies & olives",
                    "https://mypizzacorner.com/wp-content/uploads/2020/12/neapolitan-pizza-authentic.jpg"
                ),
                MenuItem(
                    "Four Cheese Pizza",
                    11.5,
                    "Cheese lovers delight",
                    "https://thumbs.dreamstime.com/b/cheese-pizza-yummy-lifting-up-51994812.jpg"
                ),
                MenuItem(
                    "BBQ Chicken Pizza",
                    13.0,
                    "Chicken & BBQ sauce",
                    "https://thevirtualcaterer.com/wp-content/uploads/2024/05/BBQ-Chicken-Pizza-3.jpg"
                ),
                MenuItem(
                    "Vegetarian Pizza",
                    10.5,
                    "Fresh veggies",
                    "https://t3.ftcdn.net/jpg/00/27/57/96/360_F_27579652_tM7V4fZBBw8RLmZo0Bi8WhtO2EosTRFD.jpg"
                ),
                MenuItem(
                    "Garlic Bread",
                    5.0,
                    "Side dish",
                    "https://t4.ftcdn.net/jpg/03/19/22/35/360_F_319223572_ILWIWBuhaeyTzGPLQ0rJCVtBSGOqw864.jpg"
                ),
                MenuItem(
                    "Pasta Arrabiata",
                    9.5,
                    "Spicy pasta",
                    "https://thumbs.dreamstime.com/b/penne-arrabiata-26812149.jpg"
                ),
                MenuItem(
                    "Tiramisu",
                    6.0,
                    "Italian dessert",
                    "https://sallysbakingaddiction.com/wp-content/uploads/2024/03/tiramisu.jpg"
                ),
                MenuItem(
                    "Lemonade",
                    3.5,
                    "Refreshing drink",
                    "https://t3.ftcdn.net/jpg/02/60/17/24/360_F_260172428_nFYpkCiYQDFeR4UcRXoRaby3E5c8zhud.jpg"
                )
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
                MenuItem(
                    "Pav Bhaji",
                    8.5,
                    "Spicy mashed veggies with bread",
                    "https://shwetainthekitchen.com/wp-content/uploads/2022/07/Pav-bhaji.jpg"
                ),
                MenuItem(
                    "Vada Pav",
                    6.0,
                    "Indian burger",
                    "https://t3.ftcdn.net/jpg/05/38/15/30/360_F_538153050_hs85BVbShqsaHxG1IJrpJfLH7YJxTIaM.jpg"
                ),
                MenuItem(
                    "Samosa Chaat",
                    7.0,
                    "Crunchy & tangy",
                    "https://www.cubesnjuliennes.com/wp-content/uploads/2020/02/Samosa-Chaat.jpg"
                ),
                MenuItem(
                    "Paneer Wrap",
                    9.0,
                    "Grilled paneer wrap",
                    "https://ministryofcurry.com/wp-content/uploads/2019/10/kathi-roll_.jpg"
                ),
                MenuItem(
                    "Chole Kulcha",
                    8.0,
                    "Spicy chickpeas",
                    "https://www.englishoven.com//storage/our-recipe/special-amritsari-chole-kulche.jpg"
                ),
                MenuItem(
                    "Dahi Puri",
                    6.5,
                    "Sweet & spicy snack",
//                    "https://images.unsplash.com/photo-1601050690597-df0568f70950"
                    "https://cdn3.foodviva.com/static-content/food-images/snacks-recipes/dahi-puri/dahi-puri.jpg"
                ),
                MenuItem(
                    "Masala Fries",
                    5.5,
                    "Indian style fries",
                    "https://limethyme.com/wp-content/uploads/2021/10/Masala-fries-2.jpg"
                ),
                MenuItem(
                    "Butter Naan",
                    4.0,
                    "Soft bread",
                    "https://t4.ftcdn.net/jpg/05/48/30/85/360_F_548308594_sCT9a76T61ogh3wFrehRmhusEVq55kZ4.jpg"
                ),
                MenuItem(
                    "Mango Lassi",
                    4.5,
                    "Sweet yogurt drink",
                    "https://ministryofcurry.com/wp-content/uploads/2020/04/mango-lassi-2.jpg"
                ),
                MenuItem(
                    "Gulab Jamun",
                    5.5,
                    "Dessert",
                    "https://www.cookwithkushi.com/wp-content/uploads/2023/07/easy-juicy-gulab-jamun.jpg"

                )
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
                MenuItem(
                    "Classic Cheeseburger",
                    9.5,
                    "Beef patty with cheese",
//                    "https://images.unsplash.com/photo-1550547660-d9450f859349"
                    "https://t3.ftcdn.net/jpg/00/94/92/10/360_F_94921053_Lc06uabhNtMNSKq6H5gBhZVDoI6nKjXW.jpg"
                ),
                MenuItem(
                    "Double Beef Burger",
                    12.0,
                    "Two patties loaded",
//                    "https://images.unsplash.com/photo-1568901346375-23c9450c58cd"
                    "https://media-cdn.tripadvisor.com/media/photo-s/1c/cd/b0/1b/double-gorilla-burger.jpg"
                ),
                MenuItem(
                    "Chicken Burger",
                    10.0,
                    "Crispy chicken burger",
//                    "https://images.unsplash.com/photo-1606755962773-d324e2db3f6f"
                    "https://t3.ftcdn.net/jpg/02/19/46/78/360_F_219467809_GYKTUDodRRk1o64ZltOURhzfvEYLk6zq.jpg"
                ),
                MenuItem(
                    "BBQ Bacon Burger",
                    11.5,
                    "Smoky bacon burger",
//                    "https://images.unsplash.com/photo-1550547660-d9450f859349"
                    "https://www.shutterstock.com/image-photo/beef-burger-bbq-sauce-bacon-600nw-2471612047.jpg"
                ),
                MenuItem(
                    "Veggie Burger",
                    9.0,
                    "Plant-based patty",
//                    "https://images.unsplash.com/photo-1544025162-d76694265947"
                    "https://www.shutterstock.com/image-photo/healthy-vegan-burger-vegetables-patty-600nw-2676334163.jpg"
                ),
                MenuItem(
                    "Loaded Fries",
                    6.5,
                    "Cheese & bacon fries",
//                    "https://images.unsplash.com/photo-1541592106381-b31e9677c0e5"
                    "https://t4.ftcdn.net/jpg/09/66/52/71/360_F_966527167_xFs4xV0j3JqmacSFuy2Fze2zTulVaLJK.jpg"
                ),
                MenuItem(
                    "Onion Rings",
                    5.5,
                    "Crispy rings",
//                    "https://images.unsplash.com/photo-1550547660-d9450f859349"
                    "https://kitchenfunwithmy3sons.com/wp-content/uploads/2025/08/Onion-Rings-8.jpg"
                ),
                MenuItem(
                    "Milkshake",
                    4.5,
                    "Chocolate shake",
//                    "https://images.unsplash.com/photo-1572490122747-3968b75cc699"
                    "https://iambaker.net/wp-content/uploads/2024/06/Chocolate-Shake-2.jpg"
                ),
                MenuItem(
                    "Hot Wings",
                    7.0,
                    "Spicy wings",
//                    "https://images.unsplash.com/photo-1606755962773-d324e2db3f6f"
                    "https://www.shutterstock.com/image-photo/baked-chicken-wings-sweet-chili-600nw-2562111853.jpg"
                ),
                MenuItem(
                    "Brownie",
                    5.0,
                    "Chocolate dessert",
//                    "https://images.unsplash.com/photo-1606313564200-e75d5e30476c"

                    "https://www.shutterstock.com/image-photo/delicious-chocolate-brownies-drizzled-rich-600nw-2630747815.jpg"
                )
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
                MenuItem(
                    "Salmon Sushi",
                    12.0,
                    "Fresh salmon sushi",
//                    "https://images.unsplash.com/photo-1553621042-f6e147245754"
                    "https://timskitchen.com.hk/wp-content/uploads/2025/02/smoked-salmon-sushi-roll-recipe-1739410610.jpg"
                ),
                MenuItem(
                    "Tuna Roll",
                    13.0,
                    "Classic tuna roll",
//                    "https://images.unsplash.com/photo-1562158070-57f4b7f1f6c6"
                    "https://tastesbetterfromscratch.com/wp-content/uploads/2023/01/Spicy-Tuna-Roll-15-500x500.jpg"
                ),
                MenuItem(
                    "Tempura Shrimp",
                    11.5,
                    "Crispy shrimp",
//                    "https://images.unsplash.com/photo-1553621042-f6e147245754"
                    "https://cookingwithayeh.com/wp-content/uploads/2024/10/Shrimp-Tempura.jpg"
                ),
                MenuItem(
                    "Chicken Teriyaki",
                    14.0,
                    "Sweet glazed chicken",
//                    "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"
                    "https://www.budgetbytes.com/wp-content/uploads/2022/04/Teriyaki-Chicken-plate.jpg"
                ),
                MenuItem(
                    "Ramen Bowl",
                    13.5,
                    "Hot noodle soup",
//                    "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"
                    "https://thefoodiediaries.co/wp-content/uploads/2020/08/img_4288.jpg"
                ),
                MenuItem(
                    "Avocado Roll",
                    10.0,
                    "Veg sushi",
//                    "https://images.unsplash.com/photo-1562158070-57f4b7f1f6c6"
                    "https://veganeverytime.com/wp-content/uploads/2024/03/avocado-roll-2.jpg"
                ),
                MenuItem(
                    "Sashimi Platter",
                    18.0,
                    "Assorted fish",
//                    "https://images.unsplash.com/photo-1553621042-f6e147245754"
                    "https://images.stockcake.com/public/d/9/3/d93dfd65-2eca-41a9-ac38-db64feace300_large/sushi-platter-feast-stockcake.jpg"
                ),
                MenuItem(
                    "Miso Soup",
                    4.0,
                    "Light soup",
//                    "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"
                    "https://www.gimmesomeoven.com/wp-content/uploads/2016/01/Miso-Soup-Recipe-9.jpg"
                ),
                MenuItem(
                    "Green Tea Ice Cream",
                    5.5,
                    "Dessert",
//                    "https://images.unsplash.com/photo-1563805042-7684c019e1cb"
                    "https://www.wandercooks.com/wp-content/uploads/2022/03/matcha-green-tea-ice-cream-5-683x1024.jpg"
                ),
                MenuItem(
                    "Matcha Latte",
                    4.5,
                    "Japanese drink",
//                    "https://images.unsplash.com/photo-1551024601-bec78aea704b"
                    "https://t3.ftcdn.net/jpg/00/91/64/92/360_F_91649245_JHaPrH7LUaW24Sj6HxSVNW7MTObEyJv8.jpg"
                )
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
                MenuItem(
                    "Fish & Chips",
                    14.0,
                    "Classic British dish",
//                    "https://images.unsplash.com/photo-1576777647209-e8733d7b851d"
                    "https://t3.ftcdn.net/jpg/02/06/81/46/360_F_206814646_CmvG1Siwa7kZSHbse5jaFxLhU9IcO3kR.jpg"
                ),
                MenuItem(
                    "Roast Chicken",
                    16.5,
                    "Served with vegetables",
//                    "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"
                    "https://sinfullyspicy.com/wp-content/uploads/2024/11/4-1.jpg"
                ),
                MenuItem(
                    "Steak Pie",
                    15.0,
                    "Traditional pie",
//                    "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"
                    "https://www.kitchensanctuary.com/wp-content/uploads/2015/01/Steak-Pie-square-FS-1.jpg"
                ),
                MenuItem(
                    "Shepherd’s Pie",
                    13.5,
                    "Lamb & mashed potatoes",
//                    "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"
                    "https://www.thewholesomedish.com/wp-content/uploads/2019/02/The-Best-Classic-Shepherds-Pie-550.jpg"
                ),
                MenuItem(
                    "Caesar Salad",
                    9.0,
                    "Fresh salad",
//                    "https://images.unsplash.com/photo-1550304943-4f24f54ddde9"
                    "https://www.shutterstock.com/image-photo/caesar-salad-crisp-romaine-lettuce-600nw-2602838707.jpg"
                ),
                MenuItem(
                    "Grilled Salmon",
                    17.0,
                    "Healthy option",
//                    "https://images.unsplash.com/photo-1467003909585-2f8a72700288"
                    "https://t3.ftcdn.net/jpg/03/25/35/08/360_F_325350805_D8PVU73qs1dj5TdWgm9IpuAjJ7sgHacK.jpg"
                ),
                MenuItem(
                    "Soup of the Day",
                    6.5,
                    "Chef special",
//                    "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"
                    "https://t4.ftcdn.net/jpg/01/89/24/55/360_F_189245562_6EzNC89ioTLoiL9fLiEWedIRedA0R8IN.jpg"
                ),
                MenuItem(
                    "Beef Burger",
                    12.0,
                    "Juicy burger",
//                    "https://images.unsplash.com/photo-1550547660-d9450f859349"
                    "https://t4.ftcdn.net/jpg/02/74/99/01/360_F_274990113_ffVRBygLkLCZAATF9lWymzE6bItMVuH1.jpg"
                ),
                MenuItem(
                    "Sticky Toffee Pudding",
                    7.0,
                    "Classic dessert",
//                    "https://images.unsplash.com/photo-1578985545062-69928b1d9587"
                    "https://www.rainbownourishments.com/wp-content/uploads/2024/12/vegan-sticky-toffee-pudding-4.jpg"
                ),
                MenuItem(
                    "English Breakfast Tea",
                    4.0,
                    "Hot beverage",
//                    "https://images.unsplash.com/photo-1589308078054-8326b3e5d4d2"
                    "https://cdnimg.webstaurantstore.com/images/products/large/870822/3037294.jpg"
                )
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
                MenuItem(
                    "Ribeye Steak",
                    22.0,
                    "Juicy premium steak",
//                    "https://images.unsplash.com/photo-1551183053-bf91a1d81141"
                    "https://1855beef.com/wp-content/uploads/2020/04/JBSE-1855-0420_Ribeye.jpg"
                ),
                MenuItem(
                    "Sirloin Steak",
                    20.0,
                    "Tender cut",
//                    "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"
                    "https://ichef.bbci.co.uk/food/ic/food_16x9_1600/recipes/sirloinsteakwithchun_90288_16x9.jpg"
                ),
                MenuItem(
                    "Fillet Steak",
                    24.0,
                    "Lean & soft",
//                    "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"
                    "https://www.shutterstock.com/image-photo/alberta-beef-steak-juicy-premiumcut-600nw-2637143379.jpg"
                ),
                MenuItem(
                    "Wagyu Beef",
                    30.0,
                    "Luxury steak",
//                    "https://images.unsplash.com/photo-1551183053-bf91a1d81141"
                    "https://www.thetakeout.com/img/gallery/so-what-exactly-is-wagyu-beef-anyway/l-intro-1724873729.jpg"
                ),
                MenuItem(
                    "Steak & Eggs",
                    16.0,
                    "Classic combo",
//                    "https://images.unsplash.com/photo-1504674900247-0877df9cc836"
                    "https://healthyrecipesblogs.com/wp-content/uploads/2024/10/steak-and-eggs-tomatoes.jpg"
                ),
                MenuItem(
                    "Grilled Chicken",
                    14.0,
                    "Healthy option",
//                    "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"
                    "https://nataliemarblecooks.com/wp-content/uploads/2024/07/spatchcocked-grilled-chicken-FEAT-IMG-1.jpg"
                ),
                MenuItem(
                    "Mac & Cheese",
                    8.0,
                    "Creamy side",
//                    "https://images.unsplash.com/photo-1604908554023-85b9c8bcae55"
                    "https://t3.ftcdn.net/jpg/03/03/57/62/360_F_303576213_OdvdwRF0bkM3q1IyvTLZQFKHmbkW6EWL.jpg"
                ),
                MenuItem(
                    "Fries",
                    5.5,
                    "Crispy fries",
//                    "https://images.unsplash.com/photo-1541592106381-b31e9677c0e5"
                    "https://thecozycook.com/wp-content/uploads/2018/10/Homemade-French-Fry-Recipe-.jpg"
                ),
                MenuItem(
                    "Cheesecake",
                    7.0,
                    "Dessert",
//                    "https://images.unsplash.com/photo-1551024506-0bccd828d307"
                    "https://preppykitchen.com/wp-content/uploads/2022/07/Cheesecake-Social-new.jpg"
                ),
                MenuItem(
                    "Red Wine",
                    8.0,
                    "Premium drink",
//                    "https://images.unsplash.com/photo-1510626176961-4b37d0b73f23"
                    "https://www.shutterstock.com/image-photo/pouring-red-wine-into-wineglass-600nw-2723718489.jpg"
                )
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