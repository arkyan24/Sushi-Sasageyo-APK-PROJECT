package com.proyek_pmob.dineinresto

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.proyek_pmob.dineinresto.databinding.ActivityMenuDetailBinding

class MenuDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuDetailBinding
    private val menuSushiList = mutableListOf<MenuSushi>()
    private lateinit var menuSushiAdapter: MenuSushiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoryName = intent.getStringExtra("CATEGORY_NAME") ?: "Menu"
        binding.txtCategoryTitle.text = categoryName

        setupMenuList(categoryName)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setupMenuList(category: String) {
        // Load menu based on category
        when (category) {
            "SWEET & SPICY" -> {
                menuSushiList.addAll(
                    listOf(
                        MenuSushi("Salmon Sushi", "Rp 25.000", R.drawable.sushi_salmon),
                        MenuSushi("Spicy Salmon Roll", "Rp 28.000", R.drawable.sushi_salmon),
                        MenuSushi("Sweet Salmon Nigiri", "Rp 30.000", R.drawable.sushi_salmon)
                    )
                )
            }
            "VEGETARIAN MENU" -> {
                menuSushiList.addAll(
                    listOf(
                        MenuSushi("Avocado Roll", "Rp 22.000", R.drawable.sushi_tuna),
                        MenuSushi("Cucumber Maki", "Rp 18.000", R.drawable.sushi_tuna),
                        MenuSushi("Veggie Temaki", "Rp 23.000", R.drawable.sushi_tuna)
                    )
                )
            }
            "MENTAI GALORE" -> {
                menuSushiList.addAll(
                    listOf(
                        MenuSushi("Ebi Mentai", "Rp 32.000", R.drawable.sushi_ebi),
                        MenuSushi("Salmon Mentai", "Rp 35.000", R.drawable.sushi_ebi),
                        MenuSushi("Aburi Mentai", "Rp 38.000", R.drawable.sushi_ebi)
                    )
                )
            }
            "CAKE SERIES" -> {
                menuSushiList.addAll(
                    listOf(
                        MenuSushi("Sushi Cake Original", "Rp 45.000", R.drawable.sushi_tamago),
                        MenuSushi("Sushi Cake Deluxe", "Rp 55.000", R.drawable.sushi_tamago),
                        MenuSushi("Sushi Cake Premium", "Rp 65.000", R.drawable.sushi_tamago)
                    )
                )
            }
        }

        menuSushiAdapter = MenuSushiAdapter(menuSushiList) { menu ->
            // Handle item click - add to cart
            Toast.makeText(this, "${menu.name} added to order!", Toast.LENGTH_SHORT).show()
        }
        binding.rvSushiMenu.layoutManager = LinearLayoutManager(this)
        binding.rvSushiMenu.adapter = menuSushiAdapter
    }
}