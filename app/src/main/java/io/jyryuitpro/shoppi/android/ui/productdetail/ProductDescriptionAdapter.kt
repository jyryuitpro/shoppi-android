package io.jyryuitpro.shoppi.android.ui.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.jyryuitpro.shoppi.android.databinding.ItemProductDescriptionBinding
import io.jyryuitpro.shoppi.android.model.Description

class ProductDescriptionAdapter : ListAdapter<Description, ProductDescriptionAdapter.DescriptionViewHolder>(ProductDescriptionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionViewHolder {
        val binding = ItemProductDescriptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DescriptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DescriptionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DescriptionViewHolder(private val binding: ItemProductDescriptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(description: Description) {
            binding.imageUrl = description.imageUrl
            binding.executePendingBindings()
        }
    }
}

class ProductDescriptionDiffCallback : DiffUtil.ItemCallback<Description>() {
    override fun areItemsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem == newItem
    }
}