package com.example.imagesearchapp.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.imagesearchapp.api.ApiClient
import com.example.imagesearchapp.data.model.Contries
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 08 November, 2024
 */

@Singleton
class MainRepository @Inject constructor(private val apiClient: ApiClient,) {

    fun getCountries(_countries: MutableLiveData<List<Contries>?>)  {
        val result = apiClient.getCountries()
        result.enqueue(
            object : retrofit2.Callback<List<Contries>?> {
                override fun onResponse(
                    call: Call<List<Contries>?>,
                    response: Response<List<Contries>?>
                ) {
                    _countries.value = response.body()
                }

                override fun onFailure(call: Call<List<Contries>?>, t: Throwable) {
                    Log.d("MainRepository", "onFailure: ${t.message}")
                }
            }

        )
    }

}