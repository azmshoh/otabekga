package uz.ka5.pulishla.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import uz.ka5.pulishla.R
import uz.ka5.pulishla.adapters.model.HorizontalItem
import uz.ka5.pulishla.databinding.HorizontalItemBinding

class HorizontalAdapter() : RecyclerView.Adapter<HorizontalAdapter.PostViewHolder>() {

    inner class PostViewHolder(private val binding: HorizontalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindingViewHolder(doc: HorizontalItem) {
            binding.apply {
                name.text = doc.name
                name.setOnClickListener {
                    Toast.makeText(binding.root.context, doc.name, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    var model: MutableList<HorizontalItem> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.horizontal_item, parent, false)
        return PostViewHolder(HorizontalItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindingViewHolder(model[position])
    }

    override fun getItemCount() = model.size
}
