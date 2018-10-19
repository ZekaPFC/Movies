package com.quantox.movies.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.quantox.movies.Core.BackendServiceRetrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class ApiErrorResponse {

    @SerializedName("status_message")
    private String statusMessage;

    @SerializedName("status_code")
    private int statusCode;

    private ApiErrorResponse(){}

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static String parseErrorResponse(retrofit2.Response<?> response){
        Converter<ResponseBody, ApiErrorResponse> converter =
               BackendServiceRetrofit.getInstance()
                        .responseBodyConverter(ApiErrorResponse.class, new Annotation[0]);

        ApiErrorResponse error;

        try {
           return converter.convert(response.errorBody()).getStatusMessage();

        } catch (IOException e) {
            return "";
        }
    }

}
