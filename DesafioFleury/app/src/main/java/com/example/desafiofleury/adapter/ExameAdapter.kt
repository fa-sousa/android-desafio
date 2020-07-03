package com.example.desafiofleury.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofleury.R
import com.example.desafiofleury.model.Exame

class ExameAdapter (val examesList: List<Exame>): RecyclerView.Adapter<ExameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.row_exame, parent, false)
        return ViewHolder(itemView)
    }
//
//    interface exameClickListener {
//        fun getItem(position: Int)
//    }

    override fun getItemCount(): Int {
        return examesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listaDados(examesList, position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtNome:TextView=itemView.findViewById(R.id.nomeExame)
        var txtMedico:TextView=itemView.findViewById(R.id.nomeMedico)

        fun listaDados(examesList: List<Exame>?, position: Int) {
//            txtMedico.text=examesList!!.get(position).getDoctor()

//            itemView.setOnClickListener(View.OnClickListener { it
//            itemClick.getItem(adapterPosition)
//            })
        }
    }
}