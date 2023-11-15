package com.achsanit.todolistapp.foundation.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.achsanit.todolistapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldLabel(
    text: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int
) {
    Column {
        Text(
            text = stringResource(label),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = Modifier.padding(vertical = 16.dp).fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldLabelPreview() {
    TextFieldLabel(text = "text", onValueChange = { }, R.string.app_name)
}