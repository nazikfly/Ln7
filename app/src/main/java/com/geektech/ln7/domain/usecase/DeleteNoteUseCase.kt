package com.geektech.ln7.domain.usecase

import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    fun deleteNote(note: Note)= noteRepository.deleteNote()
}