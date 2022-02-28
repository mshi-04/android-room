package com.example.androidroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidroom.dao.WordDao
import com.example.androidroom.entity.Word

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
abstract class WordDataBase: RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordDataBase? = null

        fun getDataBase(context: Context): WordDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordDataBase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}