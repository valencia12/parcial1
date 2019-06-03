package com.example.basketballscore.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basketballscore.database.daos.ContadorDao

import com.example.basketballscore.database.entities.ContadorP



@Database(entities = [ContadorP::class], version = 2)
public abstract class hRoomDatabase : RoomDatabase(){

    abstract fun ContadorDao() :ContadorDao

    companion object {
        @Volatile
        private var INSTANCE: hRoomDatabase? = null

        fun getDatabase(context:Context
        ): hRoomDatabase{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    hRoomDatabase::class.java,
                    "word_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}