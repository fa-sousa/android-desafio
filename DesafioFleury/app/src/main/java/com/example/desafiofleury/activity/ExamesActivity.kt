package com.example.desafiofleury.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.desafiofleury.R
import com.example.desafiofleury.adapter.ExameAdapter
import com.example.desafiofleury.model.Exames
import com.example.desafiofleury.service.ExameService
import com.example.desafiofleury.service.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_exames.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExamesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exames)

        //Retrofit
        getData()
    }

    fun getData() {
        val retrofitClient = RetrofitInitializer
            .getRetrofitInstance("https://5bfbefa5cf9d29001345c529.mockapi.io/api/v1/")

        val exameService = retrofitClient.create(ExameService::class.java)
        val callback = exameService.getResults()

        callback.enqueue(object : Callback<List<Exames>> {
            override fun onFailure(call: Call<List<Exames>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            //itens do array de objeto do json
            override fun onResponse(call: Call<List<Exames>>, response: Response<List<Exames>>) {

                response?.body()?.let {
                    val exames: List<Exames> = it
                    configureList(exames)
                }
            }
        })
    }

    private fun configureList(exames: List<Exames>) {
        val recyclerView = recyclerview
        recyclerView.adapter = ExameAdapter(exames, this)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }
}