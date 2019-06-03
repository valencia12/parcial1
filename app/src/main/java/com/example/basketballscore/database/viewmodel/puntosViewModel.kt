package com.example.basketballscore.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.basketballscore.database.daos.ContadorDao
import com.example.basketballscore.database.entities.ContadorP
import com.example.basketballscore.database.hRoomDatabase

import com.example.basketballscore.database.repository.ContadorRepo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class puntosViewModel(application: Application): AndroidViewModel(application){
    private val repository : ContadorRepo
    val part: LiveData<List<ContadorP>>

    val puntuacion1 = MutableLiveData<Int>().apply { postValue(0) }
    val puntuacion2 = MutableLiveData<Int>().apply { postValue(0) }


    init {

        val ContadorDao = hRoomDatabase.getDatabase(application).ContadorDao()
        repository = ContadorRepo(ContadorDao)

        part = repository.part
    }

    fun insert(ContadorP: ContadorP) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(ContadorP)
    }
}