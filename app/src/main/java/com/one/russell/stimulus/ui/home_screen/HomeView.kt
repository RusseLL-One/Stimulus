package com.one.russell.stimulus.ui.home_screen

import com.arellomobile.mvp.MvpView

interface HomeView : MvpView {
    fun showMessage(message: String)
}