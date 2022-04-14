package com.example.koin.data

import com.example.koin.data.module.User
import kotlinx.coroutines.flow.Flow

class Repository(
    private val userDao: UserDao
):UserDao {
    override suspend fun addUser(user: User) {
        return userDao.addUser(user)
    }

    override fun getUser(): Flow<List<User>> {
        return  userDao.getUser()
    }
}