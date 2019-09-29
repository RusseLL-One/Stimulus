package com.one.russell.stimulus.ui.home_screen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cell_add_task.view.*

class AddTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.txt_title

    fun bind(onAddTaskClicked: () -> Unit) {
        itemView.setOnClickListener { onAddTaskClicked() }
    }
}