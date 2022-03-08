package com.jjossie.bokeh.data.model

import kotlin.math.roundToInt


/**
 * A simple type of goal containing a target goal and a counter representing progress towards that target.
 */
class CountGoal(
    id: Int,
    name: String,
    private var completionTarget: Int,
    private val units: String
) : Goal(id = id, name = name, type = CompletionConditionType.Count) {
    private var numberCompleted = 0

    fun addCount(count: Int) {
        numberCompleted += count
    }

    fun subtractCount(count: Int) {
        numberCompleted -= count
    }

    fun updateProgress() {
        completed = numberCompleted == completionTarget
    }

    override fun reset() {
        numberCompleted = 0
        completed = false
    }

    override fun getProgressPercent(): Int {
        return ((numberCompleted).toDouble() / (completionTarget).toDouble()).roundToInt()
    }

    override fun toString(): String {
        return super.toString() + "$numberCompleted/$completionTarget ${units}(s) (${getProgressPercent()}% complete)"
    }

}