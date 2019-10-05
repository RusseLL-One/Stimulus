package com.one.russell.stimulus.ui.home_screen

import com.arellomobile.mvp.MvpView
import com.one.russell.stimulus.data.model.Task

interface HomeView : MvpView {
    fun showMessage(message: String)
    fun onTasksLoaded(taskList: List<Task>)
}