package com.proyek_pmob.dineinresto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyek_pmob.dineinresto.databinding.ItemMenuSushiBinding

class MenuSushiAdapter(private val list: List<MenuSushi>) :
    RecyclerView.Adapter<MenuSushiAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemMenuSushiBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMenuSushiBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = list[position]
        holder.binding.imgSushi.setImageResource(menu.imageRes)
        holder.binding.txtName.text = menu.name
        holder.binding.txtPrice.text = menu.price
    }

    override fun getItemCount(): Int = list.size
}
