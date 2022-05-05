package matUHub.githubgeek

import android.app.Application
import android.content.Context
import matUHub.githubgeek.data.MockProjectRepoImpl
import matUHub.githubgeek.data.retrofit.RetrofitProjectRepoImpl
import matUHub.githubgeek.domain.ProjectsRepo

class App: Application(){
    val gitProjectRepo: ProjectsRepo by lazy { RetrofitProjectRepoImpl() }
}

val Context.app: App
get() = applicationContext as App