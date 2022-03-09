package com.glen.daggerbasic.presentation

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter("submitList")
fun <T, VH : RecyclerView.ViewHolder> RecyclerView.submitList(items: List<T>?) {
    (adapter as? ListAdapter<T, VH>)?.submitList(items)
}