package com.achsanit.todolistapp.features.login.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.achsanit.todolistapp.R
import com.achsanit.todolistapp.foundation.ui.components.TextFieldLabel


@Composable
fun LoginScreen(
    buttonLoginOnClick: () -> Unit
) {
    var tv1 by remember { mutableStateOf("") }
    var tv2 by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(vertical = 24.dp),
            text = "Login",
            style = MaterialTheme.typography.headlineLarge
        )
        TextFieldLabel(
            text = tv1,
            onValueChange = {
                tv1 = it
            },
            label = R.string.app_name
        )
        TextFieldLabel(
            text = tv2,
            onValueChange = {
                tv2 = it
            },
            label = R.string.app_name
        )
        Spacer( modifier = Modifier.height(24.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = buttonLoginOnClick,
            shape = RoundedCornerShape(12.dp),
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "Login",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainLayoutPreview() {
    LoginScreen { }
}