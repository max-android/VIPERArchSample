package com.my_project.viperarchsample.view.users

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.my_project.viperarchsample.R
import com.my_project.viperarchsample.entity.users.WrapUser
import com.my_project.viperarchsample.presenter.users.UsersPresenter
import com.my_project.viperarchsample.presenter.users.UsersView
import com.my_project.viperarchsample.view.common.InfoAlert
import com.my_project.viperarchsample.view.main.MainActivity
import kotlinx.android.synthetic.main.users_fragment.*
import org.jetbrains.anko.support.v4.longToast


class UsersFragment : MvpAppCompatFragment(), UsersView {

    companion object {
        fun newInstance(): UsersFragment {
            return UsersFragment()
        }
    }

    @JvmField
    @InjectPresenter
    var presenter: UsersPresenter? = null
    private lateinit var usersAdapter: UsersAdapter
    private val infoAlert: InfoAlert = InfoAlert()

    @ProvidePresenter
    fun provideUsersPresenter(): UsersPresenter = UsersPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.users_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        if (savedInstanceState == null)
            presenter?.users()
    }

    override fun showUsers(users: List<WrapUser>) {
        usersAdapter.setData(users)
    }

    override fun showError(message: String) {
        longToast(message)
    }

    override fun showProgress() {
        usersProgressBar.visibility = View.VISIBLE
    }

    override fun removeProgress() {
        usersProgressBar.visibility = View.GONE
    }

    private fun initViews() {
        usersAdapter = UsersAdapter {
            infoAlert.showAlert("select:" + it.user.firstName, context!!)
        }
        usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@UsersFragment.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@UsersFragment.context, LinearLayout.VERTICAL))
            adapter = usersAdapter
        }
        sourceStartButton.setOnClickListener { (activity as MainActivity).showSources() }
    }

    override fun onDestroy() {
        infoAlert.dismissAlert()
        super.onDestroy()
    }
}