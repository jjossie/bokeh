package com.jjossie.bokeh.data

import com.jjossie.bokeh.data.model.CompletionConditionType
import com.jjossie.bokeh.data.model.GoalList
import com.jjossie.bokeh.data.model.Todo
import com.jjossie.bokeh.data.model.TodoList

class Repository {

    private val todoList: TodoList = TodoList("main")
    private val goalList: GoalList = GoalList()

    init {
        createDummyData()
    }

    private fun createDummyData(){

        todoList.addTodo("Take out da trash")
        todoList.addTodo("ur mum")
        todoList.addTodo("get paid")
        todoList.addTodo("go raid")
        todoList.addTodo("gatorade")
        todoList.addTodo("get lit")
        todoList.addTodo("do hw")
        todoList.addTodo("make new friends")
        todoList.addTodo("make an app")
        todoList.addTodo("become wealthy")
        todoList.addTodo("go back to monke")

        goalList.addGoal("Daily Target", CompletionConditionType.Todo, 3, todoList = todoList)
        goalList.addGoal("Get Yoked", CompletionConditionType.Count, 100, units = "push-ups")
    }

    fun getTodoList(): TodoList {
        return todoList
    }

    fun loadTodos(): ArrayList<Todo> {
        return todoList.itemList as ArrayList<Todo>
    }

}