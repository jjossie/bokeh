package com.jjossie.bokeh.data.model

/**
 * Represents a daily (sort of) goal for the user, including their progress towards achieving said goal.
 * Parent class for the two kinds of goals to modularize their common behavior/attributes.
 */
abstract class Goal(
    override val id: Int,
    var name: String,
    val type: CompletionConditionType
) : Task() {
    // TODO field indicating when this resets (daily, weekly, etc)
    override var completed: Boolean = false
    abstract fun reset()
    abstract fun getProgressPercent(): Int
    override fun toString(): String {
        return "$id) [${if (completed) "✅" else " "}] $name: "
    }
}