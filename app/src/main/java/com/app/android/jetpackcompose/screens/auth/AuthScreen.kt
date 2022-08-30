package com.app.android.jetpackcompose.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavHostController
import com.app.android.jetpackcompose.R

sealed class Auth(val route: String){
    object Login : Auth(route = "login")
}

@Composable
fun AuthScreen(navHostController: NavHostController){
    var username by remember { mutableStateOf("")}


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        UsernameTextInput(initText = username){
            username = it
        }
        PasswordTextInput()
    }
}

@Composable
fun UsernameTextInput(initText: String, callback: (text: String) -> Unit) {
    OutlinedTextField(value = initText, onValueChange = { callback(initText)
    }, label = {
        Text(text = "Username", color = colorResource(R.color.orange_500))
    }, singleLine = true,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Email Icon")
            }
        },
        placeholder = { Text(text = "Username")}
    )
}


@Composable
fun PasswordTextInput() {
    var password by rememberSaveable { mutableStateOf("")}
    var passwordVisibility by remember { mutableStateOf(false)}

    val visibilityIcon = if(passwordVisibility)
        painterResource(id = R.drawable.ic_visibility)
    else
        painterResource(id = R.drawable.ic_visibility_off)

    OutlinedTextField(value = password, onValueChange = {
        password = it
    }, label = {
        Text(text = "Password", color = colorResource(R.color.orange_500))
    }, singleLine = true,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Lock Icon")
            }
        },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = visibilityIcon,
                    contentDescription = "Visibility Icon")
            }
        },
        placeholder = { Text(text = "Password")},
        visualTransformation = if(passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
}
