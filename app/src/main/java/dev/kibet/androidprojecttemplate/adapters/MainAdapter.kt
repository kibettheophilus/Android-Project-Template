package dev.kibet.androidprojecttemplate.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.kibet.androidprojecttemplate.activities.DummyData

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    class MainViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView)
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
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((DummyData) -> Unit)? = null

    fun setOnItemClickListener(listener: (DummyData) -> Unit) {
        this.onItemClickListener = listener
    }

}