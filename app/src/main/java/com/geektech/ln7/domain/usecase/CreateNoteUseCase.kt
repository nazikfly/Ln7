package com.geektech.ln7.domain.usecase

import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
   operator fun invoke(note: Note)=noteRepository.createNote(note)
}