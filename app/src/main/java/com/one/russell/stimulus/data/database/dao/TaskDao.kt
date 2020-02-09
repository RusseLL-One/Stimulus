package com.one.russell.stimulus.data.database.dao

import androidx.room.*
import com.one.russell.stimulus.data.database.entities.TaskEntity

@Dao
interface TaskDao {
    @Query("SELECT * FROM taskentity")
    suspend fun observeAllTasks(): List<TaskEntity>

    @Query("SELECT * FROM taskentity WHERE id = :id")
    suspend fun getById(id: Int): TaskEntity

    @Insert
    suspend fun insert(task: TaskEntity): Long

    @Update
    suspend fun update(task: TaskEntity): Int

    @Delete
    suspend fun delete(task: TaskEntity): Int
}