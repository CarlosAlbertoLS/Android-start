package com.sonder.androidmaster.todoapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sonder.androidmaster.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvCategotyName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)

    fun render(taskCategory: TaskCategory){
        when(taskCategory){
            TaskCategory.Business -> {
                tvCategotyName.text = "Negocios"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.business_category))
            }
            TaskCategory.Personal -> {
                tvCategotyName.text = "Personal"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.personal_category))
            }
            TaskCategory.Other -> {
                tvCategotyName.text = "Otros"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.other_category))
            }
        }
    }
}