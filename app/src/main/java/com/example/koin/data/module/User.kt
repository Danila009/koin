package com.example.koin.data.module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val username:String,
    val age:Int
)
