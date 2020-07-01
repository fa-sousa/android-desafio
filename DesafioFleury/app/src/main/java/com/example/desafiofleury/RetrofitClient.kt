package com.example.desafiofleury

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Padrão de Singleton - consigo fechar o construtor da minha classe para que ninguém instancie ela
//e garante que só existe uma instancia da classe e quem gerencia é a propria classe
class RetrofitClient private constructor() {

    companion object {

        //criar as variáveis
        private lateinit var retrofit: Retrofit
        private val baseUrl = "http://5bfbefa5cf9d29001345c529.mockapi.io/api/v1/"

        private fun getRetrofitInstance(): Retrofit {

            val httpClient = OkHttpClient.Builder()
            if(!::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit
        }

        //este metodo pode ser capaz de retornar um service generico, ou seja results, posts, images, etc....
        //este S é de service
        fun <S> createService(serviceClass: Class<S>): S {
            return getRetrofitInstance().create(serviceClass)
        }

    }

}