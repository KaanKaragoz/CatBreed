package com.example.catbreeds.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.catbreeds.R
import com.example.catbreeds.model.Breed
import com.example.catbreeds.room.LikedCatsDatabase
import com.example.catbreeds.room.LikedCatsRepository
import com.example.catbreeds.view.fragments.CatDetailsDirections
import com.example.catbreeds.view.fragments.HomeDirections
import com.example.catbreeds.viewmodel.FavouritesViewModel
import com.example.catbreeds.viewmodel.HomeViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class BreedsRecyclerAdapter(private val dataSet: List<Breed>, private val homeViewModel: HomeViewModel, private val localDataSet: List<Breed>) :
    RecyclerView.Adapter<BreedsRecyclerAdapter.ViewHolder>() {
    private  var catsList = emptyList<Breed>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtCatName: TextView
        val imgCat: ImageView
        val btnLike: ImageButton
        init {
            // Define click listener for the ViewHolder's View.
            txtCatName = view.findViewById(R.id.catName)
            imgCat = view.findViewById(R.id.catImg)
            btnLike = view.findViewById(R.id.btnLike)
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
        viewHolder.txtCatName.text = dataSet[position].name
        try {
            val imageUrl = dataSet[position].image.url
            Picasso.get().load(imageUrl).into(viewHolder.imgCat)
        }
        catch (e: Exception) {
            //default kedi cinsleri çekilirken image döndürüyor fakat search parametresi ile arandığında
            // resim dönmüyor. zaman kalırsa resmi farklı şekilde çekmeyi deneyeceğim.
        }
        viewHolder.itemView.setOnClickListener {
            val action = HomeDirections.actionHome3ToCatDetails(dataSet[position])
            Navigation.findNavController(it).navigate(action)
        }

        viewHolder.btnLike.setOnClickListener {

            homeViewModel.addCat(dataSet[position])


        }

            var i = 0
            while (i < localDataSet.size) {
                if(localDataSet[i].name.equals(dataSet[position].name))
                {
                    viewHolder.btnLike.setBackgroundResource(R.color.purple_500)

                    break;
                }

                i++
            }



    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun setData(likedCats: List<Breed>) {
        this.catsList = likedCats
        notifyDataSetChanged()
    }


}