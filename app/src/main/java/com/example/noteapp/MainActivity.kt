package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.noteapp.ui.Note
import com.example.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {

                val notes = remember {
                    mutableStateListOf<Note>()
                }

                NoteAppScreen(notes = notes, addNote = {
                    notes.add(it)
                }, removeNote ={
                    notes.remove(it)
                })


                // A surface container using the 'background' color from the theme

            }
        }
    }
}

// NoteAppScreen.kt -> column -> TopAppBar stringResource(R.string.app_name)
// Components.kt -> textField, button
