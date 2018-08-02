package com.test.molina.rappiapp.data.local.db;

import com.test.molina.rappiapp.data.model.db.Genre;
import com.test.molina.rappiapp.data.model.db.PopularMovie;
import com.test.molina.rappiapp.data.model.db.TopRatedMovie;
import com.test.molina.rappiapp.data.model.db.UpcomingMovie;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Amolina on 02/02/17.
 */

public interface DbHelper {

    Observable<List<Genre>>  getAllGenres();

    Observable<Boolean> isGenreEmpty();

    Observable<Boolean> saveGenre(Genre genre);

    Observable<Boolean> saveGenreList(List<Genre> genreList);

    Observable<Boolean> savePopularMoviesList(List<PopularMovie> moviesList);

    Observable<Boolean> saveTopRatedMoviesList(List<TopRatedMovie> moviesList);

    Observable<Boolean> saveUpcomingMoviesList(List<UpcomingMovie> moviesList);

    Observable<List<PopularMovie>> getAllLocalPopular();

    Observable<List<TopRatedMovie>> getAllLocalTopRated();

    Observable<List<UpcomingMovie>> getAllLocalUpcoming();


}
