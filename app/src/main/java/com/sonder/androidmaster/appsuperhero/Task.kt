package com.sonder.androidmaster.appsuperhero

import com.sonder.androidmaster.todoapp.TaskCategory

data class Task(
    val name:String,
    val category: TaskCategory,
    var isSelected: Boolean = false
)