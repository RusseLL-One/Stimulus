package com.one.russell.stimulus.ui.home_screen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.one.russell.stimulus.data.model.Task
import kotlinx.android.synthetic.main.cell_task.view.*

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.txt_title
    private val description = itemView.txt_description

    fun bind(task: Task, onTaskClicked: (Task) -> Unit) {
        title.text = task.title
        description.text = task.description

        itemView.setOnClickListener { onTaskClicked(task) }
    }
}