package matUHub.githubgeek.di

import matUHub.githubgeek.data.retrofit.GitHubApi
import matUHub.githubgeek.data.retrofit.RetrofitProjectRepoImpl
import matUHub.githubgeek.domain.ProjectsRepo
import matUHub.githubgeek.ui.ReposViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.sin

val appModule = module {
    single (named("api_url")){"https://api.github.com/"}
    single<ProjectsRepo>{RetrofitProjectRepoImpl(get())}
    single<GitHubApi>{get<Retrofit>().create(GitHubApi::class.java)}
    single {
        Retrofit.Builder()
        .baseUrl(get<String>(named("api_url")))
        .addConverterFactory(get())
        .build()
    }
    factory< Converter.Factory>{GsonConverterFactory.create() }

    viewModel{
        ReposViewModel(get())
    }
}