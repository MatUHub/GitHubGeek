package matUHub.githubgeek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels


import androidx.recyclerview.widget.LinearLayoutManager
import matUHub.githubgeek.app
import matUHub.githubgeek.data.MockProjectRepoImpl
import matUHub.githubgeek.databinding.ActivityMainBinding
import matUHub.githubgeek.domain.ProjectsRepo
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var gitProjectRepo: ProjectsRepo
    private val viewModel: ReposViewModel by viewModels{
        ReposViewModelFactory(gitProjectRepo)
    }
    private val adapter = GitProjectAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app.appDependenciesComponent.inject(this)

        iniViewModelEvents()
        initViewEvents()
initViews()
    }

    private fun initViews() {
        binding.itemRecycleView.layoutManager = LinearLayoutManager(this)
        binding.itemRecycleView.adapter = adapter
    }


    private fun iniViewModelEvents(){
        viewModel.repos.observe(this){
            adapter.setData(it)
        }
    }

    private fun initViewEvents(){
        binding.searchButton.setOnClickListener {
            val username = binding.nameEditText.text.toString()
            viewModel.onShowRepos(username)
        }
    }
}