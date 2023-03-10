package com.geektech.ln7.di

import android.content.Context
import androidx.room.Room
import com.geektech.ln7.data.local.NoteDao
import com.geektech.ln7.data.local.NoteDatabase
import com.geektech.ln7.data.repository.NoteRepositoryImpl
import com.geektech.ln7.domain.repository.NoteRepository
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
    @ApplicationContext context: Context
    ): com.geektech.ln7.data.local.NoteDatabase = Room.databaseBuilder(
        context,
    com.geektech.ln7.data.local.NoteDatabase::class.java,
        "note_db"
    ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: com.geektech.ln7.data.local.NoteDatabase)=noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideNoteRepository(
        noteDao: com.geektech.ln7.data.local.NoteDao
    ): com.geektech.ln7.domain.repository.NoteRepository = com.geektech.ln7.data.repository.NoteRepositoryImpl(noteDao)

}
