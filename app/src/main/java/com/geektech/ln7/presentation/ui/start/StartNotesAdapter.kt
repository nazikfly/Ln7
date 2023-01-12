package com.geektech.ln7.presentation.ui.start

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.ln7.databinding.ItemNotesBinding
import com.geektech.ln7.domain.model.Note

class StartNotesAdapter : RecyclerView.Adapter<StartNotesAdapter.NotesViewHolder>() {
    var listNote = arrayListOf<Note>()

    inner class NotesViewHolder(var binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
            return NotesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }

        override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
            holder.bind(listNote[position])
        }

        override fun getItemCount(): Int {
        return listNote.size

    }

}