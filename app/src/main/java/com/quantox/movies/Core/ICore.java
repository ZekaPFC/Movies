package com.quantox.movies.Core;


import com.quantox.movies.model.Movie;

import java.util.List;

/**
 * Basic core definition
 */
public interface ICore {


    void getTopRatedMovies (IDataCallback<List<Movie>> dataCallback);

    void getUpcomingMovies(IDataCallback<List<Movie>> dataCallback);

    void clearData();

    Core getInstance();



}
