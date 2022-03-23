package com.example.androidroom.application

import android.app.Application
import com.example.androidroom.database.WordDataBase
import com.example.androidroom.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WordDataBase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}