package com.geektech.ln7.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.domain.usecase.DeleteNoteUseCase
import com.geektech.ln7.domain.usecase.GetAllNotesUseCase
import com.geektech.ln7.domain.utils.Resource
import com.geektech.ln7.presentation.base.BaseViewModel
import com.geektech.ln7.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val  getAllNotesUseCase: GetAllNotesUseCase,
    private val  deleteNoteUseCase: DeleteNoteUseCase
): BaseViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _deleteNotesState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNotesState = _deleteNotesState.asStateFlow()

    fun getAllNotes() {
        getAllNotesUseCase().collectFlow(_getAllNotesState)
    }

    fun deleteNote(note: Note) {
            deleteNoteUseCase.deleteNote(note).collectFlow(deleteNotesState)

    }

}



