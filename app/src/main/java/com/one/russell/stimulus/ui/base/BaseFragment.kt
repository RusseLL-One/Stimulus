package com.one.russell.stimulus.ui.base
/*
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
import kotlinx.android.synthetic.main.component_toolbar.*
import kotlinx.android.synthetic.main.fragment_home.*

class BaseFragment : MvpAppCompatFragment(), HomeView {
    @InjectPresenter
    lateinit var homePresenter: HomePresenter

    @ProvidePresenter
    fun provideHomePresenter(): HomePresenter {
        return HomePresenter(Utils.getNavController(activity), Utils.getRepository(activity))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Utils.setupToolbar(toolbar, Utils.getNavController(activity))

        onTaskAdded()
    }

    override fun onTaskAdded() { //TODO сделать нормально, с помощью Rx
        val tasks = homePresenter.getTasks()
        if (tasks != null) {
            val adapter = TaskAdapter(
                tasks, requireContext(),
                homePresenter::onTaskClicked,
                homePresenter::onAddTaskClicked
            )
            list_tasks.adapter = adapter
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}*/
