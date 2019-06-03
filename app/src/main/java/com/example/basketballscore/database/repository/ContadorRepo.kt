package com.example.basketballscore.database.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.basketballscore.database.daos.ContadorDao

import com.example.basketballscore.database.entities.ContadorP


class ContadorRepo(private val ContadorDao: ContadorDao){

    val part : LiveData<List<ContadorP>> = ContadorDao.getAll()

    @WorkerThread
    suspend fun insert(ContadorP: ContadorP){
        ContadorDao.insert(ContadorP)
    }
}