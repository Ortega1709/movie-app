package com.ortega.infomovies.presentation.components.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ortega.infomovies.presentation.theme.InfoMoviesTheme

@Composable
fun VoteComponent(vote: Double, voteCount: Int) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconComponent(
            imageVector = Icons.Rounded.Star,
            tint = Color.Yellow,
            modifier = Modifier.size(15.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        TextComponent(text = "$vote", color = Color.Yellow, fontSize = 12.sp)
        Spacer(modifier = Modifier.width(4.dp))
        TextComponent(text = "($voteCount)", color = Color.White.copy(alpha = 0.6f), fontSize = 12.sp)
    }
}

@Preview
@Composable
fun VoteComponentPreview() {
    InfoMoviesTheme {
        VoteComponent(vote = 9.0, voteCount = 2501)
    }
}