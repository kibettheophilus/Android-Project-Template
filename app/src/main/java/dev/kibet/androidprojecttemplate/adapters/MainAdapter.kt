package dev.kibet.androidprojecttemplate.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.kibet.androidprojecttemplate.databinding.DummyItemBinding
import dev.kibet.domain.models.DummyData

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: DummyItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<DummyData>() {
        override fun areItemsTheSame(oldItem: DummyData, newItem: DummyData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DummyData, newItem: DummyData): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DummyItemBinding.inflate(layoutInflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = differ.currentList[position]
        val context = holder.itemView.context

        holder.binding.apply {
            dummyName.text = data.name
            Glide.with(context).load(data.image).into(dummyImageView)
        }

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(data)
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((DummyData) -> Unit)? = null

    fun setOnItemClickListener(listener: (DummyData) -> Unit) {
        this.onItemClickListener = listener
    }

}