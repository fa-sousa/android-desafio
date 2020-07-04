package com.example.desafiofleury.service

import com.example.desafiofleury.model.Exames
import retrofit2.Call
import retrofit2.http.GET

//recurso + service
interface ExameService {

    @GET("results")
    fun getResults() : Call<List<Exames>>

}