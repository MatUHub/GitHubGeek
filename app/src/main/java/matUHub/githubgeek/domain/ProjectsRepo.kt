package matUHub.githubgeek.domain

import io.reactivex.rxjava3.core.Single
import matUHub.githubgeek.GitProjectEntity

interface ProjectsRepo {
    fun observerReposForUser(username: String): Single<List<GitProjectEntity>>
}