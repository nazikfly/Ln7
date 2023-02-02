package com.geektech.ln7.domain.usecase


import com.geektech.ln7.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    operator fun invoke() = noteRepository.getAllNotes()
}