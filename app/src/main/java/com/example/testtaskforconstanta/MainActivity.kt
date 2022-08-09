package com.example.testtaskforconstanta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskforconstanta.adapter.MovieAdapter
import com.example.testtaskforconstanta.model.Movie
import com.example.testtaskforconstanta.model.MovieResponse
import com.example.testtaskforconstanta.retrofit.MovieApiService
import com.example.testtaskforconstanta.retrofit.MovieApiInterface
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(MainFragment())

    }

    private fun replaceFragment(mainFragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.place_holder,mainFragment)
        fragmentTransaction.commit()
    }


}