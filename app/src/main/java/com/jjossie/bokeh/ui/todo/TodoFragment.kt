package com.jjossie.bokeh.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jjossie.bokeh.R

class TodoFragment : Fragment() {

    private val todoViewModel: TodoViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Get root View
        val root = inflater.inflate(R.layout.fragment_todo, container, false)

        // Get component Views
        val recyclerView: RecyclerView = root.findViewById(R.id.todo_list_recycler_view)
        val fab: FloatingActionButton = root.findViewById(R.id.addTodoFAB)

        // Add Listeners
        fab.setOnClickListener{
            todoViewModel.createNewTodo()
            findNavController().navigate(R.id.action_navigation_home_to_editTodo)
        }

        // RecyclerView handles its own LiveData observation, we just give it the ViewModel
        recyclerView.adapter = TodoItemAdapter(this, todoViewModel)
        recyclerView.setHasFixedSize(true)

        return root
    }

}