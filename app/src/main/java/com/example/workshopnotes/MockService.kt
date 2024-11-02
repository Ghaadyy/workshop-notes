package com.example.workshopnotes

import retrofit2.http.*

interface MockService {
    @POST("notes")
    suspend fun createNote(note: Note)

    @PUT("notes")
    suspend fun updateNote(note: Note)

    @DELETE("notes")
    suspend fun deleteNote(note: Note)

    @GET("notes")
    suspend fun getNotes(): List<Note>
}