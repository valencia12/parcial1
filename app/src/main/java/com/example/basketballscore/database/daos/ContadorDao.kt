package com.example.basketballscore.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basketballscore.database.entities.ContadorP


@Dao
interface ContadorDao {
    @Query("SELECT * FROM Puntuacion_table")
    fun getAllMatches() : LiveData<List<ContadorP>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(match: ContadorP)

    @Query("DELETE FROM Puntuacion_table")
    fun nukeAllMatches()
}