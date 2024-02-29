package com.example.daggermvvmnote2.network

import com.example.daggermvvmnote2.dummyModel.DummyResponseItem
import com.example.daggermvvmnote2.model.TVShowsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("most-popular")
    suspend fun getMostPopularTVShows(@Query("page") page:Int): Response<TVShowsResponse>

    @GET("posts")
    suspend fun getPosts():Response<List<DummyResponseItem>>
}