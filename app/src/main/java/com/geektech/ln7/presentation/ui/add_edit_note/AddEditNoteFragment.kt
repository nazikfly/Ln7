package com.geektech.ln7.presentation.ui.add_edit_note
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.ln7.R
import com.geektech.ln7.databinding.FragmentAddNoteBinding
import com.geektech.ln7.domain.model.Note
import com.geektech.ln7.presentation.ui.base.BaseFragment
import com.geektech.ln7.presentation.ui.notes.NotesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditNoteFragment :
    BaseFragment<FragmentAddNoteBinding,AddEditNoteViewModel>(R.layout.fragment_add_note) {
          override val binding by viewBinding(FragmentAddNoteBinding::bind)
          override val viewModel by viewModels<AddEditNoteViewModel>()
          private var note:Note?=null

    override fun initialize() {
        note = arguments?.getSerializable(NotesFragment.ARG_EDIT_NOTE) as Note
        if (note!=null){
            binding.etTitle.setText(note!!.title)
            binding.etDescription.setText(note!!.descriptor)
        }
    }
    override fun setupListeners() {
        binding.btnSave.setOnClickListener{
            if (note==null)
            viewModel.createNote(
                Note(
                    title = binding.etTitle.text.toString(),
                    descriptor = binding.etDescription.text.toString(),
                    ceateAt = System.currentTimeMillis()
                )
            )
        else {
            viewModel.editNote(
                Note(
                    title = binding.etTitle.text.toString(),
                    descriptor = binding.etDescription.text.toString(),
                    ceateAt = System.currentTimeMillis()
                )
            ) }
    }
    }
     override fun setupSubscribers() {
        viewModel.createNoteState.collectState(
            onLoading = {

            },
            onSuccess = {

            },
            onError = {
                findNavController().navigateUp()

            }
        )
        viewModel.editNoteState.collectState(
            onLoading = {

            },
            onSuccess = {

            },
            onError = {
               findNavController().navigateUp()
            }
        )
    }

}

