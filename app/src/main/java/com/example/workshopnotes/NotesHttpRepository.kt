package com.example.workshopnotes

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.*
import javax.net.ssl.HttpsURLConnection

class NotesHttpRepository(private val baseUrl: String) : NotesRepository {
    private val gson = Gson()

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
        val url = URL(baseUrl + "notes")
        val connection = url.openConnection() as HttpsURLConnection
        connection.requestMethod = "GET"
        connection.connect()

        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        val response = StringBuilder()
        var line: String?

        while (reader.readLine().also { line = it } != null) {
            response.append(line)
        }

        val json = response.toString()
        val notes = gson.fromJson(json, object : TypeToken<List<Note>>() {})

        notes
    }
}