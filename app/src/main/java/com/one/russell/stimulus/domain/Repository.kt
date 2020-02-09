package com.one.russell.stimulus.domain

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.one.russell.stimulus.data.database.AppDatabase
import com.one.russell.stimulus.data.model.Task
import com.one.russell.stimulus.domain.converters.TaskConverter
import kotlinx.coroutines.tasks.await


class Repository(private val database: AppDatabase) {

    val firebaseFirestore = FirebaseFirestore.getInstance()

    //Database

    suspend fun observeAllTasks(): List<Task> {
        return database.taskDao().observeAllTasks()
            .map { TaskConverter.convertFromDbToDomain(it) }
    }

    suspend fun getTask(id: Int): Task {
        return database.taskDao().getById(id)
            .let { task -> TaskConverter.convertFromDbToDomain(task) }
    }

    suspend fun addTask(newTask: Task): Long {
        return newTask
            .let { TaskConverter.convertFromDomainToDb(it) }
            .let { database.taskDao().insert(it) }
    }

    suspend fun updateTask(editedTask: Task): Int {
        return editedTask
            .let { TaskConverter.convertFromDomainToDb(it) }
            .let { database.taskDao().update(it) }
    }

    suspend fun deleteTask(task: Task): Int {
        return task
            .let { TaskConverter.convertFromDomainToDb(it) }
            .let { database.taskDao().delete(it) }
    }

    // Web

    suspend fun sendNewTask(newTask: Task) {
        val sendTask = TaskConverter.convertFromDomainToWeb(newTask)
        val documentReference = firebaseFirestore.collection("tasks").document(newTask.title)

        try {
            documentReference.set(sendTask).await()
            /*val snapshot = usersRef.get().await()
            val users = snapshot.toObjects(User::class.java)
            updateUI(users)*/
        } catch (e: FirebaseFirestoreException) {
            //displayError()
        }
    }
}