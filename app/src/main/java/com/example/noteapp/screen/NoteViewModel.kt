package com.example.noteapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.NoteModel
import com.example.noteapp.repository.NoteAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor (private val repository: NoteAppRepository): ViewModel() {

    private var _noteList = MutableStateFlow<List<NoteModel>>(emptyList())
    val noteList = _noteList.asStateFlow()

//    var noteList = mutableStateListOf<NoteModel>()

    init {
//          noteList.addAll(NoteDataSource().loadNotes())
        viewModelScope.launch {
            repository.getAllNotes()
                .distinctUntilChanged()
                .collect{
                if(it.isNullOrEmpty()) {
                    Log.d("noteAppTag", "List is empty my friend !!")
                } else {
                    _noteList.value = it
                }
            }
        }
    }

    fun addNote(note: NoteModel) = viewModelScope.launch {
        repository.insert(note)
    }

    fun removeNote(note: NoteModel) = viewModelScope.launch {
        repository.delete(note)
    }

    fun update(note: NoteModel) = viewModelScope.launch {
        repository.update(note)
    }

//    fun loadNoteList(): List<NoteModel> {
//        return noteList
//    }
}