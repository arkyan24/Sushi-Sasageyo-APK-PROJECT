package com.proyek_pmob.dineinresto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proyek_pmob.dineinresto.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtName.text = "Gweeny Addams"
        binding.txtRole.text = "Restaurant Manager"

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
