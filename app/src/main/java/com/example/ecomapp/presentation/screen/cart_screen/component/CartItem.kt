package com.example.ecomapp.presentation.screen.cart_screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ecomapp.data.local.entity.Product


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@Composable
fun CartItem(
    modifier: Modifier = Modifier,
    product: Product,
    onDeleteClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        border = BorderStroke(2.dp, Color.Gray),
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround


        ) {
            Column(
                Modifier.fillMaxWidth(.8f)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = product.categoryName ?: "",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Add",
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    .clickable { onDeleteClick() }
            )
        }
    }
}
