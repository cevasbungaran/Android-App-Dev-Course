package com.example.tugasifapps2.Presenter;

import android.util.Log;

import com.example.tugasifapps2.Model.Pengumuman;
import com.example.tugasifapps2.Model.RequestPengumuman;
import com.example.tugasifapps2.WebService.API;
import com.example.tugasifapps2.WebService.RetrofitInstance;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterPengumuman {
    public interface PresenterCallback {
        void dataFetched(List<Pengumuman.Data> result);
    }

    public interface PresenterDetailCallback {
        void dataFetched(Pengumuman.Data result);
    }
    public interface PresenterTagsCallback {
        void tagsFetched(List<Pengumuman.Data.Tags> tags);
    }

    public interface PresenterTambahPengumumanCallback {
        void dataFetched(Pengumuman.Data result);
        void failFetched();
    }

    String currentCursor = "";
    String nextCursor = "";
    boolean hasNext = false;

    public void getPengumuman(String titleFilter,
                              String cursor,
                              PresenterCallback callback) {
        API api = new RetrofitInstance().getRetrofitInstance();
        HashMap<String, String> requestParams = new HashMap<>();
        if (!titleFilter.equals("")) {
            requestParams.put("filter[title]", titleFilter);
        }
        if (!cursor.equals("")) {
            requestParams.put("cursor", cursor);
        }
        requestParams.put("limit", "10");
        Call<Pengumuman> call = api.getAnnouncement(requestParams);

        call.enqueue(new Callback<Pengumuman>() {
            @Override
            public void onResponse(Call<Pengumuman> call, Response<Pengumuman> response) {
                if (response.isSuccessful()) {
                    // Do something with the response
                    Pengumuman data = response.body();

                    if (data.getMetadata().getNext() == null) {
                        nextCursor = currentCursor;
                        hasNext = false;
                    } else {
                        hasNext = true;
                        currentCursor = nextCursor;
                        nextCursor = data.getMetadata().getNext();
                    }

                    Log.e("hihi", "berhasil");
                    callback.dataFetched(data.getData());
                } else {
                    Log.e("hihi", "gagal");
                }
            }

            @Override
            public void onFailure(Call<Pengumuman> call, Throwable t) {
                // Handle failure
                Log.e("hihi", "fail");
            }
        });
//
    }

    public void getPengumumanDetail(String announcementId, PresenterDetailCallback callback) {
        API api = new RetrofitInstance().getRetrofitInstance();
        Call<Pengumuman.Data> call = api.getAnnouncementDetail(announcementId);

        call.enqueue(new Callback<Pengumuman.Data>() {
            @Override
            public void onResponse(Call<Pengumuman.Data> call, Response<Pengumuman.Data> response) {
                if (response.isSuccessful()) {
                    // Do something with the response
                    Pengumuman.Data data = response.body();
                    callback.dataFetched(data);
                    Log.e("huhu", "berhasil");
                } else {
                    Log.e("huhu", "gagal");
                }
            }

            @Override
            public void onFailure(Call<Pengumuman.Data> call, Throwable t) {
                // Handle failure
                Log.e("huhu", "fail");
            }
        });
    }

    public void getAllTags(PresenterTagsCallback callback) {
        API api = new RetrofitInstance().getRetrofitInstance();
        Call<List<Pengumuman.Data.Tags>> call = api.getAllTags();

        call.enqueue(new Callback<List<Pengumuman.Data.Tags>>() {
            @Override
            public void onResponse(Call<List<Pengumuman.Data.Tags>> call, Response<List<Pengumuman.Data.Tags>> response) {
                if (response.isSuccessful()) {
                    // Do something with the response
                    List<Pengumuman.Data.Tags> result = response.body();
                    Log.e("tags", "berhasil");
                    callback.tagsFetched(result);
                } else {
                    Log.e("tags", "gagal");
                }
            }

            @Override
            public void onFailure(Call<List<Pengumuman.Data.Tags>> call, Throwable t) {
                // Handle failure
                Log.e("tags", "fail");
            }
        });
    }

    public void postAnnouncement(RequestPengumuman requestPengumuman,
                                 PresenterTambahPengumumanCallback callback) {
        API api = new RetrofitInstance().getRetrofitInstance();
        Call<Pengumuman.Data> call = api.postPengumuman(requestPengumuman);

        call.enqueue(new Callback<Pengumuman.Data>() {
            @Override
            public void onResponse(Call<Pengumuman.Data> call, Response<Pengumuman.Data> response) {
                if (response.isSuccessful()) {
                    // Do something with the response
                    Pengumuman.Data result = response.body();
                    callback.dataFetched(result);
                    Log.e("tags", "berhasil");
                } else {
                    Log.e("tags", "gagal");
                    callback.failFetched();
                }
            }

            @Override
            public void onFailure(Call<Pengumuman.Data> call, Throwable t) {
                // Handle failure
                Log.e("tags", "fail");
                callback.failFetched();
            }
        });
    }

    public String getCurrentCursor() {
        return currentCursor;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    //    protected List<Pengumuman> listPengumuman;
//
//    public PresenterPengumuman(PresenterPertemuan.IMainActivity ui){
//        this.pertemuans = new ArrayList<>();
//        this.UI = ui;
//    }
//
//    public interface IMainActivity{
//        void updateList(List<Pertemuan> pertemuans);
//    }
}
