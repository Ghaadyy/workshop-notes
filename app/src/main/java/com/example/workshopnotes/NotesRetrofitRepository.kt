package com.example.workshopnotes

import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

class NotesRetrofitRepository(private val baseUrl: String) : NotesRepository {
    override suspend fun createNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun updateNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun getNotes(): List<Note> {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl) // Replace with your actual URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val mockService = retrofit.create(MockService::class.java)

        return mockService.getNotes().await()
    }
}