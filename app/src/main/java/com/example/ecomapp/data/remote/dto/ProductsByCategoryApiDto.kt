package com.example.ecomapp.data.remote.dto

import com.example.ecomapp.data.local.entity.Product


data class ProductsByCategoryApiDto(
    val `data`: List<ProductDto>,
)

fun ProductsByCategoryApiDto.toProductList() : List<Product>{
    val productDtoList = data

    var listOfProduct = emptyList<Product>()

    for (productDto in productDtoList){
        listOfProduct = listOfProduct + productDto.toProduct()
    }

    return listOfProduct

}