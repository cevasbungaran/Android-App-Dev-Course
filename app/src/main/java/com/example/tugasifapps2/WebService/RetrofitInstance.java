package com.example.tugasifapps2.WebService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);


    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .addHeader("Authorization", "Bearer " +
                                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7InVzZXJfaWQiOiI2ZTY2ODZmMC0yOTZlLTRjNzItOGE0NS1hNmFjMWVkNDhlNDQiLCJyb2xlIjoiYWRtaW4ifSwiaWF0IjoxNjczNDE4Njc0fQ.G29olqWIMqSoeuZ1-h7E7SkRSyFtXM7HHc7qnI82h-Y");
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            })
            .addInterceptor(loggingInterceptor)
            .build();

    API retrofitInstance = new Retrofit.Builder()
            .baseUrl("https://ifportal.labftis.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(API.class);


    public API getRetrofitInstance() {
        return retrofitInstance;
    }
}
