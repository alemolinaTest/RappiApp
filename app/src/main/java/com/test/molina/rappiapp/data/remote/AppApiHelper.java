

package com.test.molina.rappiapp.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.test.molina.rappiapp.data.model.api.GenreResponse;
import com.test.molina.rappiapp.data.model.api.PopularMovieResponse;
import com.test.molina.rappiapp.data.model.api.TopRatedMovieResponse;
import com.test.molina.rappiapp.data.model.api.UpcomingMovieResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Amolina on 02/02/17.
 */
//make calls using androidnetworking library, getting Observable<Response>
    //with retrofit is like
// @POST("api/user/auth/google_signin")
//    fun googleSignIn(@Body registerTokenDTO: RegisterTokenDTO): Single<AuthToken>
@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Observable<GenreResponse> getGenresApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GENRE)
                .addQueryParameter(mApiHeader.getPublicApiHeader())
                .build()
                .getObjectObservable(GenreResponse.class);
    }

    @Override
    public Observable<PopularMovieResponse> getPopularMoviesApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIES_POPULAR)
                .addQueryParameter(mApiHeader.getPublicApiHeader())
                .build()
                .getObjectObservable(PopularMovieResponse.class);


    }

    @Override
    public Observable<TopRatedMovieResponse> getTopRatedMoviesApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIES_TOP_RATED)
                .addQueryParameter(mApiHeader.getPublicApiHeader())
                .build()
                .getObjectObservable(TopRatedMovieResponse.class);
    }

    @Override
    public Observable<UpcomingMovieResponse> getUpcomingMoviesApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIES_UPCOMING)
                .addQueryParameter(mApiHeader.getPublicApiHeader())
                .build()
                .getObjectObservable(UpcomingMovieResponse.class);
    }


}
