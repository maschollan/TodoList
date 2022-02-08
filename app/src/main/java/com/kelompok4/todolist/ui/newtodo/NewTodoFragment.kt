package com.kelompok4.todolist.ui.newtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.kelompok4.todolist.R
import com.kelompok4.todolist.databinding.FragmentNewTodoBinding
import com.kelompok4.todolist.room.TodoDB
import com.kelompok4.todolist.todo.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class NewTodoFragment : Fragment() {

    val db by lazy { context?.let { TodoDB(it) } }
    private var todoId: Int = 0

    private lateinit var newTodoViewModel: NewTodoViewModel
    private var _binding: FragmentNewTodoBinding ? = null

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

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(getString(R.string.select_date))
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        val picker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setTitleText(getString(R.string.select_time))
                .build()

        binding.dateLabel.setOnClickListener {
            datePicker.show(parentFragmentManager, "datepicker")
            datePicker.addOnPositiveButtonClickListener {
                val date = Date(datePicker.selection!!)
                binding.dateInput.editText?.setText(SimpleDateFormat("E, dd MMM yyyy").format(date))
            }
        }

        binding.timeLabel.setOnClickListener {
            picker.show(parentFragmentManager, "timepicker")
            picker.addOnPositiveButtonClickListener{
                val hour = picker.hour
                val minute = picker.minute
                binding.timeInput.editText?.setText("$hour.$minute")
            }
        }

        val items = listOf("On", "Off")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (binding.notificationInput.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        return root
    }

//    private fun setupListener() {
//        binding.btnSave.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                db?.todoDao()?.addTodo(
//                    Todo(0,
//                        binding.activityInput.editText?.text.toString(),
//                        binding.activityInput.editText?.text.toString(),
//                        binding.activityInput.editText?.text.toString(),
//                        binding.activityInput.editText?.text.toString(),
//                        binding.activityInput.editText?.text.toString())
//                )
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}