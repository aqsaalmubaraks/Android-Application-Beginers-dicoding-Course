    package com.example.makananku

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListFoodAdapter(val listFood: ArrayList<makanan>) :
    RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: makanan)
    }

    fun  setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i : Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_makanan, viewGroup, false)
        return ListViewHolder(view)
    }


    override fun onBindViewHolder(holder: ListFoodAdapter.ListViewHolder, position: Int) {

        val Makanan = listFood[position]

        Glide.with(holder.itemView.context)
            .load(Makanan.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = Makanan.name
        holder.tvDetail.text = Makanan.detail

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu Memilih" + listFood[position].name, Toast.LENGTH_SHORT).show()
                val moveIntent = Intent(holder.itemView.context, DetailActivity::class.java)
                moveIntent.putExtra("nama", Makanan.name)
            moveIntent.putExtra("deskripsi", Makanan.detail)
            moveIntent.putExtra("gambar", Makanan.photo)
            holder.itemView.context.startActivity(moveIntent)
        }
    }

    override fun getItemCount(): Int {
        return listFood.size

    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }

}


