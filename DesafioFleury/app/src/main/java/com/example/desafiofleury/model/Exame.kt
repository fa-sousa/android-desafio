package com.example.desafiofleury.model

import com.google.gson.annotations.SerializedName

data class Exames(
    @SerializedName("id")
    var id : Int,
    @SerializedName("name")
    var name : String,
    @SerializedName("doctor")
    var doctor : String,
    @SerializedName("healthy")
    var healthy : Boolean
)