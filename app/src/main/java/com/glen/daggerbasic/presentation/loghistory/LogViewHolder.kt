package com.glen.daggerbasic.presentation.loghistory

import androidx.recyclerview.widget.RecyclerView
import com.glen.daggerbasic.databinding.ItemLogBinding
import com.glen.daggerbasic.domain.entity.Log

class LogViewHolder(
    private val binding: ItemLogBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Log) {
        binding.item = item
    }

    fun unbind() {
        binding.item = null
    }
}