package com.example.desafiofleury.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafiofleury.R
import com.example.desafiofleury.model.Exames
import com.example.desafiofleury.service.Endpoint
import com.example.desafiofleury.service.NetworkUtils
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
        val retrofitClient = NetworkUtils
            //sem o "s" a chamada não acontece (questão de segurança)
            .getRetrofitInstance("https://5bfbefa5cf9d29001345c529.mockapi.io/api/v1/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getResults()

        callback.enqueue(object : Callback<List<Exames>> {
            override fun onFailure(call: Call<List<Exames>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            //itens do array de objeto do json
            override fun onResponse(call: Call<List<Exames>>, response: Response<List<Exames>>) {
                response.body()?.forEach {
                    textView.text = textView.text.toString().plus(it.name)
                    textView.text = textView.text.toString().plus(it.doctor)
                    textView.text = textView.text.toString().plus(it.healthy)
                    textView.text = textView.text.toString().plus(it.id)
                }
            }
        })
    }




}

