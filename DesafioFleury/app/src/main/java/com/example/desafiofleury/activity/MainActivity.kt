package com.example.desafiofleury.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiofleury.R
import com.example.desafiofleury.adapter.ExameAdapter
import com.example.desafiofleury.model.Exame
import com.example.desafiofleury.model.ExameModel
import com.example.desafiofleury.service.PostService
import com.example.desafiofleury.service.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Configuração Retrofit
        val remote =
            RetrofitClient.createService(
                PostService::class.java
            )
        val call: Call<List<ExameModel>> = remote.list()

        //fazendo uma chamada assincrona
        val response = call.enqueue(object : Callback<List<ExameModel>> {
                override fun onResponse(call: Call<List<ExameModel>>, response: Response<List<ExameModel>>) {
                response.body()
            }

            override fun onFailure(call: Call<List<ExameModel>>, t: Throwable) {
                val s = t.message
            }
        })

        //Configuração Recyclerview
    }

    private fun showData(exame: List<Exame>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ExameAdapter(exame)
        }
    }

}
