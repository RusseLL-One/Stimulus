package com.one.russell.stimulus.ui.login

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.one.russell.stimulus.R
import android.content.Intent
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException

@InjectViewState
class LoginPresenter(private val navController: NavController?, private val googleAuth: GoogleAuth) : MvpPresenter<LoginView>() {


    fun onLoginClicked() {
        navController?.navigate(R.id.action_loginFragment_to_homeFragment)
    }

    fun onGoogleAuthClicked() {
        val signInIntent = googleAuth.googleSignInClient.signInIntent
        viewState.navigateToGoogleAuth(signInIntent)
    }

    fun handleGoogleAuth(resultData: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(resultData)
        try {
            val account = task.getResult(ApiException::class.java)
            navController?.navigate(R.id.action_loginFragment_to_homeFragment)
        } catch (e: ApiException) { //TODO сейчас всегда приходит экспешн - это из-за несоответствия SHA-1 в приложе и в Firebase. Нужно подписать тем же ключом, с помощью которого сгенерирован SHA-1
            //Log.w(TAG, "signInResult:failed code=" + e.statusCode) //TODO заменить на Timber
            //updateUI(null)
        }
    }
}