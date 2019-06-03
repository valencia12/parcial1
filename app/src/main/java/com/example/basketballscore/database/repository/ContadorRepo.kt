package com.example.basketballscore.database.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.basketballscore.database.daos.ContadorDao

import com.example.basketballscore.database.entities.ContadorP


class ContadorRepo(private val ContadorRepo: ContadorDao){

    val part : LiveData<List<ContadorP>> = ContadorRepo.getAllMatches()

    @WorkerThread
    suspend fun insert(ContadorP: ContadorP){
        ContadorRepo.insert(ContadorP)
    }
}