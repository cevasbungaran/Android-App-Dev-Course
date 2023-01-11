package com.example.tugasifapps2.WebService;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//api call
public class RetrofitInstance {

    private LocalAuth auth;

    //buat intercept request, untuk nambahin bearer token
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    String token = auth.getAuthToken();
                    Request.Builder requestBuilder = original.newBuilder()
                            .addHeader("Authorization", "Bearer " + token);
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            })
            .build();

    API retrofitInstance = new Retrofit.Builder()
            .baseUrl("https://ifportal.labftis.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(API.class);


    public API getRetrofitInstance(Context context) {
        auth = new LocalAuth(context);
        return retrofitInstance;
    }
}
