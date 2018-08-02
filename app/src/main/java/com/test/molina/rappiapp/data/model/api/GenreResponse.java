package com.test.molina.rappiapp.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.molina.rappiapp.data.model.db.Genre;

import java.util.List;

/**
 * Created by Amolina on 02/02/17.
 */

public class GenreResponse {

    @Expose
    @SerializedName("genres")
    private List<Genre> genres;


    public List<Genre> getData() {
        return genres;
    }

    public void setData(List<Genre> data) {
        this.genres = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenreResponse)) return false;

        GenreResponse that = (GenreResponse) o;

        return genres.equals(that.genres);

    }

    @Override
    public int hashCode() {
        int  result = 31 *  genres.hashCode();
        return result;
    }

}