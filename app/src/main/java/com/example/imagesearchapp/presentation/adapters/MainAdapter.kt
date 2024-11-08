package com.example.imagesearchapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearchapp.data.model.Contries
import com.example.imagesearchapp.databinding.ItemCountryBinding

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 08 November, 2024
 */
class MainAdapter(val context: Context, private val countries: List<Contries>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(val binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.tvCountryName.text = countries[position].name.common

        holder.binding.tvCountryName.setOnClickListener {
            Toast.makeText(context, countries[position].name.common, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = countries.size
}