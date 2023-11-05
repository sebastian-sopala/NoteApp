package com.example.noteapp.ui

class NoteDataSource {

    fun loadNotes(): List <Note> {
        return listOf(
            Note(title = "Note 1", description = "description 1"),
            Note(title = "Note 2", description = "description 2"),
            Note(title = "Note 3", description = "description 3"),
            Note(title = "Note 4", description = "description 4"),
            Note(title = "Note 5", description = "description 5"),
            Note(title = "Note 6", description = "description 6"),
        )
    }
}