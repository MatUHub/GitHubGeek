package matUHub.githubgeek.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import matUHub.githubgeek.GitProjectEntity
import matUHub.githubgeek.databinding.ItemUserBinding

class GitProjectViewHolder(private val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): GitProjectViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return GitProjectViewHolder(ItemUserBinding.inflate(inflater))
        }
    }

    fun bind(item: GitProjectEntity) {
        binding.itemIdUser.text = item.id.toString()
        binding.itemNameUser.text = item.name
    }
}