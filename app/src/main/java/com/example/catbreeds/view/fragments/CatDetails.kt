package com.example.catbreeds.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.getInstance

import androidx.navigation.fragment.navArgs

import com.example.catbreeds.R
import com.example.catbreeds.databinding.FragmentCatDetailsBinding
import com.example.catbreeds.databinding.FragmentHomeBinding
import com.example.catbreeds.retrofit.MainRepository
import com.example.catbreeds.retrofit.RetrofitService
import com.example.catbreeds.viewmodel.CatDetailsViewModel
import com.example.catbreeds.viewmodel.HomeViewModel

import java.util.Calendar.getInstance

class CatDetails : Fragment() {
    lateinit var viewModel : CatDetailsViewModel
    private  var  _binding : FragmentCatDetailsBinding? = null
    private val binding get() = _binding!!
    private val args : CatDetailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCatDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CatDetailsViewModel::class.java)
        binding.lifecycleOwner = this
        catDetailsToUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun catDetailsToUI(){
        binding.txtCatName.text = args.name.name
        binding.txtDescription.text = args.name.description
        binding.txtDogFriendly.text = args.name.dogFriendly.toString()
        binding.txtLifeSpan.text = args.name.lifeSpan
        binding.txtOrigin.text = args.name.origin
        binding.txtWikiUrl.text = args.name.wikipediaUrl

    }


}