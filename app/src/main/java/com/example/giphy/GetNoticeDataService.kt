package com.example.giphy

import android.telecom.Call
import retrofit2.http.GET


interface GetNoticeDataService {
//    @GET("NgJVa8")
    @GET("v1/gifs/search?q=all&api_key=dc6zaTOxFJmzC")
    fun noticeData(): retrofit2.Call<NoticeList?>?
}