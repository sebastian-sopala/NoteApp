package com.example.noteapp

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.ui.Note
import com.example.noteapp.ui.NoteButton
import com.example.noteapp.ui.NoteDataSource
import com.example.noteapp.ui.NoteRow
import com.example.noteapp.ui.TextInputField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAppScreen(
    notes: List<Note>,
    addNote: (Note) -> Unit,
    removeNote: (Note) -> Unit,
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name)
                )
            },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Clear, contentDescription = "Clear"
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.DarkGray,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White,
            ),
        )
        TextInputField(
            text = title,
            label = "Title",
            onTextChange = { title = it },
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
        )
        TextInputField(
            text = description,
            label = "Description",
            onTextChange = { description = it },
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
        )
        NoteButton(
            text = "Add",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 23.dp, end = 23.dp)
                .padding(top = 30.dp, bottom = 30.dp)
        ) {
            addNote(Note(title = title, description = description))
            Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
            title = ""
            description = ""
        }

        LazyColumn {
            items(notes) {
                NoteRow(note = it) {note->
                    removeNote(note)
                }
            }
        }
        // notes list
    }
}

@Preview(showBackground = true)
@Composable
fun NoteAppScreenPreview() {
    NoteAppScreen(notes = NoteDataSource().loadNotes(), addNote = {}, removeNote = {})
}