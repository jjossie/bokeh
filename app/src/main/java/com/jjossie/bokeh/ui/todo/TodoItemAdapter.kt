package com.jjossie.bokeh.ui.todo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jjossie.bokeh.R
import java.time.format.DateTimeFormatter

class TodoItemAdapter(
    private val owner: Fragment,
    private val viewModel: TodoViewModel
) : RecyclerView.Adapter<TodoItemAdapter.TodoItemViewHolder>() {

    class TodoItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.todo_item_title)
        val dateTextView: TextView = view.findViewById(R.id.date_text)
        val checkBox: CheckBox = view.findViewById(R.id.todo_completed_box)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return TodoItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {

        holder.view.setOnClickListener {
            // Select the next item logically (i.e. tell the ViewModel to do it)
            // This depends on the RecyclerView order matching the ViewModel ArrayList order
            viewModel.selectAtPosition(position)
            // Navigate to next component // TODO
            owner.findNavController().navigate(R.id.action_navigation_home_to_editTodo)
        }

        holder.checkBox.setOnClickListener{
            val box: CheckBox = it as CheckBox
            viewModel.markTodoAtPosition(position, it.isChecked)
        }


        // This is where we observe the LiveData! Might not be the most efficient thing ever.
        viewModel.todos.observe(owner, Observer {
            Log.d("TodoItemAdapter", "I'm observing")
            val item = it[position]
            holder.titleTextView.text = item.name
            holder.dateTextView.text = item.getCreationDate().format(DateTimeFormatter.ofPattern("M/dd"))
            holder.checkBox.isChecked = item.completed

        })

    }

    override fun getItemCount(): Int {
        return viewModel.todos.value?.size ?: 0
    }
}