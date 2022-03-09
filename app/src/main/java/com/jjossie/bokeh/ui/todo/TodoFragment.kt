package com.jjossie.bokeh.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.jjossie.bokeh.R
import com.jjossie.bokeh.data.Repository

class TodoFragment : Fragment() {

    private lateinit var todoViewModel: TodoViewModel

    override fun onCreateView( // Override method, with standard parameters
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? { // Returns a View optional
        // Get the ViewModel for this fragment (assigned to lateinit member var)
        todoViewModel =
                ViewModelProvider(this).get(TodoViewModel::class.java)
        // root is set to this inflated fragment
        val root = inflater.inflate(R.layout.fragment_todo, container, false)

        // This is where we grab components and bind observers?

        val dataset = Repository().loadTodos()
        val recyclerView = root.findViewById<RecyclerView>(R.id.todo_list_recycler_view)
        recyclerView.adapter = TodoItemAdapter(requireContext(), dataset)
        recyclerView.setHasFixedSize(true)

//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

}