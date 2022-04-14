package com.example.koin.di

import android.content.Context
import androidx.room.Room
import com.example.koin.data.MainViewModel
import com.example.koin.data.Repository
import com.example.koin.data.UserDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val room = module {

    single {
        Room.databaseBuilder(
            get<Context>().applicationContext,
            UserDatabase::class.java,
            "user_database"
        ).build()
    }

    single {
        get<UserDatabase>().userDao()
    }

    single {
        Repository(userDao = get())
    }

    viewModel {
        MainViewModel(repository = get())
    }
}
