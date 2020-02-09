package com.one.russell.stimulus.ui.home_screen

import androidx.navigation.NavController
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.one.russell.stimulus.R
import com.one.russell.stimulus.data.model.Task
import com.one.russell.stimulus.domain.Repository
import kotlinx.coroutines.*

@InjectViewState
class HomePresenter(private val navController: NavController?, private val repository: Repository?) : MvpPresenter<HomeView>() {

    private var screenScope = CoroutineScope(Job())

    fun getTasks() {
        screenScope.launch(Dispatchers.Main) {
            val tasks = repository?.observeAllTasks()
            if (tasks != null) {
                viewState.onTasksLoaded(tasks)
            }
        }
    }

    fun onTaskClicked(task: Task) {
        viewState.showMessage(task.title)
    }

    fun onAddTaskClicked() {
        viewState.showMessage("onAddTaskClicked")

        navController?.navigate(R.id.action_homeFragment_to_newTaskFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        screenScope.cancel()
    }
}