package com.example.desafiofleury.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofleury.R
import com.example.desafiofleury.model.Exames
import kotlinx.android.synthetic.main.list_item.view.*

class ExameAdapter(private val examesDados: List<Exames>,
                   private val context: Context) : RecyclerView.Adapter<ExameAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exame = examesDados[position]
        holder?.let {
            it.bindView(exame)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExameAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return examesDados.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("WrongConstant")
        fun bindView(exame: Exames) {

            itemView.nomeMedico.text = exame.doctor
            itemView.nomeExame.text = exame.name

            if(exame.healthy === true){
                itemView.statusVerde.visibility = 1
            } else {
                itemView.statusVermelho.visibility = 1
            }
//           itemView.imageStatus.text = exame.imageStatus
//           itemView.data.text  = exame.timestamp.toString()

        }
    }
}
