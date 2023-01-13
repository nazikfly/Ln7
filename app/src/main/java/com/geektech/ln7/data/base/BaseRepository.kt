package com.geektech.ln7.data.base

import android.net.NetworkRequest
import com.geektech.ln7.data.mappers.toNoteEntity
import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

open class BaseRepository {

    protected fun <T> doRequest(request: suspend ()-> T )=  flow {
        emit(Resource.Loading())
        try {
            val data= request()
            emit(Resource.Success(data))
        }catch (ioException: IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown exception"))
        }
    }.flowOn(Dispatchers.IO)

}