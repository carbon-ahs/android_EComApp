package com.waltonbd.randomapi.presentation.categories_screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    categoryName: String,
    onItemClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable ( onClick =  onItemClick ),
        border = BorderStroke(2.dp, Color.Gray),
    ) {
        Row(
            modifier.padding(8.dp)
        ) {
            Text(
                text = categoryName,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

//}