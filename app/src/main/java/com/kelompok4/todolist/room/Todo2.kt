package com.kelompok4.todolist.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Todo2 (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val activity: String,
    val notification: String,
    val date: String,
    val time: String,
    val note: String
)
