package com.sonder.androidmaster.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sonder.androidmaster.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCategotyName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {
        itemView.setOnClickListener { onItemSelected(layoutPosition) }
        val color = if (taskCategory.isSelected) {
            R.color.background_card
        } else {
            R.color.background_disabled
        }
        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, color))
        when (taskCategory) {
            TaskCategory.Business -> {
                tvCategotyName.text = "Negocios"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.business_category
                    )
                )
            }
            TaskCategory.Personal -> {
                tvCategotyName.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.personal_category
                    )
                )
            }
            TaskCategory.Other -> {
                tvCategotyName.text = "Otros"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.other_category
                    )
                )
            }
        }
    }
}