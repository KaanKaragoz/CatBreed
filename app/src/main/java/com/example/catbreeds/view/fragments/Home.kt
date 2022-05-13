package com.example.catbreeds.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catbreeds.R
import com.example.catbreeds.adapters.BreedsRecyclerAdapter
import com.example.catbreeds.model.Breed
import com.example.catbreeds.retrofit.MainRepository
import com.example.catbreeds.retrofit.RetrofitService
import com.example.catbreeds.viewmodel.HomeViewModel
import com.example.catbreeds.viewmodel.ViewModelFactory

class Home : Fragment() {
    private val retrofitService = RetrofitService.create()
    lateinit var viewModel : HomeViewModel
    private val blankData = ArrayList<Breed>() //TODO silinecek, deneme için var
   // private var layoutManager: RecyclerView.LayoutManager? = null //TODO silinecek, deneme için var
   //  private var adapter: RecyclerView.Adapter<BreedsRecyclerAdapter.ViewHolder>? = null //TODO silinecek, deneme için var


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(HomeViewModel::class.java)

        viewModel.breedlist.observe(viewLifecycleOwner, Observer {
            //view.findViewById<TextView>(R.id.txtDeneme).text = it.toString()  //TODO silinecek, deneme için var
            view.findViewById<RecyclerView>(R.id.catBreedsRecyclerView).apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = BreedsRecyclerAdapter(it)
            }
        })
        viewModel.getAllBreeds()


    }

}