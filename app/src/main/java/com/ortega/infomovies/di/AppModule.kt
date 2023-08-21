package com.ortega.infomovies.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.ortega.infomovies.data.datasource.local.MovieDB
import com.ortega.infomovies.data.datasource.remote.MovieAPI
import com.ortega.infomovies.data.datasource.remote.mediators.PopularMovieRemoteMediator
import com.ortega.infomovies.data.datasource.remote.mediators.RatedMovieRemoteMediator
import com.ortega.infomovies.data.repository.MovieRepository
import com.ortega.infomovies.domain.entity.PopularMovieEntity
import com.ortega.infomovies.domain.entity.RatedMovieEntity
import com.ortega.infomovies.util.Constants.API_KEY
import com.ortega.infomovies.util.Constants.BASE_URL
import com.ortega.infomovies.util.Constants.PER_PAGE
import com.ortega.infomovies.util.Constants.READ_KEY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        val client = OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder()
                    .addHeader("content-type", "application/json;charset=utf-8")
                    .addHeader("x-api-key", API_KEY)
                    .addHeader("Authorization", READ_KEY)
                    .build()

                it.proceed(request)
            }.build()

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideMovieAPI(retrofit: Retrofit): MovieAPI {
        return retrofit.create(MovieAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideBeerDB(@ApplicationContext context: Context): MovieDB {
        return Room.databaseBuilder(
            context = context,
            klass = MovieDB::class.java,
            name = "movie.db"
        ).build()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Singleton
    @Provides
    fun providePopularMoviePager(
        movieDB: MovieDB,
        movieRepository: MovieRepository
    ): Pager<Int, PopularMovieEntity> {

        return Pager(
            config = PagingConfig(pageSize = PER_PAGE),
            remoteMediator = PopularMovieRemoteMediator(
                movieDB = movieDB,
                movieRepository = movieRepository
            ),
            pagingSourceFactory = { movieDB.movieDAO().pagingSourcePopularMovie() }
        )
    }

    @OptIn(ExperimentalPagingApi::class)
    @Singleton
    @Provides
    fun provideRatedMoviePager(
        movieDB: MovieDB,
        movieRepository: MovieRepository
    ): Pager<Int, RatedMovieEntity> {

        return Pager(
            config = PagingConfig(pageSize = PER_PAGE),
            remoteMediator = RatedMovieRemoteMediator(
                movieDB = movieDB,
                movieRepository = movieRepository
            ),
            pagingSourceFactory = { movieDB.movieDAO().pagingSourceRatedMovie() }
        )
    }

}