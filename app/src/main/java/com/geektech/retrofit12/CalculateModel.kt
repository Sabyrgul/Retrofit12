package com.geektech.retrofit12

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "calculateModel")

data class CalculateModel(

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName:String,
    val percentage: String,
    val result:String
):java.io.Serializable
