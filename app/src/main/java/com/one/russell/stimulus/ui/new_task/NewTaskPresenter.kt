package com.one.russell.stimulus.ui.new_task

import androidx.navigation.NavController
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.one.russell.stimulus.data.model.Task
import com.one.russell.stimulus.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@InjectViewState
class NewTaskPresenter(private val navController: NavController?, private val repository: Repository?) : MvpPresenter<NewTaskView>() {

    private var dbSubscription: Job? = null
    private var webSubscription: Job? = null
    private var screenScope = CoroutineScope(Job())

    fun onSubmit(newTask: Task) {
        screenScope.launch {
            repository?.addTask(newTask)
        }
        screenScope.launch {
            repository?.sendNewTask(newTask)
        }
        //dbSubscription = repository?.addTask(newTask)?.subscribe()
        //webSubscription = repository?.sendNewTask(newTask)?.subscribe()
        navController?.popBackStack()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbSubscription?.cancel()
        webSubscription?.cancel()
    }
}