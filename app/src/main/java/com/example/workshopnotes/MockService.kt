package com.example.workshopnotes

import retrofit2.Call
import retrofit2.http.*

interface MockService {
    @POST("notes")
    fun createNote(note: Note)

    @PUT("notes")
    fun updateNote(note: Note)

    @DELETE("notes")
    fun deleteNote(note: Note)

    @GET("notes")
    fun getNotes(): Call<List<Note>>
}