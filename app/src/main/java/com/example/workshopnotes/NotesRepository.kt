package com.example.workshopnotes

interface NotesRepository {
    suspend fun createNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun getNotes(): List<Note>
}