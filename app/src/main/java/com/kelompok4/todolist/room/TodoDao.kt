package com.kelompok4.todolist.room

import androidx.room.*

@Dao
interface TodoDao {
    @Insert
    suspend fun addTodo(todo: com.kelompok4.todolist.room.Todo2)

    @Update
    suspend fun updateTodo(todo: Todo2)

    @Delete
    suspend fun deleteTodo(todo: Todo2)

    @Query("SELECT * FROM todo2")
    suspend fun getTodos(): List<Todo2>

    @Query("SELECT * FROM todo2 WHERE id=:todo_id")
    suspend fun getTodo(todo_id: Int): List<Todo2>
}