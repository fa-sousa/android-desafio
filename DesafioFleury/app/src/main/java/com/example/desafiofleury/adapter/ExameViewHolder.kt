package com.example.desafiofleury.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofleury.R

class ExameViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {

    val name: TextView = itemView!!.findViewById(R.id.nomeExame)
    val doctor: TextView = itemView!!.findViewById(R.id.nomeMedico)

}