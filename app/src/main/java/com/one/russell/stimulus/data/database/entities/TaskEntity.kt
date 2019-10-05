package com.one.russell.stimulus.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var title: String,

    var description: String
)