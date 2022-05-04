package matUHub.githubgeek.data

import io.reactivex.rxjava3.core.Single
import matUHub.githubgeek.GitProjectEntity
import matUHub.githubgeek.domain.ProjectsRepo

class MockProjectRepoImpl: ProjectsRepo {
    override fun observerReposForUser(username: String): Single<List<GitProjectEntity>> {
        val dummyList = listOf(
            GitProjectEntity(1, "a"),
            GitProjectEntity(2, "б"),
            GitProjectEntity(3, "в"),
            GitProjectEntity(4, "г"),
            GitProjectEntity(5, "д"),
        )

        return Single.just(dummyList)
    }
}
