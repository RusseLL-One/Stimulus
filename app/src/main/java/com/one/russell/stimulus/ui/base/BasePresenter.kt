package com.one.russell.stimulus.ui.base
/*
import androidx.navigation.NavController
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.one.russell.stimulus.data.model.Task
import com.one.russell.stimulus.domain.Repository
import io.reactivex.disposables.Disposable
import kotlin.random.Random

@InjectViewState
class BasePresenter(private val navController: NavController?, private val repository: Repository?) : MvpPresenter<HomeView>() {

    private var dbSubscription: Disposable? = null

    fun getTasks() {
        dbSubscription = repository?.observeAllTasks()?.subscribe({ viewState.onTasksLoaded(it) }, {  })
    }

    fun onTaskClicked(task: Task) {
        viewState.showMessage(task.title)
    }

    fun onAddTaskClicked() {
        viewState.showMessage("onAddTaskClicked")

        val task = Task(0, "Съешь булку" + (Random(System.currentTimeMillis()).nextInt() % 100), "съешь ещё этих мягких французских булок, да выпей чаю")
        repository?.addTask(task)
        viewState.onTaskAdded()
    }

}*/