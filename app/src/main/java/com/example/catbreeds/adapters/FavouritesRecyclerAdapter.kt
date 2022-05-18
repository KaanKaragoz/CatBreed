package com.example.catbreeds.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.catbreeds.R
import com.example.catbreeds.model.Breed
import com.example.catbreeds.model.Likes
import com.example.catbreeds.view.fragments.CatDetailsDirections
import com.example.catbreeds.view.fragments.HomeDirections
import com.squareup.picasso.Picasso
import java.lang.Exception

class FavouritesRecyclerAdapter : RecyclerView.Adapter<FavouritesRecyclerAdapter.ViewHolder>() {

    private  var catsList = emptyList<Likes>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.home_listview_items, viewGroup, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: FavouritesRecyclerAdapter.ViewHolder, position: Int) {
        val currentItem = catsList[position]
        holder.itemView.findViewById<TextView>(R.id.catName).text = currentItem.name
    }

    // Replace the contents of a view (invoked by the layout manager)


        /*  if() {
              viewHolder.btnLike.setBackgroundResource(R.color.black)
          }
          else {
              //viewHolder.btnLike.setBackgroundResource(R.color.purple_500)
          } */


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = catsList.size

    fun setData(likedCats: List<Likes>) {
        this.catsList = likedCats
        notifyDataSetChanged()
    }


}