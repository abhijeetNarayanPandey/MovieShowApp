package com.example.daggermvvmnote2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvmnote2.model.TVShowsResponse
import com.example.daggermvvmnote2.viewmodels.MostPopularTvShowViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var textView : TextView
    lateinit var viewModel:MostPopularTvShowViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        viewModel = ViewModelProvider(this).get(MostPopularTvShowViewModel::class.java)
       /* viewModel.mostPopular.observe(this, Observer {
            Log.d("Tag","Success")
        })*/
        viewModel.postResponse.observe(this, Observer { response ->
            when(response){
                is Resource.Success->
                response.data?.let {
                    Log.d("Tag", "Success")
                textView.text = it.get(0).title
                }
                is Resource.Error ->
                    Log.d("Tag","Failure")
                is Resource.Loading ->
                    Log.d("Tag","Loading")
            }

        })
    }
}