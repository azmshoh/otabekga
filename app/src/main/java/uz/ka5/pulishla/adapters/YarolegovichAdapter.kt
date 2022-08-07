package uz.ka5.pulishla.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import uz.ka5.pulishla.R
import uz.ka5.pulishla.adapters.model.YarolegovichItem
import uz.ka5.pulishla.databinding.ItemOptionBinding

class YarolegovichAdapter(private val context: Context, private val onClicked: () -> Unit) :
    RecyclerView.Adapter<YarolegovichAdapter.YarolegovichViewHolder>() {

    inner class YarolegovichViewHolder(private val binding: ItemOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {
         fun populateModel(item:YarolegovichItem) {
            binding.apply {
                 imageButton.setImageDrawable(item.drawable)
                 textButton.text = item.string
                root.setOnClickListener {
                    onClicked.invoke()
                    Toast.makeText(context, item.string, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    var model: MutableList<YarolegovichItem> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YarolegovichViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_option, parent, false)
        return YarolegovichViewHolder(ItemOptionBinding.bind(view))
    }

    override fun onBindViewHolder(holder: YarolegovichViewHolder, position: Int) {
        holder.populateModel(model[position])
    }

    override fun getItemCount() = model.size
}