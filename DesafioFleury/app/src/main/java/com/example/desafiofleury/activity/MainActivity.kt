package com.example.desafiofleury.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiofleury.R
import com.example.desafiofleury.adapter.ExameAdapter
import com.example.desafiofleury.model.Exame
//import com.example.desafiofleury.model.ExameModel
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
        val call: Call<List<Exame>> = remote.list()

        //fazendo uma chamada assincrona
        val response = call.enqueue(object : Callback<List<Exame>> {
                override fun onResponse(call: Call<List<Exame>>, response: Response<List<Exame>>) {
                response.body()
            }

            override fun onFailure(call: Call<List<Exame>>, t: Throwable) {
                val s = t.message
            }
        })

        showData()
        //Configuração Recyclerview



    }

    private fun showData() {

        recyclerView.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            val exame  = ArrayList<Exame>()
            exame.add(Exame(name = "name", doctor = "doctor"))
            recyclerView.adapter = ExameAdapter(exame)

        }
    }

}
