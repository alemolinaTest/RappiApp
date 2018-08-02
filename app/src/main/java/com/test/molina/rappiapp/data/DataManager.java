package com.test.molina.rappiapp.data;


import com.test.molina.rappiapp.data.local.db.DbHelper;
import com.test.molina.rappiapp.data.model.api.GenreResponse;
import com.test.molina.rappiapp.data.model.api.PopularMovieResponse;
import com.test.molina.rappiapp.data.model.api.TopRatedMovieResponse;
import com.test.molina.rappiapp.data.model.api.UpcomingMovieResponse;
import com.test.molina.rappiapp.data.remote.ApiHelper;

import io.reactivex.Observable;

/**
 * Created by Amolina on 02/02/17.
 */

public interface DataManager extends DbHelper, ApiHelper {

    void updateApiHeader(String accessToken);

    Observable<GenreResponse> getGenresApiCall();

    Observable<PopularMovieResponse> getPopularMoviesApiCall();

    Observable<TopRatedMovieResponse> getTopRatedMoviesApiCall();

    Observable<UpcomingMovieResponse> getUpcomingMoviesApiCall();
}
