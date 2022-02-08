package com.kelompok4.todolist.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Todo2::class],
    version = 1
)

abstract class TodoDB : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile private var instance: TodoDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{
                instance = it
            }
        }

        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            TodoDB::class.java,
            "todo123.db"
        ).build()
    }
}