package com.one.russell.stimulus.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.one.russell.stimulus.data.database.dao.TaskDao
import com.one.russell.stimulus.data.database.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
public abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}