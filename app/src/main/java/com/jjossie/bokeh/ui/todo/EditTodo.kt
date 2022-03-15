package com.jjossie.bokeh.ui.todo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.jjossie.bokeh.R

class EditTodo : Fragment() {

    companion object {
        fun newInstance() = EditTodo()
    }

    private lateinit var viewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.edit_todo_fragment, container, false)
        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        val textViewTodoName: EditText = root.findViewById(R.id.editTextTodoName)
        val checkBoxTodoComplete: CheckBox = root.findViewById(R.id.checkBoxTodoComplete)
//        val labelDueDate: TextView = root.findViewById(R.id.labelDueDate)
        val editDateDueDate: EditText = root.findViewById(R.id.editDateDueDate)

        viewModel.selectedItem.observe(viewLifecycleOwner, Observer {
            textViewTodoName.hint = it.name
            checkBoxTodoComplete.isChecked = it.completed
            editDateDueDate.hint = it.getCompletionDate().toString() // TODO lol this isn't even the right feature
        })

        return root
    }

}