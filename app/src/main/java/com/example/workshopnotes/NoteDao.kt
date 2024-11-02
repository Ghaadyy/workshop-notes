package com.example.workshopnotes

import androidx.room.*

@Dao
interface NoteDao {
    @Insert
    fun createNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getNotes(): List<Note>
}