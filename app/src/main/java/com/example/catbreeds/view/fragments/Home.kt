package com.example.catbreeds.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catbreeds.adapters.BreedsRecyclerAdapter
import com.example.catbreeds.databinding.FragmentHomeBinding
import com.example.catbreeds.model.Breed
import com.example.catbreeds.retrofit.RetrofitService
import com.example.catbreeds.viewmodel.HomeViewModel

class Home : Fragment() {
    private val retrofitService = RetrofitService.create()
    lateinit var viewModel : HomeViewModel
    private  var  _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var localDataSet : List<Breed>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        setupObservers()
        setupOnClickListeners()
        initializeRecyclerView()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeRecyclerView() {
        // uygulama açılışında search için text vermeden dönen kedi cinsleri gösterilecek.
        viewModel.handleBreeds(null)
    }

    private fun setupObservers() {
        viewModel.breedlist.observe(viewLifecycleOwner, Observer {
            binding.catBreedsRecyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = BreedsRecyclerAdapter(it,viewModel,localDataSet)
            }
        })
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
            localDataSet = it
        })
    }

    private fun handleItemLike(list : List<Breed>){

    }

    private fun setupOnClickListeners() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                    // girilen kedi türü aranıyor
                    viewModel.handleBreeds(p0)
                return false
            }
        })

        binding.btnFavouritesFragment.setOnClickListener {
            val action = HomeDirections.actionHome3ToFavourites()
            Navigation.findNavController(it).navigate(action)
        }



    }

}