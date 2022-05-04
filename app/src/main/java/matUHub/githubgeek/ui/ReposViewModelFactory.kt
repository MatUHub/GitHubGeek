package matUHub.githubgeek.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import matUHub.githubgeek.domain.ProjectsRepo

class ReposViewModelFactory(private val repo: ProjectsRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReposViewModel(repo) as T
    }
}