

package com.test.molina.rappiapp.data.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.molina.rappiapp.data.model.Movie;

/**
 * Created by Amolina on 02/02/17.
 */
@Entity(tableName = "top_rated_movie")
public class TopRatedMovie {

    @Expose
    @PrimaryKey
    public Long id;

    @Expose
    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    public Integer voteCount;

    @Expose
    @SerializedName("title")
    @ColumnInfo(name = "title")
    public String title;

    @Expose
    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    public String poster_path;

    @Expose
    @SerializedName("original_language")
    @ColumnInfo(name = "original_language")
    public String original_language;

    @Expose
    @SerializedName("original_title")
    @ColumnInfo(name = "original_title")
    public String original_title;

    @Expose
    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    public String overview;

    @Expose
    @SerializedName("adult")
    @ColumnInfo(name = "adult")
    public Boolean adult;


    public Movie toMovie() {
        return new Movie(id, voteCount, title, poster_path, original_language, original_title, overview, adult);
    }

    public TopRatedMovie(Long id, Integer voteCount, String title, String poster_path, String original_language,
                         String original_title, String overview, Boolean adult) {
        this.id = id;
        this.voteCount = voteCount;
        this.title = title;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.adult = adult;

    }
}
