package com.geektech.ln7.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.recyclerview.widget.RecyclerView
import com.geektech.ln7.databinding.ItemNotesBinding
import com.geektech.ln7.domain.model.Note
import kotlin.reflect.KFunction1

class NotesAdapter(
):RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    private var list= listOf<com.geektech.ln7.domain.model.Note>()

    fun submitList(list: List<com.geektech.ln7.domain.model.Note>){
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

  inner  class NoteViewHolder (private val binding:ItemNotesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(note: com.geektech.ln7.domain.model.Note) {
            binding.tvTitle.text=note.title
            binding.tvDescription.text=note.descriptor
            itemView.setOnClickListener{

            }
        }
    }

}
