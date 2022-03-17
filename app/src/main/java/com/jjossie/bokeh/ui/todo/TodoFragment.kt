package com.jjossie.bokeh.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
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
        val recyclerView = root.findViewById<RecyclerView>(R.id.todo_list_recycler_view)

        // RecyclerView handles its own LiveData observation, we just give it the ViewModel
        recyclerView.adapter = TodoItemAdapter(this, todoViewModel)
        recyclerView.setHasFixedSize(true)

        return root
    }

}