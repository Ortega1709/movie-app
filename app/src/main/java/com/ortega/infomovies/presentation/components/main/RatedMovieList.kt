package com.ortega.infomovies.presentation.components.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

@Composable
fun RatedMovieList(ratedMovies: LazyPagingItems<RatedMovie>) {

    if (ratedMovies.loadState.refresh is LoadState.Loading) {
        /*Column {
            CircularProgressIndicator()
        }*/
    } else {

        LazyRow {

            item {
                Spacer(modifier = Modifier.width(16.dp))
            }

            items(ratedMovies.itemCount) {
                if(ratedMovies[it] != null) {
                    MovieItemComponent(movie = ratedMovies[it]!!)
                }
                
                Spacer(modifier = Modifier.width(16.dp))
            }

            item {
                if (ratedMovies.loadState.append is LoadState.Loading) {
                    Column (
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(25.dp),
                        )

                    }

                }
            }

        }

    }

}