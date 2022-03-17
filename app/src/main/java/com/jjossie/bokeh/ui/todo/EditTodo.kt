package com.jjossie.bokeh.ui.todo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jjossie.bokeh.R

class EditTodo : Fragment() {

    private val model: TodoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Get root View
        val root = inflater.inflate(R.layout.edit_todo_fragment, container, false)
        // Get component Views
        val textViewTodoName: EditText = root.findViewById(R.id.editTextTodoName)
        val checkBoxTodoComplete: CheckBox = root.findViewById(R.id.checkBoxTodoComplete)
        val dateCreatedText: TextView = root.findViewById(R.id.dateCreatedText)
        val dateCompletedText: TextView = root.findViewById(R.id.dateCompletedText)

        // Set Event Listeners
        checkBoxTodoComplete.setOnClickListener {
            val box: CheckBox = it as CheckBox
            model.setCurrentTodoComplete(box.isChecked)
        }


        // Observe LiveData
        model.selectedItem.observe(viewLifecycleOwner) {
            Log.d("EditTodoFrag", "Trying to observe changes to $it")
            textViewTodoName.hint = it.name
            checkBoxTodoComplete.isChecked = it.completed
            dateCreatedText.text = "Created ${it.getCreationDate()}"
            if (it.getCompletionDate() != null){
                dateCompletedText.text = "Completed ${it.getCompletionDate()}"
            } else {
                dateCompletedText.text = ""
            }
        }

        return root
    }


}