package com.proyek_pmob.dineinresto

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.proyek_pmob.dineinresto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val categoryList = mutableListOf<Category>()
    private lateinit var categoryAdapter: CategoryAdapter

    private val selectedOrderList = mutableListOf<String>()
    private lateinit var selectedOrderAdapter: SelectedOrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCategories()
        setupSelectedOrder()
        setupOrderBar()
    }

    private fun setupCategories() {
        categoryList.addAll(
            listOf(
                Category("SWEET & SPICY", R.drawable.sushi_salmon),
                Category("VEGETARIAN MENU", R.drawable.sushi_tuna),
                Category("MENTAI GALORE", R.drawable.sushi_ebi),
                Category("CAKE SERIES", R.drawable.sushi_tamago)
            )
        )

        categoryAdapter = CategoryAdapter(categoryList)
        binding.rvCategories.layoutManager = GridLayoutManager(this, 2)
        binding.rvCategories.adapter = categoryAdapter
    }

    private fun setupSelectedOrder() {
        selectedOrderList.addAll(
            listOf(
                "Salmon Sushi x2",
                "Tuna Sushi x1",
                "Ebi Sushi x3"
            )
        )

        selectedOrderAdapter = SelectedOrderAdapter(selectedOrderList)
        binding.rvSelectedOrder.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvSelectedOrder.adapter = selectedOrderAdapter
    }

    private fun setupOrderBar() {
        // Show order bar if there are selected orders
        if (selectedOrderList.isNotEmpty()) {
            binding.layoutOrderBar.visibility = View.VISIBLE
            updateOrderBar()
        }

        binding.layoutOrderBar.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateOrderBar() {
        binding.txtItemCount.text = "${selectedOrderList.size} item${if (selectedOrderList.size > 1) "s" else ""}"
        binding.txtItemNames.text = selectedOrderList.joinToString(", ")
        // Calculate total price (dummy calculation)
        binding.txtTotalPrice.text = "Rp ${selectedOrderList.size * 25000}"
    }
}