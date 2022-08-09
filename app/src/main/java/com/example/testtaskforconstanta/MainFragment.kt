package com.example.testtaskforconstanta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskforconstanta.adapter.MovieAdapter
import com.example.testtaskforconstanta.model.Movie
import com.example.testtaskforconstanta.model.MovieResponse
import com.example.testtaskforconstanta.retrofit.MovieApiInterface
import com.example.testtaskforconstanta.retrofit.MovieApiService
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_movies_list.layoutManager = LinearLayoutManager(requireActivity())
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            var adapter = MovieAdapter(movies.sortedWith(compareBy({it.releaseYear})))
            rv_movies_list.adapter = adapter
            adapter.setOnItemClickListener(object : MovieAdapter.onItemClickListener{
                override fun onItemClick(position: Int) {
                    Toast.makeText(requireActivity(), "Фильм: ${movies[position].title} был нажат", Toast.LENGTH_SHORT).show()
                }

            })

        }
    }
    companion object {

        @JvmStatic
        fun newInstance()=MainFragment

    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }
}