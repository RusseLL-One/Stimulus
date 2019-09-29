package com.one.russell.stimulus.ui.home_screen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.one.russell.stimulus.R
import com.one.russell.stimulus.data.model.Task

class TaskAdapter(private val items: List<Task>, private val context: Context, private val onTaskClicked: (Task) -> Unit, private val onAddTaskClicked: () -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_TASK = 0
    private val TYPE_ADD_TASK = 1

    override fun getItemCount(): Int {
        return items.size + 1 // +1 итем для добавления тасков
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == items.size) TYPE_ADD_TASK
        else TYPE_TASK
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TASK -> TaskViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.cell_task,
                    parent,
                    false
                )
            )
            else /*TYPE_ADD_TASK*/ -> AddTaskViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.cell_add_task,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_TASK -> (holder as TaskViewHolder).bind(items[position], onTaskClicked)
            TYPE_ADD_TASK -> (holder as AddTaskViewHolder).bind(onAddTaskClicked)
        }
    }
}