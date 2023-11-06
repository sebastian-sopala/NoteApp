package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.ui.NoteViewModel
import com.example.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                NoteApp()
                // A surface container using the 'background' color from the theme

            }
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel = viewModel()) {
    val noteList = noteViewModel.loadNoteList()

    NoteAppScreen(notes = noteList, addNote = {
        noteViewModel.addNote(it)
    }, removeNote ={
        noteViewModel.removeNote(it)
    })
}

// NoteAppScreen.kt -> column -> TopAppBar stringResource(R.string.app_name)
// Components.kt -> textField, button
