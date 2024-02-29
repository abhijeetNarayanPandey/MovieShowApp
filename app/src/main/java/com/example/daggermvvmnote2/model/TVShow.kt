package com.example.daggermvvmnote2.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TVShow(
    @SerializedName("name")
    var name: String,

    @SerializedName("start_date")
    var startDate: String,
    @SerializedName("country")
    var country: String,
    @SerializedName("network")
    var network: String,

    @SerializedName("status")
    var status: String,

    @SerializedName("image_thumbnail_path")
    var thumbnail: String
): Serializable