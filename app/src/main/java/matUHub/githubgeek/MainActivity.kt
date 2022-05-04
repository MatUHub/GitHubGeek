package matUHub.githubgeek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import matUHub.githubgeek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ReposViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniViewModelEvents()
        initViewEvents()

    }

    private fun iniViewModelEvents(){
        viewModel.echoMessage.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViewEvents(){
        binding.searchButton.setOnClickListener {
            val username = binding.nameEditText.text.toString()
            viewModel.onShowRepos(username)
        }
    }
}