package com.geektech.ln7.presentation.ui.notes


import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.ln7.R
import com.geektech.ln7.databinding.FragmentNotesBinding
import com.geektech.ln7.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NotesFragment : BaseFragment<FragmentNotesBinding, NotesViewModel>(R.layout.fragment_notes){

  override val binding by viewBinding(FragmentNotesBinding::bind)
  override val viewModel by viewModels<NotesViewModel>()

  override fun setupRequest() {
    viewModel.getAllNotes()
    }

  override fun setupSubscribers() {
    viewModel.getAllNotesState.collectState(
      onError = {
        Toast.makeText(requireContext(),it, Toast.LENGTH_SHORT).show()
      },
      onLoading = {
        //binding.progress.isVisible=true
      },
      onSuccess = {

      }
    )
  }
}