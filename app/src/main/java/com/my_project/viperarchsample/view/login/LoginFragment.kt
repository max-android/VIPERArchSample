package com.my_project.viperarchsample.view.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.widget.textChanges
import com.my_project.viperarchsample.R
import com.my_project.viperarchsample.presenter.login.LoginPresenter
import com.my_project.viperarchsample.presenter.login.LoginView
import com.my_project.viperarchsample.view.main.MainActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import kotlinx.android.synthetic.main.login_fragment.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.support.v4.indeterminateProgressDialog


class LoginFragment : MvpAppCompatFragment(), LoginView {

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    @JvmField
    @InjectPresenter
    var lPresenter: LoginPresenter? = null

    private val subscriptions = CompositeDisposable()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeSignInButtonClicks()
        observeSignInButtonState()
    }

    override fun showSuccess() {
        (activity as MainActivity).showUsers()
    }

    override fun showError(message: String) {
        showAuthorizationError(message)
    }

    @SuppressLint("RxSubscribeOnError")
    private fun observeSignInButtonClicks() {
        subscriptions.add(
            loginButton.clicks().subscribe {
                signIn()
            }
        )
    }

    @SuppressLint("RxSubscribeOnError")
    private fun observeSignInButtonState() {
        subscriptions.add(
            Observables.combineLatest(emailEditText.textChanges(), passwordEditText.textChanges()) { login, password ->
                login.isNotBlank() && password.isNotBlank()
            }.subscribe { signInButtonEnabled ->
                loginButton.isEnabled = signInButtonEnabled
            }
        )
    }

    private fun signIn() {
        val login = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val progressDialog = indeterminateProgressDialog(R.string.progress_authorization)
        lPresenter?.login(login, password) { progressDialog.dismiss() }
    }

    private fun showAuthorizationError(message: String) {
        loginLayout?.let {
            snackbar(it, message)
        }
    }

}