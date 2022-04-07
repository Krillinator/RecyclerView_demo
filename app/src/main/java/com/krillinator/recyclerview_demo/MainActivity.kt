package com.krillinator.recyclerview_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // X()

        val searchView = findViewById<androidx.appcompat.widget.SearchView>(R.id.sv_searchbar)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)

        searchView.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(pO: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(pO: String?): Boolean {
                customAdapter.getFilter().filter(pO)
                return false
            }
        })

        // NEW - Interface (on Item Click)
        customAdapter.setOnItemClickListener(object: CustomAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {

                // CRASH
                if (position >= 0) {
                    itemsList.removeAt(position)
                    customAdapter.notifyItemRemoved(position)
                }
            }
        })

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }


    private fun prepareItems() {
        itemsList.add("Apple")
        itemsList.add("Orange")
        itemsList.add("Strawberry")
        itemsList.add("Destruction")
        itemsList.add("NULL")
        itemsList.add("NULL")
        itemsList.add("NULL")
        itemsList.add("NULL")
        itemsList.add("NULL")


        customAdapter.notifyDataSetChanged()
    }
}