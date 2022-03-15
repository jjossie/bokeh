package com.jjossie.bokeh.ui.todo

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

    fun select(item: Todo) {
        selectedItem.value = item
    }
}