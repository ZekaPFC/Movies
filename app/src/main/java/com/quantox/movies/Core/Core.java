package com.quantox.movies.Core;

import android.content.Context;
import android.support.annotation.NonNull;

import com.quantox.movies.R;
import com.quantox.movies.model.ApiErrorResponse;
import com.quantox.movies.model.ApiResponse;
import com.quantox.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Core implements ICore {

    private IContextProvider contextProvider;

    private IBackendService backendService = IBackendService.BackedServiceBuilder.build();
    private static Core INSTANCE;

    private Core(IContextProvider contextProvider){
        this.contextProvider = contextProvider;
    }

    @Override
    public void getTopRatedMovies(int page,IDataCallback<ApiResponse<List<Movie>>> dataCallback) {
        backendService.getTopRatedMovies(page).enqueue(new Callback<ApiResponse<List<Movie>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Movie>>> call, Response<ApiResponse<List<Movie>>> response) {
                if (response.body() != null){
                    dataCallback.onData(response.body());
                } else if (response.errorBody() != null){
                    dataCallback.onFailure(ApiErrorResponse.parseErrorResponse(response));
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Movie>>> call, Throwable t) {
                dataCallback.onFailure(getContext().getString(R.string.generic_network_error));
            }
        });
    }

    @Override
    public void getUpcomingMovies(int page,IDataCallback<ApiResponse<List<Movie>>> dataCallback) {
        backendService.getUpcomingMovies(page).enqueue(new Callback<ApiResponse<List<Movie>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Movie>>> call, Response<ApiResponse<List<Movie>>> response) {
                if (response.body() != null){
                    dataCallback.onData(response.body());
                } else if (response.errorBody() != null){
                    dataCallback.onFailure(ApiErrorResponse.parseErrorResponse(response));
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Movie>>> call, Throwable t) {
                dataCallback.onFailure(getContext().getString(R.string.generic_network_error));
            }
        });

    }

    @Override
    public Core getInstance() {
        return INSTANCE;
    }

    public static  void init(IContextProvider contextProvider) {
        if (INSTANCE == null){
            INSTANCE = new Core(contextProvider);
        }
    }

    private Context getContext(){
        return contextProvider.getContext();
    }
}
