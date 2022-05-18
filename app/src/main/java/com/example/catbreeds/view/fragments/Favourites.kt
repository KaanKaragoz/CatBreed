package com.example.catbreeds.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catbreeds.R
import com.example.catbreeds.adapters.BreedsRecyclerAdapter
import com.example.catbreeds.adapters.FavouritesRecyclerAdapter
import com.example.catbreeds.databinding.FragmentCatDetailsBinding
import com.example.catbreeds.databinding.FragmentFavouritesBinding
import com.example.catbreeds.model.Breed
import com.example.catbreeds.model.Items
import com.example.catbreeds.model.Likes
import com.example.catbreeds.viewmodel.CatDetailsViewModel
import com.example.catbreeds.viewmodel.FavouritesViewModel


class Favourites : Fragment() {
    lateinit var viewModel : FavouritesViewModel
    private  var  _binding : FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavouritesBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(FavouritesViewModel::class.java)

        //recyclerview
        val blankdata = listOf<Breed>()
        val adapter = FavouritesRecyclerAdapter()
        binding.favouritiesRecyclerView.adapter = adapter
        binding.favouritiesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
        binding.btnInsertData.setOnClickListener(){
            insertDataToDatabase()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun insertDataToDatabase(){

        //val likedCat = Likes(0,"a")
        val likedCat = Breed("c kedisi", Items("url asd"),"açıklama","TR","url","sasd",2,false)

        viewModel.addCat(likedCat)
        Toast.makeText(requireContext(),"başarılı",Toast.LENGTH_LONG).show()
    }


}