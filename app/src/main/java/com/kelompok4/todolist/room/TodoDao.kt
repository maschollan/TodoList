package com.kelompok4.todolist.room

import androidx.room.*

@Dao
interface TodoDao {
    @Insert
    suspend fun addTodo(todo: com.kelompok4.todolist.room.Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo")
    suspend fun getTodos(): List<Todo>

    @Query("SELECT * FROM todo WHERE id=:todo_id")
    suspend fun getTodo(todo_id: Int): List<Todo>
}