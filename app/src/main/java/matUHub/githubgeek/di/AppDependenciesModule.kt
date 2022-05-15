package matUHub.githubgeek.di

import dagger.Module
import dagger.Provides
import matUHub.githubgeek.data.retrofit.GitHubApi
import matUHub.githubgeek.data.retrofit.RetrofitProjectRepoImpl
import matUHub.githubgeek.domain.ProjectsRepo
import matUHub.githubgeek.ui.ReposViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.math.sin

/*val appModule = module {

    single<GitHubApi> { get<Retrofit>().create(GitHubApi::class.java) }

    viewModel {
        ReposViewModel(get())
    }*/

    @Module
    class AppDependenciesModule {

        @Singleton
        @Provides
        fun provideGitHubApi(retrofit: Retrofit): GitHubApi{
            return retrofit.create(GitHubApi::class.java)
        }
        @Singleton
        @Provides
        fun provideProjectsRepo(api: GitHubApi): ProjectsRepo{
            return RetrofitProjectRepoImpl(api)
        }

        @Provides
        fun provideBaseUrl(): String{
            return "https://api.github.com/"
        }
       @Provides
       fun providerConverterFactory(): Converter.Factory{
           return GsonConverterFactory.create()
       }
        @Singleton
        @Provides
        fun providerRetrofit(baseUrl: String, converterFactory: Converter.Factory): Retrofit {
           return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .build()
        }
    }

