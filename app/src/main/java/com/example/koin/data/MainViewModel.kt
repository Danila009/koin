package com.example.koin.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koin.data.module.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
):ViewModel(){

    val responseUser: Flow<List<User>> = repository.getUser()

    fun addUser(user: User){
        viewModelScope.launch {
            repository.addUser(user)
        }
    }
}