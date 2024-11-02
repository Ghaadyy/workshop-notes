package com.example.workshopnotes

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val scope = CoroutineScope(Dispatchers.IO)
    private val baseUrl = "https://67239e5f493fac3cf24baaf4.mockapi.io/api/"
    private var repo: NotesRepository = NotesRetrofitRepository(baseUrl)

    private suspend fun loadFromRepository() = withContext(Dispatchers.IO) {
        val notes = repo.getNotes()

        withContext(Dispatchers.Main) {
            findViewById<RecyclerView>(R.id.notes_rv).apply {
                adapter = NotesAdapter(notes)
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.http_btn).setOnClickListener {
            repo = NotesHttpConnection(baseUrl)
            scope.launch { loadFromRepository() }
        }
        findViewById<Button>(R.id.retrofit_btn).setOnClickListener {
            repo = NotesRetrofitRepository(baseUrl)
            scope.launch { loadFromRepository() }
        }
        findViewById<Button>(R.id.roomdb_btn).setOnClickListener {
            repo = NotesRoomRepository(applicationContext)
            scope.launch { loadFromRepository() }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}