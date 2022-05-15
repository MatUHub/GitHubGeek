package matUHub.githubgeek.di

import dagger.Component
import matUHub.githubgeek.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppDependenciesModule::class
    ]
)
interface AppDependenciesComponent {
    fun inject(mainActivity: MainActivity)
}