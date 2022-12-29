package com.geektech.ln7.data.local

import androidx.room.*
import com.geektech.ln7.data.model.NoteEntity

@Dao
interface NoteDao{

    @Insert
    fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes():List<NoteEntity>

    @Update
    fun editNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

}