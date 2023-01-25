package com.sonder.androidmaster.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sonder.androidmaster.appsuperhero.Task
import com.sonder.androidmaster.databinding.ActivityToDoBinding
import com.sonder.androidmaster.todoapp.TaskCategory.*

class ToDoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToDoBinding
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var taskAdapter: TaskAdapter
    private val categories = listOf(
        Business,
        Personal,
        Other
    )
    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        binding.rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks)
        binding.rvTask.layoutManager = LinearLayoutManager(this)
        binding.rvTask.adapter = taskAdapter
    }
}