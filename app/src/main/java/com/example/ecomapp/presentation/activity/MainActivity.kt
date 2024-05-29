package com.example.ecomapp.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecomapp.presentation.screen.LandingScreen
import com.example.ecomapp.presentation.screen.cart_screen.CartScreen
import com.example.ecomapp.presentation.screen.categories_screen.CategoriesScreen
import com.example.ecomapp.presentation.screen.products_screen.ProductsScreen
import com.example.ecomapp.presentation.ui.theme.EComAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EComAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "landing_screen") {
                    composable(
                        route = "landing_screen"
                    ) {
                        LandingScreen(
                            navController = navController,
                        )
                    }
                    composable(
                        route = "categories_screen"
                    ) {
                        CategoriesScreen(
                            navController = navController,

                            ) {
                            navController.navigate("products_screen2/${it}")
                        }
                    }
                    composable(
                        route = "product_screen"
                    ) {
                        ProductsScreen(
                            navController = navController,
                        )
                    }
                    composable(
                        route = "cart_screen"
                    ) {
                        CartScreen(
                            navController = navController,
                        )
                    }
                    composable(
                        route = "products_screen2/{categoryId}/{categoryName}",
                        arguments = listOf(
                            navArgument("categoryId") {
                                type = NavType.StringType
                            },
                            navArgument("categoryName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val categoryId = it.arguments?.getString("categoryId") ?: "-2"
                        val categoryName = it.arguments?.getString("categoryName") ?: "-2"
                        ProductsScreen(
                            navController = navController,
                            categoryId = categoryId,
                            categoryName = categoryName
                        )

                    }
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    CategoriesScreen(
//                        navController = navController,
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                }
            }
        }
    }
}



