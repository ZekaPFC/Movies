package com.quantox.movies;

import android.app.Application;
import android.content.Context;

import com.quantox.movies.Core.Core;
import com.quantox.movies.Core.IContextProvider;

public class MoviesApplication extends Application implements IContextProvider {

    @Override
    public void onCreate() {
        super.onCreate();
        Core.init(this);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
