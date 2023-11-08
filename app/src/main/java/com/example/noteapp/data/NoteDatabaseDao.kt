package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from TableName")
    fun getAllNotes(): Flow<List<NoteModel>>

    @Query("SELECT * from TableName where id = :id")
    suspend fun selectById(id: String): NoteModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteModel)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(note: NoteModel)

    @Query("DELETE from TableName")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: NoteModel)

}
