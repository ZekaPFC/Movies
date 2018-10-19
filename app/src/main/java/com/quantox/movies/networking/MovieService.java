package com.quantox.movies.networking;

import com.quantox.movies.model.ApiResponse;
import com.quantox.movies.model.Movie;
import com.quantox.movies.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET(Constants.GET_TOP_RATED)
    Call<ApiResponse<Movie>> getTopRatedMovies(@Query("page") int page);
}
