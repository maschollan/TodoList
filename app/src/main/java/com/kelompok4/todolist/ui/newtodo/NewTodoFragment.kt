package com.kelompok4.todolist.ui.newtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kelompok4.todolist.databinding.FragmentNewTodoBinding

class NewTodoFragment : Fragment() {

    private lateinit var newTodoViewModel: NewTodoViewModel
    private var _binding: FragmentNewTodoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newTodoViewModel =
            ViewModelProvider(this).get(NewTodoViewModel::class.java)

        _binding = FragmentNewTodoBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textSlideshow
//        newTodoViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}