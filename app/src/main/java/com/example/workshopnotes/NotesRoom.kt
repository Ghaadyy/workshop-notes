package com.example.workshopnotes

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesRoomRepository(private val applicationContext: Context) : NotesRepository {
    override suspend fun createNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun updateNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun getNotes(): List<Note> = withContext(Dispatchers.IO) {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "notes-db"
        ).fallbackToDestructiveMigration().build()

        val noteDao = db.noteDao()

        noteDao.getNotes()
    }
}