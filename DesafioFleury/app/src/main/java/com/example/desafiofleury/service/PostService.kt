package com.example.desafiofleury.service

import com.example.desafiofleury.model.ExameModel
import retrofit2.Call
import retrofit2.http.GET

//recurso + service
interface PostService {

    @GET("results")
    fun list(): Call<List<ExameModel>>

}