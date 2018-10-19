package com.quantox.movies.Core;


public interface IDataCallback<T> {

    void onData(T data);

    void onFailure(String error);

}
