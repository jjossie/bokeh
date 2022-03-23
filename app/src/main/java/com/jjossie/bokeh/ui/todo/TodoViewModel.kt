package com.jjossie.bokeh.ui.todo

import android.os.Debug
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjossie.bokeh.data.Repository
import com.jjossie.bokeh.data.model.Todo
import com.jjossie.bokeh.data.model.TodoList

class TodoViewModel : ViewModel() {

    private val _todoList = MutableLiveData<TodoList>().apply{
        value = Repository().getTodoList()
    }

    private val _todos = MutableLiveData<ArrayList<Todo>>().apply{
        value = _todoList.value!!.items
    }

    val selectedItem = MutableLiveData<Todo>()

    val todos: LiveData<ArrayList<Todo>>
        get() {
            return _todos
        }


    fun selectAtPosition(position: Int) {
        val todo = _todos.value!![position]
        selectedItem.value = todo
        Log.d("TodoViewModel", "selected ${selectedItem.value}")
    }

    fun markTodoAtPosition(position: Int, completed: Boolean){
        // Because To-do IDs are one-off from recyclerView position indexes
        _todoList.value!!.markTodo(position + 1, completed)
    }

    fun setCurrentTodoComplete(completed: Boolean){
        // This logic already exists in TodoList.markTodo, but it needs a position.
        if (completed){
            selectedItem.value!!.complete()
        } else {
            selectedItem.value!!.incomplete()
        }
    }

    fun createNewTodo(){
        selectedItem.value =  _todoList.value!!.addTodo("")
    }

}