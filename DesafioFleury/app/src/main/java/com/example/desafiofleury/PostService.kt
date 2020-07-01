package com.example.desafiofleury

import retrofit2.Call
import retrofit2.http.GET

//recurso + service
interface PostService {

    //prestar atenção no Call, que precisa ser do retrofit !!!
    @GET("results")
    //esta call vai fazer as modificacoes
    fun list(): Call<List<PostModel>>

}