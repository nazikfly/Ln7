package com.geektech.ln7.presentation.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.ln7.R
import com.geektech.ln7.databinding.FragmentStartBinding


class StartFragment : Fragment(R.layout.fragment_start) {

    private val binding by viewBinding(FragmentStartBinding::bind)
    private val adapter: StartNotesAdapter = TODO()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        binding.recycler.adapter = adapter
        adapter = StartNotesAdapter()
        binding.recycler.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner){listNotes->
            adapter.setList(listNotes)
        }
        binding.add.setOnClickListener {
            findNavController().navigate(R.id.detailFragment)
        }
    }

}