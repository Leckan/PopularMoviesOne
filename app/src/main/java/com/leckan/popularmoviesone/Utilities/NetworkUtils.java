package com.leckan.popularmoviesone.Utilities;

/**
 * Created by Leckan on 4/16/2017.
 */

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();
    private static final String BASE_MOVIE_IMAGE_URL = "http://image.tmdb.org/t/p/";
    private static final String BASE_MOVIE_URL = "http://image.tmdb.org/3/movie/";
    private static final String POPULAR = "popular";
    private static final String TOP_RATED = "top_rated";
    private static final String format = "json";
    private static final String size = "w185";

    final static String QUERY_PARAM = "q";
    final static String API_KEY_PARAM = "api_key";
}
