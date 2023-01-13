package com.geektech.ln7.domain.repository

import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note):Flow<Resource<Unit>>

    fun getAllNotes():Flow<Resource<List<Note>>>

    fun editNote(note: Note):Flow<Resource<Unit>>

    fun deleteNote(note: Note):Flow<Resource<Unit>>
}