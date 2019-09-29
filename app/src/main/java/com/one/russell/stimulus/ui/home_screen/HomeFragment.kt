package com.one.russell.stimulus.ui.home_screen

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
import kotlinx.android.synthetic.main.component_toolbar.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : MvpAppCompatFragment(), HomeView {
    @InjectPresenter
    lateinit var homePresenter: HomePresenter

    @ProvidePresenter
    fun provideHomePresenter(): HomePresenter {
        return HomePresenter(Utils.getNavController(activity))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Utils.setupToolbar(toolbar, Utils.getNavController(activity))

        val adapter = TaskAdapter(homePresenter.getTasks(), requireContext(), homePresenter::onTaskClicked, homePresenter::onAddTaskClicked)
        list_tasks.adapter = adapter
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
