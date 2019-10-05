package com.one.russell.stimulus

import android.app.Application
import com.one.russell.stimulus.data.database.AppDatabase
import androidx.room.Room
import com.one.russell.stimulus.domain.Repository

class App : Application() {

    companion object {
        var instance: App? = null
    }

    private lateinit var repository: Repository


    override fun onCreate() {
        super.onCreate()
        instance = this
        val database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries() // TODO сделать асинхронную работу с бд
            .build()

        repository = Repository(database)
    }

    fun getRepository(): Repository {
        return repository
    }
}