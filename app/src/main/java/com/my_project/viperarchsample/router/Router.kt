package com.my_project.viperarchsample.router

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import com.my_project.viperarchsample.R
import com.my_project.viperarchsample.view.login.LoginFragment
import com.my_project.viperarchsample.view.sources.SourcesFragment
import com.my_project.viperarchsample.view.users.UsersFragment


class Router {
   lateinit var screen: String

    fun createFragment(fragmentManager: FragmentManager, screenKey: String) = when (screenKey) {

        Screens.LOGIN_FRAGMENT -> {
            screen = Screens.LOGIN_FRAGMENT
            Log.d("--LOG-fr", "LOGIN_FRAGMENT")
            showScreen(fragmentManager, LoginFragment.newInstance(), false)
        }

        Screens.USERS_FRAGMENT -> {
            screen = Screens.USERS_FRAGMENT
            Log.d("--LOG-fr", "USERS_FRAGMENT")
            showScreen(fragmentManager,UsersFragment.newInstance(), false)
        }

        Screens.SOURCES_FRAGMENT -> {
            screen = Screens.SOURCES_FRAGMENT
            Log.d("--LOG-fr", "SOURCES_FRAGMENT")
            showScreen(fragmentManager, SourcesFragment.newInstance(), false)
        }

        else -> throw Exception("unknown case")
    }

    private fun showScreen(fragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean) {
        fragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .apply { if (addToBackStack) addToBackStack(null) }
            .setCustomAnimations(
                R.animator.slide_in_left,
                R.animator.slide_in_right
            )
            .commitAllowingStateLoss()
    }
}