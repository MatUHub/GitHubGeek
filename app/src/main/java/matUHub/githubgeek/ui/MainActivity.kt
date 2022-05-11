package matUHub.githubgeek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import matUHub.githubgeek.app
import matUHub.githubgeek.databinding.ActivityMainBinding
import matUHub.githubgeek.domain.ProjectsRepo

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val gitRepo: ProjectsRepo by lazy { app.gitProjectRepo }
    private val viewModel: ReposViewModel by viewModels {ReposViewModelFactory(gitRepo)}
    private val adapter = GitProjectAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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