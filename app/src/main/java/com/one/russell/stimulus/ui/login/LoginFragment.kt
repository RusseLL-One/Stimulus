package com.one.russell.stimulus.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.one.russell.stimulus.R
import com.one.russell.stimulus.Utils.Companion.getNavController
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : MvpAppCompatFragment(), LoginView {

    private val GOOGLE_AUTH_REQUEST_CODE = 789

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    @ProvidePresenter
    fun provideLoginPresenter(): LoginPresenter {
        return LoginPresenter(getNavController(activity), GoogleAuth(requireContext()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login.setOnClickListener { loginPresenter.onLoginClicked() }
        btn_google_sign_in.setOnClickListener { loginPresenter.onGoogleAuthClicked() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_AUTH_REQUEST_CODE) {
            loginPresenter.handleGoogleAuth(data)
        }
    }

    override fun navigateToGoogleAuth(intent: Intent) {
        startActivityForResult(intent, GOOGLE_AUTH_REQUEST_CODE)
    }

    override fun showMessage(message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}