package matUHub.githubgeek

import android.app.Application
import android.content.Context
import matUHub.githubgeek.data.MockProjectRepoImpl
import matUHub.githubgeek.data.retrofit.GitHubApi
import matUHub.githubgeek.data.retrofit.RetrofitProjectRepoImpl
import matUHub.githubgeek.di.AppDependenciesComponent
import matUHub.githubgeek.di.DaggerAppDependenciesComponent

import matUHub.githubgeek.domain.ProjectsRepo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application(){
    lateinit var appDependenciesComponent: AppDependenciesComponent

    override fun onCreate() {
        super.onCreate()
        appDependenciesComponent = DaggerAppDependenciesComponent
            .builder()

            .build()
    }
}

val Context.app: App
get(){
    return applicationContext as App
}

