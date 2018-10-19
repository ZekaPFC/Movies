package com.quantox.movies.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.quantox.movies.Core.Core;
import com.quantox.movies.Core.IDataCallback;
import com.quantox.movies.model.ApiResponse;
import com.quantox.movies.model.Movie;

import java.util.List;


public class TopRatedFragment extends BaseFragment {

    private int page = 1;
    private IDataCallback<ApiResponse<List<Movie>>> topRatedMovieCallback;

    public TopRatedFragment (){}
    public  static TopRatedFragment newInstance(){
        return new TopRatedFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        topRatedMovieCallback = new IDataCallback<ApiResponse<List<Movie>>>() {
            @Override
            public void onData(ApiResponse<List<Movie>> data) {
                if (data.getData() != null){
                    displayMovies(data.getData());
                }

            }

            @Override
            public void onFailure(String error) {
                Toast.makeText(context,error,Toast.LENGTH_SHORT).show();
            }
        };

        Core.getInstance().getTopRatedMovies(1,topRatedMovieCallback);

    }

}

