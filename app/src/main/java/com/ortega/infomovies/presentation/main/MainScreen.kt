package com.ortega.infomovies.presentation.main

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.ortega.infomovies.domain.model.Movie

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {

    val ratedMovies: LazyPagingItems<Movie> =
        viewModel.ratedMoviePaging.collectAsLazyPagingItems()

    val context = LocalContext.current

    LaunchedEffect(key1 = ratedMovies.loadState) {
        if(ratedMovies.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error ${(ratedMovies.loadState.refresh as LoadState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.getPopularMovies() }
            ) {
                Text(text = "Get")
            }
        }
    ) {paddingValues ->

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            if (ratedMovies.loadState.refresh is LoadState.Loading) {
                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            } else {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {

                    items(ratedMovies.itemCount) {
                        if(ratedMovies[it] != null) {
                           ListItem(headlineContent = { Text(text = ratedMovies[it]!!.title) })
                        }
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

    }

}