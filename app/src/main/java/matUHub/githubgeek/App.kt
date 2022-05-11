package matUHub.githubgeek

import android.app.Application
import android.content.Context
import matUHub.githubgeek.data.MockProjectRepoImpl
import matUHub.githubgeek.data.retrofit.GitHubApi
import matUHub.githubgeek.data.retrofit.RetrofitProjectRepoImpl
import matUHub.githubgeek.di.appModule
import matUHub.githubgeek.domain.ProjectsRepo
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule)

        }
    }
}

