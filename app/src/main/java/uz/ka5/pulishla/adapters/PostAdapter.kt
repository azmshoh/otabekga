package uz.ka5.pulishla.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ka5.pulishla.R
import uz.ka5.pulishla.database.model.PostModel
import uz.ka5.pulishla.databinding.PostItemBinding

class PostAdapter() : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindingViewHolder(doc: PostModel) {

        }
    }

    var model: MutableList<PostModel> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(PostItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindingViewHolder(model[position])
    }

    override fun getItemCount() = model.size
}