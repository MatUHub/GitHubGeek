package matUHub.githubgeek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import matUHub.githubgeek.GitProjectEntity
import matUHub.githubgeek.domain.ProjectsRepo

class ReposViewModel(private val gitProjectRepo: ProjectsRepo) : ViewModel() {
    private val _repos = MutableLiveData<List<GitProjectEntity>>()
    val repos: LiveData<List<GitProjectEntity>> = _repos
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun onShowRepos(username: String) {
        compositeDisposable.add(
            gitProjectRepo
                .observerReposForUser(username)
                .subscribeBy {
                    _repos.postValue(it)
                }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()

    }
}