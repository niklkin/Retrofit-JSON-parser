package com.example.testtaskforconstanta.retrofit

import com.example.testtaskforconstanta.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/constanta-android-dev/intership-wellcome-task/main/films.json")

    fun getMovieList(): Call<MovieResponse>

}