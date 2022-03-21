package com.mallama.movies2022.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mallama.movies2022.server.model.Movie
import com.mallama.movies2022.server.model.MoviesList
import com.mallama.movies2022.server.moviesrepository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val moviesRepository = MoviesRepository()

    private val loadMovies : MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    val loadMoviesDone : LiveData<ArrayList<Movie>> = loadMovies

    fun getMovies() {
        GlobalScope.launch(Dispatchers.IO) {

            val moviesList: MoviesList = moviesRepository.getMovies()
            loadMovies.postValue(moviesList.moviesList as ArrayList<Movie>)

            //loadMovies.postValue(moviesRepository.getMovies().moviesList as ArrayList<Movie>)

        }

    }

}