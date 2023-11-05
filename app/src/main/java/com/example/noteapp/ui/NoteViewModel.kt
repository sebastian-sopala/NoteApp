package com.example.noteapp.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class NoteViewModel: ViewModel() {

    var noteList = mutableStateListOf<Note>()

    init {
          noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun loadNoteList(): List<Note> {
        return noteList
    }
}