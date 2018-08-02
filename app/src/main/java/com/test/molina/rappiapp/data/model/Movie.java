package com.test.molina.rappiapp.data.model;

import com.test.molina.rappiapp.data.model.db.PopularMovie;
import com.test.molina.rappiapp.data.model.db.TopRatedMovie;
import com.test.molina.rappiapp.data.model.db.UpcomingMovie;

public class Movie {
    public Long id;
    public Integer voteCount;
    public String title;
    public String poster_path;
    public String original_language;
    public String original_title;
    public String overview;
    public Boolean adult;

    public Movie(Long id, Integer voteCount, String title, String poster_path, String original_language,
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

    public PopularMovie toPopularMovie() {
        return new PopularMovie(id, voteCount, title, poster_path, original_language, original_title, overview, adult);
    }

    public TopRatedMovie toTopRatedMovie() {
        return new TopRatedMovie(id, voteCount, title, poster_path, original_language, original_title, overview, adult);
    }

    public UpcomingMovie toUpcomingMovie() {
        return new UpcomingMovie(id, voteCount, title, poster_path, original_language, original_title, overview, adult);
    }
}
