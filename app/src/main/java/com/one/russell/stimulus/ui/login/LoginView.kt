package com.one.russell.stimulus.ui.login

import android.content.Intent
import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {
    fun showMessage(message: Int)
    fun navigateToGoogleAuth(intent: Intent)
}