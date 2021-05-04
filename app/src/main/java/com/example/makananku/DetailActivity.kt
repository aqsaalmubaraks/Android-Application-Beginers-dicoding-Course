package com.example.makananku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var itemImgPhoto : ImageView
    private lateinit var tvDetail : TextView
    private lateinit var hargaMakanan : TextView
    private lateinit var tvName : TextView
    lateinit var btnShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_makanan)

        btnShare = findViewById(R.id.btnShare)

        btnShare.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "type/palin"
            val shareSub = "Aku Suka Makanan Anak kos"
            myIntent.putExtra(Intent.EXTRA_TEXT , shareSub)
            startActivity(Intent.createChooser(myIntent , "Share My App"))
        }

        val actionBar = supportActionBar

        actionBar!!.title = "Makanan Yang Dipilih"



        itemImgPhoto = findViewById(R.id.img_item_photo)

        var photo : Int = intent.getIntExtra("gambar", 0)
        itemImgPhoto.setImageResource(photo)

        tvDetail = findViewById(R.id.tv_item_detail)
        var deskripsi : String = intent.getStringExtra("deskripsi").toString()
        tvDetail.setText(deskripsi)

        tvName = findViewById(R.id.tv_item_name)
        var judul_makanan : String = intent.getStringExtra("nama").toString()
        tvName.setText(judul_makanan)


    }
}