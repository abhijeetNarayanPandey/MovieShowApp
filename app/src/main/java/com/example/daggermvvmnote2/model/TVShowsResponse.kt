package com.example.daggermvvmnote2.model

import com.google.gson.annotations.SerializedName

data class TVShowsResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val total: Int              ,
    @SerializedName("tv_shows")
    val tv_shows: List<TVShow>
)