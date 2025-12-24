package com.proyek_pmob.dineinresto

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyek_pmob.dineinresto.databinding.ItemCategoryBinding

class CategoryAdapter(private val categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    // ViewHolder berfungsi untuk memegang komponen layout (item_category.xml)
    class CategoryViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    // 1. Create: Membuat tampilan awal
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    // 2. Bind: Memasukkan data ke tampilan dan mengatur fungsi klik
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]

        // Set Nama Kategori
        holder.binding.tvCategoryName.text = category.name

        // Set Gambar Kategori
        holder.binding.imgCategory.setImageResource(category.imageRes)

        // KLIK ITEM: Pindah ke MenuDetailActivity
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context

            // Intent ke halaman detail
            val intent = Intent(context, MenuDetailActivity::class.java)

            // Kirim data nama kategori agar halaman detail tahu judulnya
            intent.putExtra("CATEGORY_NAME", category.name)

            context.startActivity(intent)
        }
    }

    // 3. Count: Menghitung jumlah data
    override fun getItemCount(): Int {
        return categoryList.size
    }
}