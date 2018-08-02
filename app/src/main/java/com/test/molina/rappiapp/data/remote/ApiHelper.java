package com.test.molina.rappiapp.data.remote;

import com.test.molina.rappiapp.data.model.api.GenreResponse;
import com.test.molina.rappiapp.data.model.api.PopularMovieResponse;
import com.test.molina.rappiapp.data.model.api.TopRatedMovieResponse;
import com.test.molina.rappiapp.data.model.api.UpcomingMovieResponse;

import io.reactivex.Observable;

/**
 * Created by Amolina on 02/02/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<GenreResponse> getGenresApiCall();

    Observable<PopularMovieResponse> getPopularMoviesApiCall();

    Observable<TopRatedMovieResponse> getTopRatedMoviesApiCall();

    Observable<UpcomingMovieResponse> getUpcomingMoviesApiCall();

/*
    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<LogoutResponse> doLogoutApiCall();



    Observable<OpenSourceResponse> getOpenSourceApiCall();

    */
}
