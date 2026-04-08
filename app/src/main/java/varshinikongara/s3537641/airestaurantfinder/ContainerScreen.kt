package varshinikongara.s3537641.airestaurantfinder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Register : Screen("register")
    object HomeMain : Screen("home_main")

    object Home : Screen("home")
    object Search : Screen("search")
    object Favorites : Screen("favorites")
    object Profile : Screen("profile")

    object Detail : Screen("detail/{name}") {
        fun createRoute(name: String) = "detail/$name"
    }

}


@Composable
fun HomeMainScreen(mainNavController: NavController) {

    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(bottomNavController)
        }
    ) { padding ->

        NavHost(
            navController = bottomNavController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {

            // 🏠 Home
            composable(Screen.Home.route) {
                HomeScreen(mainNavController) // ✅ pass main nav for detail navigation
            }

            // 🔍 Search
            composable(Screen.Search.route) {
                SearchScreen(mainNavController)
            }

            // ❤️ Favorites
            composable(Screen.Favorites.route) {
                FavoritesScreen()
            }

            // 👤 Profile
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Favorites,
        Screen.Profile
    )

    // ✅ Track current route
    val currentRoute = navController
        .currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {

        items.forEach { screen ->

            NavigationBarItem(
                selected = currentRoute == screen.route, // ✅ FIX
                onClick = {
                    navController.navigate(screen.route) {

                        // ✅ Prevent multiple copies
                        popUpTo(navController.graph.startDestinationId)

                        // ✅ Avoid duplicates
                        launchSingleTop = true

                        // ✅ Restore state when reselecting
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = when (screen) {
                            Screen.Home -> Icons.Default.Home
                            Screen.Search -> Icons.Default.Search
                            Screen.Favorites -> Icons.Default.Favorite
                            Screen.Profile -> Icons.Default.Person
                            else -> Icons.Default.Home
                        },
                        contentDescription = screen.route
                    )
                },
                label = {
                    Text(screen.route.replaceFirstChar { it.uppercase() })
                }
            )
        }
    }
}




@Composable
fun FavoritesScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Favorites")
    }
}


@Composable
fun ProfileScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Profile")
    }
}