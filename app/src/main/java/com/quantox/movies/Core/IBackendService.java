package com.quantox.movies.Core;

import com.quantox.movies.model.ApiResponse;
import com.quantox.movies.model.Movie;
import com.quantox.movies.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IBackendService {




    @GET(Constants.GET_TOP_RATED)
    Call<ApiResponse<List<Movie>>> getTopRatedMovies(@Query("page") int page);

    @GET(Constants.GET_UPCOMING)
    Call<ApiResponse<List<Movie>>> getUpcomingMovies(@Query("page") int page);


     class BackedServiceBuilder{
        public static IBackendService build(){
            return BackendServiceRetrofit
                    .getInstance()
                    .create(IBackendService.class);
        }
    }
}
