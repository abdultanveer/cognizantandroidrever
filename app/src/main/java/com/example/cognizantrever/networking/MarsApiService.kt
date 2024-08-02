package com.example.cognizantrever.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    //.addConverterFactory(GsonConverterFactory.create())

    .baseUrl(BASE_URL)
    .build()

//create--POST read--GET update--PUT delete-DELETE

interface MarsApiService {

    @GET("photos")
   suspend fun getPhotos():String
//http.get(url/endpoint):Response

}

object MarsApi {

    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
