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

    override fun onCreateView( // Override method, with standard parameters
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? { // Returns a View optional

        // root is set to this inflated fragment
        val root = inflater.inflate(R.layout.fragment_todo, container, false)

        // This is where we grab components and bind observers?
        val recyclerView = root.findViewById<RecyclerView>(R.id.todo_list_recycler_view)

        // Now we have to learn how to observe LiveData here ... ???
        recyclerView.adapter = TodoItemAdapter(this, todoViewModel)
        recyclerView.setHasFixedSize(true)

//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

}