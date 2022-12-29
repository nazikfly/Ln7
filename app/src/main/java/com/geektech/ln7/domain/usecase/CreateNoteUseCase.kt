package com.geektech.ln7.domain.usecase

import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.repository.NoteRepository

class CreateNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun createNote(note: Note)=noteRepository.createNote(note)
}