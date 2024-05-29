package com.example.ecomapp.presentation.screen.categories_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.waltonbd.randomapi.presentation.categories_screen.component.CategoryItem


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: CategoriesViewModel = hiltViewModel(),
    onCategoryClick: (categoryId: String) -> Unit,
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Categories") }) }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp),
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            } else {
                Column() {
                    Text(
                        text = "Click any category to view avialable products.",
                        style = MaterialTheme.typography.displaySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(state.categories) { category ->
                            CategoryItem(
                                categoryName = category.name, onItemClick = {  //onCategoryClick(category.id.toString())
                                     navController.navigate("products_screen2/${category.id}/${category.name}")
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                    }
                }
            }

        }

    }
}