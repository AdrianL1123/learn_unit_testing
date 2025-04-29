package com.example.unit_testing.data.repo

import com.example.unit_testing.data.model.Task

interface TaskRepo {
    fun getTasks(): List<Task>
    fun addTask(task: Task)
    fun getTask(id: Int): Task?
    fun update(id: Int, task: Task)
    fun delete(id: Int)
}