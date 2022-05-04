package matUHub.githubgeek

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReposViewModel : ViewModel() {
    val _echoMessage = MutableLiveData<String>()
    val echoMessage: LiveData<String> = _echoMessage

    fun onShowRepos(username: String) {
_echoMessage.postValue(username)
    }
}