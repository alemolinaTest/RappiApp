package com.test.molina.rappiapp.data.remote;

import com.test.molina.rappiapp.BuildConfig;

/**
 * Created by Amolina on 02/02/17.
 */

public class ApiEndPoint {

    public static final String ENDPOINT_GENRE = BuildConfig.BASE_URL + "genre/movie/list";

    public static final String ENDPOINT_MOVIES_TOP_RATED = BuildConfig.BASE_URL + "movie/top_rated";

    public static final String ENDPOINT_MOVIES_POPULAR = BuildConfig.BASE_URL + "movie/popular";

    public static final String ENDPOINT_MOVIES_UPCOMING = BuildConfig.BASE_URL + "movie/upcoming";

    public static final String ENDPOINT_MOVIES_IMAGES = "http://image.tmdb.org/t/p/w185";


    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
