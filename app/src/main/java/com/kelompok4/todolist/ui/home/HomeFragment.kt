package com.kelompok4.todolist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok4.todolist.R
import com.kelompok4.todolist.databinding.FragmentHomeBinding
import com.kelompok4.todolist.todo.DataTodo
import com.kelompok4.todolist.todo.Todo
import com.kelompok4.todolist.todo.TodoAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private var list : ArrayList<Todo> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =  ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root : View = binding.root
        var rvTodo = binding.rvDosen

        list.addAll(DataTodo.listData)

        rvTodo.setHasFixedSize(true)
        rvTodo.adapter = TodoAdapter(list)
        rvTodo.layoutManager = LinearLayoutManager(activity)
        rvTodo.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}