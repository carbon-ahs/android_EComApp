package com.example.ecomapp.data.remote.dto

import com.example.ecomapp.domain.model.Category


data class CategoryApiDto(
    val `data`: List<CategoryDto>,
)

fun CategoryApiDto.toCategoryList() : List<Category>{
    val categoryDtoList = data

    var listOfCategory = emptyList<Category>()

    for (categoryDto in categoryDtoList){
        listOfCategory = listOfCategory + categoryDto.toCategory()
    }

    return listOfCategory

}