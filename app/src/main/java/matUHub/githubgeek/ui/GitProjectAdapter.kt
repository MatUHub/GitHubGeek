package matUHub.githubgeek.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import matUHub.githubgeek.GitProjectEntity

class GitProjectAdapter: RecyclerView.Adapter<GitProjectViewHolder>() {
    private var data: List<GitProjectEntity> = emptyList()

    fun setData(repos: List<GitProjectEntity>){
        data = repos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitProjectViewHolder {
        return GitProjectViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: GitProjectViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(pos: Int): GitProjectEntity = data[pos]

    override fun getItemCount(): Int = data.size

}
