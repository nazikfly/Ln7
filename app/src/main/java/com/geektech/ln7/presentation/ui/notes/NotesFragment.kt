package com.geektech.ln7.presentation.ui.notes

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.ln7.R
import com.geektech.ln7.databinding.FragmentNotesBinding
import com.geektech.ln7.presentation.ui.adapter.NotesAdapter
import com.geektech.ln7.presentation.ui.base.BaseFragment
import com.geektech.ln7.presentation.extension.showToast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NotesFragment : BaseFragment<FragmentNotesBinding, NotesViewModel>(R.layout.fragment_notes){

  val binding by viewBinding(FragmentNotesBinding::bind)
  override val viewModel by viewModels<NotesViewModel>()
  private val notesAdapter by lazy { NotesAdapter() }

  override fun initialize() {
    with(binding.rvNotes) {
      binding.rvNotes.layoutManager =
        LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
      adapter=notesAdapter
    }
  }
  override fun setupRequest() {
    viewModel.getAllNotes()
    }
  override fun setupSubscribers() {
    viewModel.getAllNotesState.collectState(
      onError = {
        showToast(it)
        binding.progress.isVisible=false
      },
      onLoading = {
        binding.progress.isVisible=true
      },
      onSuccess = {
        notesAdapter.submitList(it)
        binding.progress.isVisible=false
      }
    )
    viewModel.deleteNotesState.collectState(
      onError = {
        showToast(it)
        binding.progress.isVisible=false
      },
      onLoading = {
        binding.progress.isVisible=true
      },
      onSuccess = {
        showToast(R.string.deleted_successfuly)
      }
    )
  }
  override fun setupListeners() {
    binding.fabOpenForm.setOnClickListener {
       findNavController().navigate(R.id.action_notesFragment_to_addEditNoteFragment)
    }
  }
}