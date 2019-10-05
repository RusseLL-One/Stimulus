package com.one.russell.stimulus.data.database.dao

import androidx.room.*
import com.one.russell.stimulus.data.database.entities.TaskEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
interface TaskDao {
    @Query("SELECT * FROM taskentity")
    fun observeAllTasks(): Flowable<List<TaskEntity>>

    @Query("SELECT * FROM taskentity WHERE id = :id")
    fun getById(id: Int): Maybe<TaskEntity>

    @Insert
    fun insert(task: TaskEntity): Maybe<Long>

    @Update
    fun update(task: TaskEntity): Maybe<Int>

    @Delete
    fun delete(task: TaskEntity): Maybe<Int>
}