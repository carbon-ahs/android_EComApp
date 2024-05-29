package com.example.ecomapp.presentation.screen.products_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecomapp.data.local.entity.Product


/**
 * Created by Ahsan Habib on 5/29/2024.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ProductsViewModel = hiltViewModel(),
    categoryName: String = "dlft",
    categoryId: String = "-1"
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Products") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("categories_screen") }) {
                Icon(imageVector = Icons.Default.Category, contentDescription = "Category fab")
            }
        }
    ) { it ->
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            if (categoryId == "-1") {
                Text(text = "Pls select category to view products.")
            } else {
                if (state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(alignment = Alignment.Center)
                    )
                } else {
                    Column(
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Products of $categoryName.",
                            style = MaterialTheme.typography.displaySmall
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(state.products) { product ->
                                ProductItem(
                                    productName = product.name,
                                    categoryName = categoryName,
                                    onAddClick = {viewModel.onAddClick(Product(id = product.id, name = product.name, categoryName = categoryName))}
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }

                        }
                    }
                }

            }

        }
    }
}