package com.example.noteapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "TableName")
data class NoteModel(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "TableTitle")
    val title: String,

    @ColumnInfo(name = "TableDescription")
    val description: String,

    @ColumnInfo(name = "TableTime")
//    val entryDate: LocalDateTime = LocalDateTime.now()
    val entryDate: Date = Date.from(Instant.now())
)
