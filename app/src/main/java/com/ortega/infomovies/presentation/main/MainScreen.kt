package com.ortega.infomovies.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.infomovies.R
import com.ortega.infomovies.presentation.components.common.TitleComponent

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {


    /*LaunchedEffect(key1 = ratedMovies.loadState) {
        if(ratedMovies.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error ${(ratedMovies.loadState.refresh as LoadState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }*/




    Scaffold(
        containerColor = Color.Black
    ) { paddingValues ->

        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {

            TitleComponent(title = R.string.upcoming) {

            }

            //UpcomingMovieList(upcomingMovies = upcomingMovies)
            
            TitleComponent(title = R.string.popular) {
                
            }
            
            //PopularMovieList(popularMovies = popularMovies)

            TitleComponent(title = R.string.rated) {

            }
            
            //RatedMovieList(ratedMovies = ratedMovies)
            

        }

    }

}