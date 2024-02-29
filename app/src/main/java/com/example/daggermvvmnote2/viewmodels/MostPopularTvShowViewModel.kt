package com.example.daggermvvmnote2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggermvvmnote2.Resource
import com.example.daggermvvmnote2.dummyModel.DummyResponseItem
import com.example.daggermvvmnote2.model.TVShowsResponse
import com.example.daggermvvmnote2.repository.MostPopularTvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class MostPopularTvShowViewModel@Inject constructor(val repository: MostPopularTvShowRepository):ViewModel(){
    /*val _mostPopular:MutableLiveData<TVShowsResponse> = MutableLiveData()
    val mostPopularPage = 1*/
    val _postResponse:MutableLiveData<Resource<List<DummyResponseItem>>> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.IO){
            delay(5000)
   //       repository.getTvResponse(mostPopularPage)
            repository.getPosts()
        }
    }

 /*   val mostPopular : LiveData<TVShowsResponse>
        get() = repository.mostPopular*/
    val postResponse : LiveData<Resource<List<DummyResponseItem>>>
    get() = _postResponse
}

