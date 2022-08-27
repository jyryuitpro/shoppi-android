package io.jyryuitpro.shoppi.android.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.jyryuitpro.shoppi.android.databinding.ItemCategoryTopSellingSectionBinding
import io.jyryuitpro.shoppi.android.model.TopSelling

class CategoryTopSellingSectionAdapter :
    ListAdapter<TopSelling, CategoryTopSellingSectionAdapter.TopSellingSectionViewHolder>(
        TopSellingDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSellingSectionViewHolder {
        val binding = ItemCategoryTopSellingSectionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TopSellingSectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopSellingSectionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TopSellingSectionViewHolder(private val binding: ItemCategoryTopSellingSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val nestedAdapter = CategoryTopSellingItemAdapter()

        init {
            binding.rvCategorySection.adapter = nestedAdapter
        }

        fun bind(topSelling: TopSelling) {
            binding.title = topSelling.title
            binding.executePendingBindings()
            nestedAdapter.submitList(topSelling.categories)
        }
    }
}

class TopSellingDiffCallback : DiffUtil.ItemCallback<TopSelling>() {
    override fun areItemsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem.title.text == newItem.title.text
    }

    override fun areContentsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem == newItem
    }
}