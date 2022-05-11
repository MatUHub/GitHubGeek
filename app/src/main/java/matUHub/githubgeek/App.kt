package matUHub.githubgeek

import android.app.Application
import android.content.Context
import matUHub.githubgeek.data.MockProjectRepoImpl
import matUHub.githubgeek.data.retrofit.GitHubApi
import matUHub.githubgeek.data.retrofit.RetrofitProjectRepoImpl
import matUHub.githubgeek.domain.ProjectsRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application(){
    private val baseUrl = "https://api.github.com/"
    private val jsonConverter by lazy {GsonConverterFactory.create()}
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(jsonConverter)
            .build()
    }
    private val gitHubApi: GitHubApi =  retrofit.create(GitHubApi::class.java)
    val gitProjectRepo: ProjectsRepo by lazy {
        RetrofitProjectRepoImpl(gitHubApi) }
}

val Context.app: App
get() = applicationContext as App