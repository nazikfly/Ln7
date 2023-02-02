package com.geektech.ln7.data.mappers

import com.geektech.ln7.data.model.NoteEntity
import com.geektech.ln7.domain.model.Note

fun Note.toNoteEntity()= NoteEntity(
    id,title,descriptor,ceateAt
)

fun NoteEntity.toNote()=Note(
    id,title,description,createAt
)
