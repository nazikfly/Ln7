package com.geektech.ln7.domain.model

import java.io.Serializable


data class Note(
    val id:Int= DEFAULT_ID,
    val title:String,
    val descriptor:String,
    val ceateAt:Long
):Serializable {
    companion object{
        const val DEFAULT_ID=0
    }
}
