package com.example.koin.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.koin.data.module.User

@Database(
    version = 1,
    entities = [
        User::class
    ]
)
abstract class UserDatabase:RoomDatabase() {
    abstract fun userDao():UserDao
}