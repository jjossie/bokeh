package com.jjossie.bokeh.ui.todo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jjossie.bokeh.R
import java.time.format.DateTimeFormatter

class EditTodoFragment : Fragment() {

    private val model: TodoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Get root View
        val root = inflater.inflate(R.layout.edit_todo_fragment, container, false)
        // Get component Views
        val editTextTodoTitle: EditText = root.findViewById(R.id.editTextTodoName)
        val editTextTodoDescription: EditText = root.findViewById(R.id.editTextTodoDescription)
        val checkBoxTodoComplete: CheckBox = root.findViewById(R.id.checkBoxTodoComplete)
        val dateCreatedText: TextView = root.findViewById(R.id.dateCreatedText)
        val dateCompletedText: TextView = root.findViewById(R.id.dateCompletedText)
        val saveButton: Button = root.findViewById(R.id.editTodoSaveButton)

        // Set Event Listeners
        checkBoxTodoComplete.setOnClickListener {
            val box: CheckBox = it as CheckBox
            model.setCurrentTodoComplete(box.isChecked)
        }
        saveButton.setOnClickListener{
            // Update LiveData?
            model.selectedItem.value!!.name = editTextTodoTitle.text.toString()
            model.selectedItem.value!!.description = editTextTodoDescription.text.toString()
            findNavController().navigateUp()
        }


        // Observe LiveData
        model.selectedItem.observe(viewLifecycleOwner) {
            Log.d("EditTodoFrag", "Trying to observe changes to $it")
            editTextTodoTitle.text.insert(0, it.name)
            editTextTodoDescription.text.insert(0, it.description?: "")
            checkBoxTodoComplete.isChecked = it.completed
            val formatter = DateTimeFormatter.ofPattern("MM/dd")
            dateCreatedText.text = "Created ${formatter.format(it.getCreationDate())}"
            if (it.getCompletionDate() != null){
                dateCompletedText.text = "Completed ${formatter.format(it.getCompletionDate())}"
            } else {
                dateCompletedText.visibility = View.GONE
            }
        }

        return root
    }


}