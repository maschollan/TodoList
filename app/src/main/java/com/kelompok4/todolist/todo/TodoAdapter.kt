package com.kelompok4.todolist.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kelompok4.todolist.R

class TodoAdapter(private val listTodo : ArrayList<Todo>) : RecyclerView.Adapter<TodoAdapter.CardViewHolder>(){
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTime : TextView = itemView.findViewById(R.id.tv_time)
        var tvNote : TextView = itemView.findViewById(R.id.tv_note)
        var tvTask : TextView = itemView.findViewById(R.id.tv_task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view : View =LayoutInflater.from(parent.context).inflate(R.layout.todo_item_layout, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val todo = listTodo[position]

        holder.tvNote.text = todo.note
        holder.tvTask.text = todo.task
        holder.tvTime.text = todo.time
    }

    override fun getItemCount() = DataTodo.listData.size

    fun setData(newList: List<Todo>) {
        listTodo.clear()
        listTodo.addAll(newList)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onRead(note:Todo)
        fun onUpdate(note:Todo)
        fun onDelete(note:Todo)
    }
}