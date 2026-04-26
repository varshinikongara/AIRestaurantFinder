package varshinikongara.s3537641.airestaurantfinder

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.FirebaseFirestore
import varshinikongara.s3537641.airestaurantfinder.data.Restaurant
import varshinikongara.s3537641.airestaurantfinder.data.SearchViewModel

fun calculateDistance(
    userLat: Double,
    userLng: Double,
    restaurantLat: Double,
    restaurantLng: Double
): Double {

    val results = FloatArray(1)

    android.location.Location.distanceBetween(
        userLat,
        userLng,
        restaurantLat,
        restaurantLng,
        results
    )

    return (results[0] / 1000 ).toDouble()// km
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = viewModel()
) {

    val userCity = "London"
    val userLat = 51.5074
    val userLng = -0.1278

    var query by remember { mutableStateOf("") }

    var filterState by remember {
        mutableStateOf(
            FilterState(
                minRating = 0.0,
                cuisines = emptyList(),
                maxDistance = 20.0,
                isOpen = false
            )
        )
    }

    val sheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadRestaurants(userCity)
    }



    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                viewModel.applyFilters(
                    query,
                    filterState.minRating,
                    filterState.cuisines,
                    filterState.maxDistance,
                    filterState.isOpen,
                    userLat,
                    userLng
                )
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search restaurants...") },
            trailingIcon = {
                IconButton(onClick = { showSheet = true }) {
                    Icon(Icons.Outlined.Settings, contentDescription = "Filter")
                }
            },
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        FilterChipsPreview(filterState) {
            filterState = FilterState(0.0, emptyList(), 20.0, false)
            viewModel.applyFilters(
                query, 0.0, emptyList(), 20.0, false, userLat, userLng
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (viewModel.filteredList.isEmpty()) {

            EmptyState {
                filterState = FilterState(0.0, emptyList(), 20.0, false)
                viewModel.applyFilters(
                    query, 0.0, emptyList(), 20.0, false, userLat, userLng
                )
            }

        } else {

            LazyColumn {
                items(viewModel.filteredList) {
                    NearbyCard(it, navController)
                }
            }
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            FilterBottomSheetContent(
                currentFilters = filterState,
                onApply = {
                    filterState = it
                    viewModel.applyFilters(
                        query,
                        it.minRating,
                        it.cuisines,
                        it.maxDistance,
                        it.isOpen,
                        userLat,
                        userLng
                    )
                    showSheet = false
                }
            )
        }
    }
}


data class FilterState(
    val minRating: Double,
    val cuisines: List<String>,
    val maxDistance: Double,
    val isOpen: Boolean
)

@Composable
fun FilterChipsPreview(
    filter: FilterState,
    onClear: () -> Unit
) {

    if (
        filter.minRating == 0.0 &&
        filter.cuisines.isEmpty() &&
        !filter.isOpen &&
        filter.maxDistance == 20.0
    ) return

    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        if (filter.minRating > 0)
            AssistChip(onClick = {}, label = { Text("⭐ ${filter.minRating}+") })

        if (filter.isOpen)
            AssistChip(onClick = {}, label = { Text("Open Now") })

        if (filter.maxDistance < 20)
            AssistChip(onClick = {}, label = { Text("${filter.maxDistance.toInt()} km") })

        filter.cuisines.forEach {
            AssistChip(onClick = {}, label = { Text(it) })
        }

        AssistChip(
            onClick = onClear,
            label = { Text("Clear All") }
        )
    }
}

@Composable
fun EmptyState(onReset: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("😕 No restaurants found", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Text("Try changing filters", color = Color.Gray)

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onReset) {
            Text("Reset Filters")
        }
    }
}

@Composable
fun FilterBottomSheetContent(
    currentFilters: FilterState,
    onApply: (FilterState) -> Unit
) {

    var minRating by remember { mutableStateOf(currentFilters.minRating) }
    var maxDistance by remember { mutableStateOf(currentFilters.maxDistance) }
    var isOpen by remember { mutableStateOf(currentFilters.isOpen) }

    val selectedCuisines = remember {
        mutableStateListOf<String>().apply {
            addAll(currentFilters.cuisines)
        }
    }

    val cuisines = listOf("Indian", "Italian", "Pizza", "Burgers", "Chinese")

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Filters", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Rating: ${"%.1f".format(minRating)} ⭐")
        Slider(
            value = minRating.toFloat(),
            onValueChange = { minRating = it.toDouble() },
            valueRange = 1f..5f,
            steps = 7
        )

        Text("Distance: ${maxDistance.toInt()} km")
        Slider(
            value = maxDistance.toFloat(),
            onValueChange = { maxDistance = it.toDouble() },
            valueRange = 1f..20f
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Open Now")
            Switch(checked = isOpen, onCheckedChange = { isOpen = it })
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Cuisines")

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            cuisines.forEach { cuisine ->

                val selected = selectedCuisines.contains(cuisine)

                FilterChip(
                    selected = selected,
                    onClick = {
                        if (selected) selectedCuisines.remove(cuisine)
                        else selectedCuisines.add(cuisine)
                    },
                    label = { Text(cuisine) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onApply(
                    FilterState(
                        minRating,
                        selectedCuisines.toList(),
                        maxDistance,
                        isOpen
                    )
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Apply Filters")
        }
    }
}