package com.example.makananku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() { private lateinit var rvFood: RecyclerView
    private var list:ArrayList<makanan> = arrayListOf()

    private fun  showSelectedFood(food: makanan){
        Toast.makeText(this,"Kamu Memilih " + food.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFood = findViewById(R.id.rv_makanan)
        rvFood.setHasFixedSize(true)

        list.addAll(FoodsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback (object : ListFoodAdapter.OnItemClickCallback{
            override fun onItemClicked(data: makanan) {
                showSelectedFood(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.menu_selengkapnya ->{
                showRecyclerCardView()
            }

            R.id.menu_profile -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.action_list ->{
                showRecyclerList()
            }
        }
    }

    private fun showRecyclerCardView(){
        rvFood.layoutManager = LinearLayoutManager(this)
        val cardViewFoodAdapter = CardViewFoodAdapter(list)
        rvFood.adapter = cardViewFoodAdapter
    }
}