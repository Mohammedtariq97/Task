package com.example.newsapp.NewsFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.api.ApiUserRestClient
import com.example.newsapp.model.BaseModel
import com.example.newsapp.network.RetrofitEventListener
import retrofit2.Call

class NewsViewModel :ViewModel(){
    val liveDataNews = MutableLiveData<BaseModel>()

    fun getNewsApi(){
        ApiUserRestClient.instance.getNews(object:RetrofitEventListener{
            override fun onSuccess(call: Call<*>?, response: Any?) {
                if(response is BaseModel){
                    liveDataNews.value = response
                }
            }

            override fun onError(call: Call<*>?, t: Throwable?) {
                Log.d("NewsViewModel","Error")
            }

        })
    }
}