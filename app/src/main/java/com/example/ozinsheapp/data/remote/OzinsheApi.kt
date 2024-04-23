package com.example.ozinsheapp.data.remote

import com.example.ozinsheapp.domain.entity.home.CategoryAgeList
import com.example.ozinsheapp.domain.entity.home.GenreList
import com.example.ozinsheapp.domain.entity.home.HomeMovies
import com.example.ozinsheapp.domain.entity.home.MoviesMain
import com.example.ozinsheapp.domain.entity.home.Screenshot
import com.example.ozinsheapp.domain.entity.home.Season
import com.example.ozinsheapp.domain.entity.home.Seasons
import com.example.ozinsheapp.domain.entity.registration.RegistrationBody
import com.example.ozinsheapp.domain.entity.registration.RegistrationResponse
import com.example.ozinsheapp.domain.entity.userhistory.Movie
import com.example.ozinsheapp.domain.entity.userhistory.UserHistoryResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface OzinsheApi {
    @POST("auth/V1/signin")
    suspend fun singIn(
        @Body body: RegistrationBody
    ): Response<RegistrationResponse>

    @POST("auth/V1/signup")
    suspend fun signUp(
        @Body body: RegistrationBody
    ): Response<RegistrationResponse>

    @GET("core/V1/history/userHistory")
    suspend fun getUserHistory(
        @Header("Authorization") token: String
    ): UserHistoryResponse

    @GET("core/V1/movies_main")
    suspend fun getMainMovies(
        @Header("Authorization") token: String
    ): MoviesMain

    @GET("core/V1/movies/main")
    suspend fun getMovies(
        @Header("Authorization") token: String
    ): HomeMovies

    @GET("core/V1/genres")
    suspend fun getGenresList(
        @Header("Authorization") token: String
    ): GenreList

    @GET("core/V1/category-ages")
    suspend fun getCategoriesAgeList(
        @Header("Authorization") token: String
    ): CategoryAgeList

    @GET("core/V1/movies/{id}")
    suspend fun getMoviesById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<Movie>

    @GET("core/V1/screenshots/{id}")
    suspend fun getScreenshots(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): List<Screenshot>

    @GET("core/V1/seasons/wa/{id}/")
    suspend fun getSeasonInfo(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<Seasons>
}