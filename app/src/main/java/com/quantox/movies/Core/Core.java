package com.quantox.movies.Core;

import android.content.Context;

import com.quantox.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class Core implements ICore {

    private IContextProvider contextProvider;
    private List<Movie> topRatedMovies = new ArrayList<>();
    private List<Movie> upcomingMovies = new ArrayList<>();
    private IBackendService backendService = IBackendService.BackedServiceBuilder.build();
    private static Core INSTANCE;

    private Core(IContextProvider contextProvider){
        this.contextProvider = contextProvider;
    }

    @Override
    public void getTopRatedMovies(IDataCallback<List<Movie>> dataCallback) {
        if (topRatedMovies.isEmpty()){
            //TODO get data from network
        } else {
            dataCallback.onData(topRatedMovies);
        }
    }

    @Override
    public void getUpcomingMovies(IDataCallback<List<Movie>> dataCallback) {
        if (upcomingMovies.isEmpty()){
           //TODO get data from network
        } else {
            dataCallback.onData(upcomingMovies);
        }

    }

    @Override
    public void clearData() {
        topRatedMovies.clear();
        upcomingMovies.clear();

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
