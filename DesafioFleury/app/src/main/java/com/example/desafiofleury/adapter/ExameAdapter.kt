package com.example.desafiofleury.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofleury.R
import com.example.desafiofleury.model.Exame
import kotlinx.android.synthetic.main.row_exame.view.*

class ExameAdapter (private val exames: List<Exame>) : RecyclerView.Adapter<ExameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =  LayoutInflater.from(parent.context).inflate(R.layout.row_exame, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = exames.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exame =  exames[position]
        holder.nomeExame.text = exame.nomeExame
        holder.nomeMedico.text = exame.nomeMedico
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeMedico: TextView = itemView.nomeMedico
        val nomeExame: TextView = itemView.nomeExame
    }
}