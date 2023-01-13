package com.geektech.ln7.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.ln7.databinding.ItemNotesBinding
import com.geektech.ln7.domain.model.Note

class NotesAdapter:RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    private var list= listOf<Note>()

    fun submitList(list: List<Note>){
        this.list=list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
     return NoteViewHolder(
         ItemNotesBinding.inflate(
             LayoutInflater.from(parent.context),parent,false)
     )
    }
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position])
    }
    override fun getItemCount()=list.size

    class NoteViewHolder (private val binding:ItemNotesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.tvTitle.text=note.title
            binding.tvDescription.text=note.descriptor
        }
    }

}