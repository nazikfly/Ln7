package com.geektech.ln7.di

import android.content.Context
import androidx.room.Room
import com.geektech.ln7.data.local.NoteDao
import com.geektech.ln7.data.local.NoteDatabase
import com.geektech.ln7.data.repository.NoteRepositoryImpl
import com.geektech.ln7.domain.repository.NoteRepository
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ):NoteDatabase = Room.databaseBuilder(
        context,
    NoteDatabase::class.java,
        "note_db"
    ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase)=noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideNoteRepository(
        noteDao: NoteDao
    ):NoteRepository=NoteRepositoryImpl(noteDao)

}
