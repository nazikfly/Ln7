package com.geektech.ln7.data.repository

import com.geektech.ln7.data.local.NoteDao
import com.geektech.ln7.data.mappers.toNote
import com.geektech.ln7.data.mappers.toNoteEntity
import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao
): NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNote(note.toNoteEntity())
         }
    override fun getAllNote(): List<Note> {
        return  noteDao.getAllNotes().map { it.toNote() }
          }
    override fun editNote(note: Note) {
        noteDao.editNote(note.toNoteEntity())
          }
    override fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
          }
}
