package com.geektech.ln7.data.repository

import com.geektech.ln7.data.local.NoteDao
import com.geektech.ln7.data.mappers.toNote
import com.geektech.ln7.data.mappers.toNoteEntity
import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.repository.NoteRepository
import com.geektech.ln7.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject


class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository {
    override fun createNote(note: Note)=flow {
           emit(Resource.Loading())
        try {
                val data= noteDao.createNote(note.toNoteEntity())
                emit(Resource.Success(data))
         }catch (ioException:IOException) {
                emit(Resource.Error(ioException.localizedMessage ?: "Unknown exception"))
            }
            }.flowOn(Dispatchers.IO)

   override fun getAllNotes()= flow {
        emit(Resource.Loading())
        try {
            val data= noteDao.getAllNotes().map{it.toNote()}
            emit(Resource.Success(data))
        }catch (ioException:IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown exception"))
        }
    }.flowOn(Dispatchers.IO)

    override fun editNote(note: Note)= flow {
        emit(Resource.Loading())
        try {
            val data= noteDao.editNote(note.toNoteEntity())
            emit(Resource.Success(data))
        }catch (ioException:IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown exception"))
                }
    }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note)=flow {
        emit(Resource.Loading())
        try {
            val data= noteDao.deleteNote(note.toNoteEntity())
            emit(Resource.Success(data))
        }catch (ioException:IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown exception"))
        }
    }.flowOn(Dispatchers.IO)
}
