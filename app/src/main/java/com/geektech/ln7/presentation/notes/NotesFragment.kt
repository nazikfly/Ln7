package com.geektech.ln7.presentation.notes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.ln7.R
import com.geektech.ln7.databinding.FragmentNotesBinding
import com.geektech.ln7.presentation.utils.UIState
import kotlinx.coroutines.launch

class NotesFragment : Fragment(R.layout.fragment_notes) {

  private val binding by viewBinding(FragmentNotesBinding::bind)
  private val viewModel by viewModels<NotesViewModel>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.getAllNotes()


    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.getAllNotesState.collect { state->
        when(state){
          is UIState.Empty->{}
          is UIState.Error->{
            Toast.makeText(requireContext(),state.massage,Toast.LENGTH_SHORT).show()
          }
          is UIState.Loanding->{}
          is UIState.Success->{}
        }
      }
    }
  }
}