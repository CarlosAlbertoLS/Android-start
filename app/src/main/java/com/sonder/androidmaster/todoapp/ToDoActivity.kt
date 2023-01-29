package com.sonder.androidmaster.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.sonder.androidmaster.R
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
        initListeners()
    }

    private fun initListeners() {
        binding.fabAddTask.setOnClickListener { showDialod() }
    }

    private fun showDialod() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedID = rgCategories.checkedRadioButtonId
                val selectedRb: RadioButton = rgCategories.findViewById(selectedID)
                val currentCategory: TaskCategory = when (selectedRb.text) {
                    getString(R.string.rbbusiness) -> Business
                    getString(R.string.rbPersonal) -> Personal
                    else -> Other
                }
                tasks.add(Task(currentTask, currentCategory))
                updateTask()
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories){ position ->
            categories[position].isSelected = !categories[position].isSelected
            categoriesAdapter.notifyItemChanged(position)
            updateTask()
        }
        binding.rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks){position ->
            tasks[position].isSelected = !tasks[position].isSelected
            updateTask()
        }
        binding.rvTask.layoutManager = LinearLayoutManager(this)
        binding.rvTask.adapter = taskAdapter
    }

    private fun updateTask(){
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTask = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks =newTask
        taskAdapter.notifyDataSetChanged()
    }
}