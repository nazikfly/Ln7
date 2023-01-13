package com.geektech.ln7.presentation.ui.add_edit_note
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.ln7.R
import com.geektech.ln7.databinding.FragmentAddNoteBinding
import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditNoteFragment :
    BaseFragment<FragmentAddNoteBinding,AddEditNoteViewModel>(R.layout.fragment_add_note) {
         val binding by viewBinding(FragmentAddNoteBinding::bind)
        override val viewModel by viewModels<AddEditNoteViewModel>()

    override fun setupListeners() {
        binding.btnSave.setOnClickListener{
            viewModel.createNote(
                Note(
                    title = binding.etTitle.text.toString(),
                    descriptor = binding.etDescription.text.toString(),
                    ceateAt = System.currentTimeMillis()
                )
            )
        }
    }
    override fun setupSubscribers() {
        viewModel.createNoteState.collectState(
            onLoading = {

            },
            onSuccess = {

            },
            onError = {

            }
        )
    }
}

