package com.example.testtaskforconstanta.model

import com.google.gson.annotations.SerializedName

//@Parcelize
data class Movie(
    @SerializedName("title") var title: String? = null,
    @SerializedName("directorName") var directorName: String? = null,
    @SerializedName("releaseYear") var releaseYear: String? = null,
    @SerializedName("actors") var actors: ArrayList<Actor>
) //: Parcelable {
   // constructor() : this("", "", "", parcel.write)
//}
