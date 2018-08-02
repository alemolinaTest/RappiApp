package com.test.molina.rappiapp.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.molina.rappiapp.data.model.db.PopularMovie;

import java.util.List;

/**
 * Created by Amolina on 02/02/17.
 */

public class PopularMovieResponse {

    @Expose
    @SerializedName("results")
    private List<PopularMovie> movies;


    public List<PopularMovie> getData() {
        return movies;
    }



    public void setData(List<PopularMovie> data) {
        this.movies = data;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieResponse)) return false;

        MovieResponse that = (MovieResponse) o;

        return movies.equals(that.movies);

    }

    @Override
    public int hashCode() {
        int  result = 31 *  movies.hashCode();
        return result;
    }
*/
}