package com.geektech.ln7.domain.model


data class Note(
    val id:Int= DEFAULT_ID,
    val title:String,
    val descriptor:String,
    val ceateAt:Long
) {
    companion object{
        const val DEFAULT_ID=0
    }
}
