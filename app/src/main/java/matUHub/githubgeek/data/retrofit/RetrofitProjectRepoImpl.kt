package matUHub.githubgeek.data.retrofit

import io.reactivex.rxjava3.core.Single
import matUHub.githubgeek.GitProjectEntity
import matUHub.githubgeek.domain.ProjectsRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProjectRepoImpl: ProjectsRepo {


       private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
           .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun observerReposForUser(username: String): Single<List<GitProjectEntity>> {

       return Single.create{ emitter ->
            val call = api.listRepos(username)
            call.enqueue(object : Callback<List<GitProjectEntity>>{
                override fun onResponse(
                    call: Call<List<GitProjectEntity>>,
                    response: Response<List<GitProjectEntity>>
                ) {
                   emitter.onSuccess(response.body())
                }

                override fun onFailure(call: Call<List<GitProjectEntity>>, t: Throwable) {
                   emitter.onError(t)
                }
            })
        }
    }
}