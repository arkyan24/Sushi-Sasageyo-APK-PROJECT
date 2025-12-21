package com.proyek_pmob.dineinresto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyek_pmob.dineinresto.databinding.ItemOrderBinding

class OrderAdapter(private val list: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOrderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val order = list[position]
        holder.binding.txtOrderId.text = order.orderId
        holder.binding.txtMenu.text = order.menu
        holder.binding.txtTable.text = order.table
    }

    override fun getItemCount(): Int = list.size
}
