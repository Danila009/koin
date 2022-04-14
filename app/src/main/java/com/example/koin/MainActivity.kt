package com.example.koin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.koin.data.MainViewModel
import com.example.koin.data.module.User
import com.example.koin.ui.theme.KoinTheme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            mainViewModel.addUser(
                User(
                    0,
                    "Danila",
                    16
                )
            )

            var user by remember { mutableStateOf(listOf<User>()) }

            lifecycleScope.launchWhenStarted {
                mainViewModel.responseUser.onEach {
                    user = it
                }.collect()
            }

            LazyColumn(content = {
                items(user){ item ->
                    Text(text = item.username)
                }
            })
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KoinTheme {
        Greeting("Android")
    }
}