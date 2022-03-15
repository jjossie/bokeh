package com.jjossie.bokeh.ui.todo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        


        return root
    }

}