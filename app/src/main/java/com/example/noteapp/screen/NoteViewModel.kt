package com.example.noteapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.noteapp.data.NoteModel
import com.example.noteapp.data.NoteDataSource

class NoteViewModel: ViewModel() {

    var noteList = mutableStateListOf<NoteModel>()

    init {
          noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: NoteModel) {
        noteList.add(note)
    }

    fun removeNote(note: NoteModel) {
        noteList.remove(note)
    }

    fun loadNoteList(): List<NoteModel> {
        return noteList
    }
}