package com.kelompok4.todolist.ui.newtodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewTodoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is new todo Fragment"
    }
    val text: LiveData<String> = _text
}