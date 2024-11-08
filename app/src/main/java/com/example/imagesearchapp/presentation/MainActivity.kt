package com.example.imagesearchapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.ActivityMainBinding
import com.example.imagesearchapp.presentation.adapters.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getCountries()
        viewModel.countries.observe(this) { response ->
            response?.let {
                binding.rvCountries.layoutManager = LinearLayoutManager(this)
                adapter = MainAdapter(this, response)
                binding.rvCountries.adapter = adapter
            }?: run {
                Log.d("MainActivity", "onCreate: response is null")
            }

        }
    }
}