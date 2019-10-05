package com.one.russell.stimulus.domain.converters

import com.one.russell.stimulus.data.database.entities.TaskEntity
import com.one.russell.stimulus.data.model.Task

class TaskConverter {

    companion object {
        fun convertFromDbToDomain(taskEntity: TaskEntity): Task {
            return Task(taskEntity.id, taskEntity.title, taskEntity.description)
        }

        fun convertFromDomainToDb(task: Task): TaskEntity {
            return TaskEntity(task.id, task.title, task.description)
        }
    }
}