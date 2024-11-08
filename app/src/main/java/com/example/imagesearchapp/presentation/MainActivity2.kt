package com.example.imagesearchapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        Glide.with(this)
            .load(intent.getStringExtra("flag_url"))
            .placeholder(R.drawable.ic_launcher_foreground) // Placeholder while loading
            .error(R.drawable.ic_error) // Error image if load fails
            .into(binding.ivFlag);
        binding.tvCountryName.text = intent.getStringExtra("country_name")
    }
}