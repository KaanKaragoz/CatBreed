package com.example.catbreeds.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catbreeds.R
import com.example.catbreeds.model.Breed
import com.squareup.picasso.Picasso

class BreedsRecyclerAdapter(private val dataSet: List<Breed>) :
    RecyclerView.Adapter<BreedsRecyclerAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtCatName: TextView
        val imgCat: ImageView



        init {
            // Define click listener for the ViewHolder's View.
            txtCatName = view.findViewById(R.id.catName)
            imgCat = view.findViewById(R.id.catImg)


        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.home_listview_items, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
       // val imageUrl = dataSet[position].image[position].url

        viewHolder.txtCatName.text = dataSet[position].name
       // Picasso.get().load(imageUrl).into(viewHolder.imgCat)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}