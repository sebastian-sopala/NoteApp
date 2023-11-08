package com.example.noteapp.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.data.NoteModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextInputField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        maxLines = maxLine,
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        })
    )
}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: NoteModel,
    onClick: (NoteModel) -> Unit,
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(topEnd = 23.dp)),
        color = Color.LightGray
    ) {
        Column(
            modifier = modifier.padding(18.dp).clickable { onClick(note) }
        ) {
            Text(text = note.title)
            Text(text = note.description)
            // TODO add the date
//            Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM, YYYY")))
        }

    }


}


@Preview(showBackground = true)
@Composable
fun InputTextFieldPreview() {
    TextInputField(
        text = "text",
        label = "label",
        onTextChange = {}
    ) {}
}