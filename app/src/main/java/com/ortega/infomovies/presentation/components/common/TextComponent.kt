package com.ortega.infomovies.presentation.components.common

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextComponent(
    text: Int,
    modifier: Modifier = Modifier
) {

    Text(text = stringResource(id = text), modifier = modifier)

}

@Composable
fun TextComponent(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current
) {

    Text(text = text, modifier = modifier, color = color)

}

@Composable
fun TextComponent(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current
) {

    Text(text = text, modifier = modifier, color = color, fontSize = fontSize)

}