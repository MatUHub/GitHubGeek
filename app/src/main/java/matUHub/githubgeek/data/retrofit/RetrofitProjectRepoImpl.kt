package matUHub.githubgeek.data.retrofit

import io.reactivex.rxjava3.core.Single
import matUHub.githubgeek.GitProjectEntity
import matUHub.githubgeek.domain.ProjectsRepo
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProjectRepoImpl(private val api: GitHubApi): ProjectsRepo {

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