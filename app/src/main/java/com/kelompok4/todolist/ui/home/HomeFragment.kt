package com.kelompok4.todolist.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok4.todolist.R
import com.kelompok4.todolist.databinding.FragmentHomeBinding
import com.kelompok4.todolist.room.Todo
import com.kelompok4.todolist.room.TodoDB
import com.kelompok4.todolist.todo.DataTodo
import com.kelompok4.todolist.todo.TodoAdapter
import com.kelompok4.todolist.ui.newtodo.NewTodoFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    val db by lazy { context?.let { TodoDB(it) } }

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private var list : ArrayList<Todo> = arrayListOf()
    private lateinit var todoAdapter : TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =  ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root : View = binding.root
        var rvTodo = binding.rvDosen

//        list.addAll(DataTodo.listData)

        rvTodo.setHasFixedSize(true)
//        rvTodo.adapter = TodoAdapter(list)
        rvTodo.layoutManager = LinearLayoutManager(activity)
        rvTodo.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

        binding.fab.setOnClickListener {
            val newTodoFragment = NewTodoFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(
                    R.id.nav_host_fragment_content_main,
                    newTodoFragment,
                    newTodoFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        loadNote()
    }

    fun loadNote(){
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db?.todoDao()?.getTodos()
            Log.d("MainActivity", "dbResponse: $notes")
            withContext(Dispatchers.Main){
                todoAdapter.setData(notes!!)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}