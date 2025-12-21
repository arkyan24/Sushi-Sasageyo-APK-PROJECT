package com.proyek_pmob.dineinresto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyek_pmob.dineinresto.databinding.ItemOrderSelectedBinding

class SelectedOrderAdapter(
    private val list: List<String>
) : RecyclerView.Adapter<SelectedOrderAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemOrderSelectedBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOrderSelectedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtMenu.text = list[position]
    }

    override fun getItemCount(): Int = list.size
}
