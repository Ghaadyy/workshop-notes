package com.example.workshopnotes

import androidx.room.*

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val content: String)