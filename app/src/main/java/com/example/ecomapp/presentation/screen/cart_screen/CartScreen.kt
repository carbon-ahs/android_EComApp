package com.example.ecomapp.presentation.screen.cart_screen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.presentation.screen.cart_screen.component.CartItem


/**
 * Created by Ahsan Habib on 5/29/2024.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val products = viewModel.state.value.cartItemList
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text(text = "Cart") }) }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Products from cart.",
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (products == emptyList<Product>()) {
                Box(
                    modifier = Modifier.fillMaxSize()

                ) {
                    Text(
                        text = "There is no item in cart!!!",
                        modifier = Modifier.align(alignment = Alignment.Center),
                        fontSize = 20.sp
                    )

                }
            } else {

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(products) { product ->
                        CartItem(
                            product = product,
                            onDeleteClick = { viewModel.onDeleteClick(product) }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

