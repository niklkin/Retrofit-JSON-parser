package com.example.testtaskforconstanta.model

import com.google.gson.annotations.SerializedName

//@Parcelize
data class MovieResponse(
    @SerializedName("items")
    val movies : List<Movie>

)// : Parcelable {
//    constructor() : this(mutableListOf())
//}