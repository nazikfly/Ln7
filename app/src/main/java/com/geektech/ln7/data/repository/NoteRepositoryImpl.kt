package com.geektech.ln7.data.repository

import com.geektech.ln7.data.base.BaseRepository
import com.geektech.ln7.data.local.NoteDao
import com.geektech.ln7.data.mappers.toNote
import com.geektech.ln7.data.mappers.toNoteEntity
import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.repository.NoteRepository
import com.geektech.ln7.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject


class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toNoteEntity())
    }
   override fun getAllNotes()= doRequest {
       noteDao.getAllNotes().map { it.toNote() }
   }
    override fun editNote(note: Note)= doRequest {
        noteDao.editNote(note.toNoteEntity())
    }
    override fun deleteNote(note: Note)=doRequest {
          noteDao.deleteNote(note.toNoteEntity())
    }
}
