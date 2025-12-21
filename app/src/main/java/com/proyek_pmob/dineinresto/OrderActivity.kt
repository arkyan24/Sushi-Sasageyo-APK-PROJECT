package com.proyek_pmob.dineinresto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.proyek_pmob.dineinresto.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding
    private lateinit var db: DatabaseReference
    private val orderList = mutableListOf<Order>()
    private lateinit var adapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseDatabase
            .getInstance("https://projectpmob-94757-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("orders")

        setupRecycler()
        loadOrders()

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setupRecycler() {
        adapter = OrderAdapter(orderList)
        binding.rvOrderVertical.layoutManager =
            LinearLayoutManager(this)
        binding.rvOrderVertical.adapter = adapter
    }

    private fun loadOrders() {
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                orderList.clear()
                for (data in snapshot.children) {
                    val order = data.getValue(Order::class.java)
                    order?.let { orderList.add(it) }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
