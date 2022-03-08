package com.jjossie.bokeh.data.model

import java.time.LocalDate
import kotlin.math.roundToInt

/**
 * A Goal whose completion is based on the number of items checked off a TodoList on a given day.
 */
class TodoGoal(
    id: Int,
    name: String,
    private var todoList: TodoList,
    private var completionTarget: Int,
) : Goal(id = id, name = name, type = CompletionConditionType.Todo) {
    private var numberCompleted: Int = 0

    internal fun updateProgress() {
//        debug("Goal $name progress before update: $numberCompleted")
        numberCompleted = todoList.getTodosCompletedOn(LocalDate.now()).size
//        debug("after update: $numberCompleted")
        completed = numberCompleted >= completionTarget
    }

    override fun getProgressPercent(): Int {
        updateProgress()
        return ((numberCompleted).toDouble() / (completionTarget).toDouble() * 100).roundToInt()
    }

    override fun toString(): String {
        return super.toString() + "$numberCompleted/$completionTarget ToDos (${getProgressPercent()}% complete)"
    }

    override fun reset() {
        numberCompleted = 0
        completed = false
    }
}
