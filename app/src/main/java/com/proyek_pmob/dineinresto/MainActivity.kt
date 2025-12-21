package com.proyek_pmob.dineinresto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.proyek_pmob.dineinresto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Order terpilih (atas)
    private val selectedOrderList = mutableListOf<String>()
    private lateinit var selectedOrderAdapter: SelectedOrderAdapter

    // Menu sushi (bawah)
    private val menuSushiList = mutableListOf<MenuSushi>()
    private lateinit var menuSushiAdapter: MenuSushiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSelectedOrder()
        setupMenuSushi()
    }

    /* ================= ORDER TERPILIH (HORIZONTAL) ================= */

    private fun setupSelectedOrder() {
        // Dummy order terpilih
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

    /* ================= MENU SUSHI (VERTICAL) ================= */

    private fun setupMenuSushi() {
        menuSushiList.addAll(
            listOf(
                MenuSushi("Salmon Sushi", "Rp 25.000", R.drawable.sushi_salmon),
                MenuSushi("Tuna Sushi", "Rp 23.000", R.drawable.sushi_tuna),
                MenuSushi("Ebi Sushi", "Rp 22.000", R.drawable.sushi_ebi),
                MenuSushi("Tamago Sushi", "Rp 20.000", R.drawable.sushi_tamago)
            )
        )

        menuSushiAdapter = MenuSushiAdapter(menuSushiList)

        binding.rvSushiMenu.layoutManager =
            LinearLayoutManager(this)

        binding.rvSushiMenu.adapter = menuSushiAdapter
    }
}
