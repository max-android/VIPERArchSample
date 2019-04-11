package com.my_project.viperarchsample.di

import com.my_project.viperarchsample.di.modules.InteractorModule
import com.my_project.viperarchsample.di.modules.LocalHolderModule
import com.my_project.viperarchsample.di.modules.RouterModule
import com.my_project.viperarchsample.di.modules.ServiceModule
import com.my_project.viperarchsample.presenter.login.LoginPresenter
import com.my_project.viperarchsample.presenter.main.MainPresenter
import com.my_project.viperarchsample.presenter.sources.SourcePresenter
import com.my_project.viperarchsample.presenter.users.UsersPresenter
import com.my_project.viperarchsample.view.login.LoginFragment
import com.my_project.viperarchsample.view.main.MainActivity
import com.my_project.viperarchsample.view.sources.SourcesFragment
import com.my_project.viperarchsample.view.users.UsersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RouterModule::class,
        InteractorModule::class,
        LocalHolderModule::class,
        ServiceModule::class
    ]
)

interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
    fun injectLoginFragment(loginFragment: LoginFragment)
    fun injectUsersFragment(settingsFragment: UsersFragment)
    fun injectSourcesFragment(sourcesFragment: SourcesFragment)
    fun injectMainPresenter(locationPresenter: MainPresenter)
    fun injectLoginPresenter(loginPresenter: LoginPresenter)
    fun injectUsersPresenter(usersPresenter: UsersPresenter)
    fun injectSourcePresenter(sourcePresenter: SourcePresenter)
}