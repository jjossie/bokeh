package com.jjossie.bokeh.ui.todo

import android.os.Debug
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjossie.bokeh.data.Repository
import com.jjossie.bokeh.data.model.Todo

class TodoViewModel : ViewModel() {

    private val _todos = MutableLiveData<ArrayList<Todo>>().apply {
        value = Repository().loadTodos()
    }
    val selectedItem = MutableLiveData<Todo>()
    val todos: LiveData<ArrayList<Todo>> = _todos

    fun select(position: Int) {
        val todo = _todos.value!![position]
        selectedItem.setValue(todo)
        Log.d("TodoViewModel", "selected ${selectedItem.value}")
    }

    fun setComplete(position: Int, completed: Boolean){
        val todo = _todos.value!![position]
        if (completed){
            todo.complete()
        } else {
            todo.incomplete()
        }
    }

    fun setCurrentTodoComplete(completed: Boolean){
        if (completed){
            selectedItem.value!!.complete()
        } else {
            selectedItem.value!!.incomplete()
        }
    }


    fun createNewTodo(){
        var newTodo = Todo(12, "")
        selectedItem.value = newTodo
        _todos.value!!.add(newTodo)
    }

}