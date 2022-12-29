package com.geektech.ln7.domain.repository

import com.geektech.ln7.domain.model.Note

interface NoteRepository {

    fun createNote(note: Note)

    fun getAllNote():List<Note>

    fun editNote(note: Note)

    fun deleteNote(note: Note)
}