package com.example.noteapp.repository

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.KeyEvent.DispatcherState
import com.example.noteapp.data.NoteDatabaseDao
import com.example.noteapp.data.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteAppRepository @Inject constructor(private val dao: NoteDatabaseDao) {
    fun getAllNotes() =
        dao.getAllNotes()
            .flowOn(Dispatchers.IO)
            .conflate()

    suspend fun selectById(id: String) = dao.selectById(id)
    suspend fun insert(note: NoteModel) = dao.insert(note)
    suspend fun update(note: NoteModel) = dao.update(note)
    suspend fun delete(note: NoteModel) = dao.deleteNote(note)
    suspend fun deleteAll() = dao.deleteAll()
}