package com.ortega.infomovies.presentation.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

@Composable
fun TitleComponent(title: Int, onClickMore: () -> Unit) {

    ListItem(
        modifier = Modifier.fillMaxWidth(),
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent,
            headlineColor = Color.White,
            trailingIconColor = Color.White
        ),
        headlineContent = { TextComponent(text = title) },
        trailingContent = {
            IconButton(onClick = onClickMore) {
                IconComponent(imageVector = Icons.Rounded.ArrowForward)
            }
        }
    )

}