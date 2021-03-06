package com.jjossie.bokeh.data.model

import java.time.LocalDate

@Suppress("UNCHECKED_CAST")

/**
 * Contains a list of To-Do objects and logic for organizing/maintaining them.
 */
class TodoList(var name: String) : ProductivityList() {

    public val items: ArrayList<Todo>
    get() {
        return itemList as ArrayList<Todo>
    }

    fun addTodo(name: String): Todo {
        val todo = Todo(nextId, name)
        nextId++
        itemList.add(todo)
        return todo
    }

    //    @Exclude
    fun getTodosCompletedOn(day: LocalDate): List<Todo> {
        return itemList.filter {
            if (it is Todo)
                it.getCompletionDate() == day
            else
                false
        } as List<Todo>
    }

    fun markTodo(id: Int, complete: Boolean) {
        val todoToComplete = itemList.find { it.id == id } as Todo? ?: throw Error()
        if (complete)
            todoToComplete.complete()
        else
            todoToComplete.incomplete()
    }
}
