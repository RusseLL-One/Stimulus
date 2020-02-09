package com.one.russell.stimulus.ui.new_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.one.russell.stimulus.R
import com.one.russell.stimulus.Utils
import com.one.russell.stimulus.data.model.Task
import com.one.russell.stimulus.ui.home_screen.list.TaskAdapter
import kotlinx.android.synthetic.main.component_toolbar.*
import kotlinx.android.synthetic.main.fragment_new_task.*
import kotlin.random.Random

class NewTaskFragment : MvpAppCompatFragment(), NewTaskView {
    @InjectPresenter
    lateinit var newTaskPresenter: NewTaskPresenter

    @ProvidePresenter
    fun provideNewTaskPresenter(): NewTaskPresenter {
        return NewTaskPresenter(Utils.getNavController(activity), Utils.getRepository(activity))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_new_task, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Utils.setupToolbar(toolbar, Utils.getNavController(activity))

        btn_submit.setOnClickListener {
            val newTask = Task(Random(System.currentTimeMillis()).nextInt(), txt_title.text.toString(), txt_description.text.toString())
            newTaskPresenter.onSubmit(newTask)
        }
    }
}
