package com.leckan.popularmoviesone.Model;

import com.leckan.popularmoviesone.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simpa on 4/19/2017.
 */

public class DummyMovies {
    private static int[] images = {R.mipmap.ff8, R.mipmap.bbaby};
    private static String[] titles = {"Movie Title", "Film Title"};

    public static List<Movie> getMovieList() {
        List<Movie> movies = new ArrayList<>();

        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < images.length && i < titles.length; i++) {
                Movie aMovie = new Movie();
                aMovie.setOriginal_title(titles[i]);
                aMovie.setImageRes(images[i]);
                movies.add(aMovie);
            }
        }
        return movies;
    }
}
