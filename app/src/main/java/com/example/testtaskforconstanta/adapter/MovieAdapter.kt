package com.example.testtaskforconstanta.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskforconstanta.R
import com.example.testtaskforconstanta.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*


class MovieAdapter(


    private val movies: List<Movie>,
    //onItemClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class MovieViewHolder(view : View, listener: onItemClickListener) : RecyclerView.ViewHolder(view){

        fun bindMovie(movie : Movie){

            itemView.movie_title.text = movie.title + "(" + movie.releaseYear + ")"
            var directorNameString: String = movie.directorName.toString()
            var splitList: List<String> = directorNameString.split(" ")
            directorNameString = splitList[2] + " " + splitList[0][0] + ". " + splitList[1][0]+ "."
            //directorNameString = splitList[2]
            itemView.director_name.text = directorNameString
            itemView.actor_names.text = movie.actors.distinct().joinToString(separator = "\n").replace("Actor(actorName=", "").replace(")","")
        }
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false),
            mListener
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int)
    {
        holder.bindMovie(movies.get(position))
    }

}