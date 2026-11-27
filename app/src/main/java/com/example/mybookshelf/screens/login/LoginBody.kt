package com.example.mybookshelf.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mybookshelf.R

@Composable
fun UserName(userName: String, onNameChange: (String) -> Unit) {
    TextField(
        value = userName,
        onValueChange = { onNameChange(it) },
        placeholder = {
            Text(
                text = "Username",
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
    )
}

@Composable
fun Password() {
    var password by rememberSaveable { mutableStateOf("") }
    var passVisibility by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { password = it },
        placeholder = {
            Text(
                text = "Password",
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
        },
        trailingIcon = {
            val eyeIcon = if(passVisibility) R.drawable.ic_visible
            else R.drawable.ic_not_visible
            Icon(
                painter = painterResource(eyeIcon),
                contentDescription = if (passVisibility) "Password visible"
                else "Password not visible",
                    modifier = Modifier.clickable {
                        passVisibility = !passVisibility
                    }
            )
        },
        visualTransformation = if (passVisibility) PasswordVisualTransformation()
        else VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
    )
}

@Composable
fun RegisterButton() {
    Button(
        onClick = { /* Registrar nuevo usuario */ },
        modifier = Modifier.width(120.dp)
    ) {
        Text("Registrar")
    }
}

@Composable
fun LoginButton(userName: String, goToLogin: (String) -> Unit) {
    Button(
        onClick = {goToLogin(userName)},
        modifier = Modifier.width(100.dp)
    ) {
        Text("Login")
    }
}
@Composable
fun SocialLogin() {
    Row(modifier = Modifier
        .clickable { /* Iniciar sesión con Google */ }
    ) {
        Image(
            painter = painterResource(R.drawable.google_logo),
            contentDescription = "Google logo",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "Iniciar sesión con Google",
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}