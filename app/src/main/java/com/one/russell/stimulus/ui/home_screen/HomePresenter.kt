package com.one.russell.stimulus.ui.home_screen

import androidx.navigation.NavController
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.one.russell.stimulus.data.model.Task

@InjectViewState
class HomePresenter(private val navController: NavController?) : MvpPresenter<HomeView>() {

    fun getTasks(): List<Task> {
        val taskList = ArrayList<Task>()
        taskList.add(Task(0, "Съесть бутербродик", "Я не доел один бутербродик и его надо съесть"))
        taskList.add(Task(1, "Качнуть вара", "Мне осталось совсем немного до 110 уровня"))
        taskList.add(Task(2, "Съешь булку", "съешь ещё этих мягких французских булок, да выпей чаю"))
        taskList.add(Task(3, "Съешь булку", "съешь ещё этих мягких французских булок, да выпей чаю"))
        taskList.add(Task(4, "Съешь булку", "съешь ещё этих мягких французских булок, да выпей чаю"))
        taskList.add(Task(5, "Съешь булку", "съешь ещё этих мягких французских булок, да выпей чаю"))
        taskList.add(Task(6, "Съешь булку", "съешь ещё этих мягких французских булок, да выпей чаю"))
        taskList.add(Task(7, "Съешь булку", "съешь ещё этих мягких французских булок, да выпей чаю"))
        taskList.add(Task(8, "Съешь булку", "съешь ещё этих мягких французских булок, да выпей чаю"))
        return taskList
    }

    fun onTaskClicked(task: Task) {
        viewState.showMessage(task.title)
    }

    fun onAddTaskClicked() {
        viewState.showMessage("onAddTaskClicked")

    }
}