package com.example.noteapp.data

class NoteDataSource {

    fun loadNotes(): List <NoteModel> {
        return listOf(
            NoteModel(title = "Note 1", description = "description 1"),
            NoteModel(title = "Note 2", description = "description 2"),
            NoteModel(title = "Note 3", description = "description 3"),
            NoteModel(title = "Note 4", description = "description 4"),
            NoteModel(title = "Note 5", description = "description 5"),
            NoteModel(title = "Note 6", description = "description 6"),
        )
    }
}