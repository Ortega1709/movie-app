package com.ortega.infomovies.util

object Constants {

    // Base urls
    const val BASE_URL = "https://api.themoviedb.org/"
    const val IMAGES_w600_h900 = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/"
    const val IMAGES_w220_h330 = "https://www.themoviedb.org/t/p/w220_and_h330_face/"

    // Endpoints
    const val GET_POPULAR_MOVIES = "/3/movie/popular"
    const val GET_RATED_MOVIES = "/3/movie/top_rated"
    const val GET_UPCOMING_MOVIES = "/3/movie/upcoming"
    const val GET_RECOMMENDED_MOVIES = "/3/movie/{movie_id}/recommendations"
    const val GET_DETAIL_MOVIES = "/3/movie/{movie_id}"
    const val SEARCH_MOVIES = "/3/search/movies"

    //
    const val MY_PREFERENCES = "settings"
    const val PER_PAGE = 20
    const val API_KEY = "f651cfe406c790bddbcd74b7f910d78f"
    const val READ_KEY = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNjUxY2ZlNDA2Yzc5MGJkZGJjZDc0YjdmOTEwZDc4ZiIsInN1YiI6IjY0ZGRjYzRmYWFlYzcxMDNmY2ZjZTcxZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.YmTrVuuF1JS8Clo6Nn7nCoRv61u1BCtK34Qqc6C3Nk8"

}