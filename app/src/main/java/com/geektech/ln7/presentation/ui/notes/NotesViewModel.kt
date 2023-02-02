package com.geektech.ln7.presentation.ui.notes

import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.usecase.DeleteNoteUseCase
import com.geektech.ln7.domain.usecase.GetAllNotesUseCase
import com.geektech.ln7.presentation.ui.base.BaseViewModel
import com.geektech.ln7.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val  getAllNotesUseCase: com.geektech.ln7.domain.usecase.GetAllNotesUseCase,
    private val  deleteNoteUseCase: com.geektech.ln7.domain.usecase.DeleteNoteUseCase
): BaseViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<com.geektech.ln7.domain.model.Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _deleteNotesState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNotesState = _deleteNotesState.asStateFlow()

    fun getAllNotes() {
        getAllNotesUseCase().collectFlow(_getAllNotesState)
    }

    fun deleteNote(note: com.geektech.ln7.domain.model.Note) {

        deleteNoteUseCase(note).collectFlow(_deleteNotesState)

    }
}



