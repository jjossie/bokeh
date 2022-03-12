package com.jjossie.bokeh.ui.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jjossie.bokeh.R
import com.jjossie.bokeh.data.model.Todo
import java.time.format.DateTimeFormatter

class TodoItemAdapter(
    private val context: Context,
    private val todoItems: ArrayList<Todo>
) : RecyclerView.Adapter<TodoItemAdapter.TodoItemViewHolder>() {

    class TodoItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.todo_item_title)
        val dateTextView: TextView = view.findViewById(R.id.date_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return TodoItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val item = todoItems[position]
        holder.titleTextView.text = item.name
        holder.dateTextView.text = item.getCreationDate().format(DateTimeFormatter.ofPattern("M/dd"))
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }
}