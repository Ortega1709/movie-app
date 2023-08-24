package com.ortega.infomovies.presentation.components.main

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ortega.infomovies.domain.model.UpcomingMovie
import com.ortega.infomovies.presentation.components.common.VoteComponent
import com.ortega.infomovies.presentation.theme.InfoMoviesTheme
import com.ortega.infomovies.util.Constants.IMAGES_w600_h900

@Composable
fun MovieItemComponent(movie: PopularMovie) {

    Column(
        modifier = Modifier.widthIn(max = 160.dp)
    ) {
        AsyncImage(
            model = IMAGES_w600_h900 + movie.posterPath,
            modifier = Modifier
                .height(210.dp)
                .width(160.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray),
            contentScale = ContentScale.Crop,
            contentDescription = null
            )
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.Transparent),
            headlineContent = {
                Text(
                    text = movie.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 15.sp,
                    color = Color.White
                )
            },
            supportingContent = {
                VoteComponent(
                    vote = movie.voteAverage,
                    voteCount = movie.voteCount
                )
            }
        )
    }

}


@Composable
fun MovieItemComponent(movie: UpcomingMovie) {

    Column(
        modifier = Modifier.widthIn(max = 160.dp)
    ) {
        AsyncImage(
            model = IMAGES_w600_h900 + movie.posterPath,
            modifier = Modifier
                .height(210.dp)
                .width(160.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.Transparent),
            headlineContent = {
                Text(
                    text = movie.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 15.sp,
                    color = Color.White
                )
            },
            supportingContent = {
                VoteComponent(
                    vote = movie.voteAverage,
                    voteCount = movie.voteCount
                )
            }
        )
    }

}

@Composable
fun MovieItemComponent(movie: RatedMovie) {

    Column(
        modifier = Modifier.widthIn(max = 160.dp)
    ) {
        AsyncImage(
            model = IMAGES_w600_h900 + movie.posterPath,
            modifier = Modifier
                .height(210.dp)
                .width(160.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.Transparent),
            headlineContent = {
                Text(
                    text = movie.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 15.sp,
                    color = Color.White
                )
            },
            supportingContent = {
                VoteComponent(
                    vote = movie.voteAverage,
                    voteCount = movie.voteCount
                )
            }
        )
    }

}


@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MovieItemPreview() {

    val movie = PopularMovie(
        id = 1,
        posterPath = "https://test.com",
        releaseDate = "2023-09-17",
        title = "Spider-Man 3",
        voteAverage = 9.00,
        voteCount = 458
    )

    InfoMoviesTheme {
        MovieItemComponent(movie = movie)
    }

}