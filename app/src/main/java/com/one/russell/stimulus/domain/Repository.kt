package com.one.russell.stimulus.domain

import com.one.russell.stimulus.data.database.AppDatabase
import com.one.russell.stimulus.data.model.Task
import com.one.russell.stimulus.domain.converters.TaskConverter
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository(private val database: AppDatabase) {

    fun observeAllTasks(): Flowable<List<Task>> {
        return database.taskDao().observeAllTasks()
            .map { list -> list.map { TaskConverter.convertFromDbToDomain(it) } }
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getTask(id: Int): Maybe<Task> {
        return database.taskDao().getById(id)
            .map { task -> TaskConverter.convertFromDbToDomain(task) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun addTask(newTask: Task): Maybe<Long> {
        return Maybe.fromCallable { newTask }
            .map { TaskConverter.convertFromDomainToDb(it) }
            .flatMap { database.taskDao().insert(it)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun updateTask(editedTask: Task): Maybe<Int> {
        return Maybe.fromCallable { editedTask }
            .map { TaskConverter.convertFromDomainToDb(it) }
            .flatMap { database.taskDao().update(it)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun deleteTask(task: Task): Maybe<Int> {
        return Maybe.fromCallable { task }
            .map { TaskConverter.convertFromDomainToDb(it) }
            .flatMap { database.taskDao().delete(it)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}