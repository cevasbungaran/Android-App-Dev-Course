package com.example.tugasifapps2.WebService;

import com.example.tugasifapps2.Model.Login;
import com.example.tugasifapps2.Model.LoginRequest;
import com.example.tugasifapps2.Model.Pengumuman;
import com.example.tugasifapps2.Model.RequestPengumuman;
import com.example.tugasifapps2.Model.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface API {

    @GET("users")
    Call<List<User>> getAllUsers();

    @POST("authenticate")
    Call<Login> doLogin(@Body LoginRequest loginRequest);

    @GET("announcements")
    Call<Pengumuman> getAnnouncement(@QueryMap Map<String, String> parameters);

    @GET("announcements/{id}")
    Call<Pengumuman.Data> getAnnouncementDetail(@Path("id") String id);

    @GET("tags")
    Call<List<Pengumuman.Data.Tags>> getAllTags();

    @POST("announcements")
    Call<Pengumuman.Data> postPengumuman(@Body RequestPengumuman requestPengumuman);
}
