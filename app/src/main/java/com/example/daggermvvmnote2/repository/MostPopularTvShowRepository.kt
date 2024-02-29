package com.example.daggermvvmnote2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggermvvmnote2.dummyModel.DummyResponseItem
import com.example.daggermvvmnote2.model.TVShowsResponse
import com.example.daggermvvmnote2.network.ApiService
import javax.inject.Inject

class MostPopularTvShowRepository@Inject constructor(val apiService:ApiService){
    /*private val _mostPopular = MutableLiveData<TVShowsResponse>()
    val mostPopular : LiveData<TVShowsResponse>
    get() =_mostPopular*/

   /*suspend fun getTvResponse(page:Int){
        val result = apiService.getMostPopularTVShows(page)
        if(result?.body() != null){
            _mostPopular.postValue(result.body())
        }
    }*/
    private val _postResponse = MutableLiveData<List<DummyResponseItem>>()
    val postResponse : LiveData<List<DummyResponseItem>>
    get() = _postResponse

    suspend fun getPosts(){
        val result = apiService.getPosts()
        if(result?.body() != null){
            _postResponse.postValue(result.body())
        }
    }

}