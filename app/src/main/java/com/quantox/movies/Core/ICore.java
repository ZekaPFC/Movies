package com.quantox.movies.Core;


import com.quantox.movies.model.ApiResponse;
import com.quantox.movies.model.Movie;

import java.util.List;

/**
 * Basic core definition
 */
public interface ICore {


    void getTopRatedMovies (int page,IDataCallback<ApiResponse<List<Movie>>> dataCallback);

    void getUpcomingMovies(int page,IDataCallback<ApiResponse<List<Movie>>> dataCallback);





}
