package com.example.tugasifapps2.Presenter;

import android.util.Log;

import com.example.tugasifapps2.Model.Login;
import com.example.tugasifapps2.Model.LoginRequest;
import com.example.tugasifapps2.Model.User;
import com.example.tugasifapps2.WebService.API;
import com.example.tugasifapps2.WebService.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterUser {
    public interface PresenterCallback {
        void loginSuccess(String result);

        void loginError(String result);
    }

    static ArrayList<User> user = new ArrayList<User>();

    public static void addToList(String id, String name, String email, String archived_at, List<String> roles) {
        user.add(new User(id, name, email, archived_at, roles));
    }

    public static String getUsername(int position) {
        return user.get(position).getName();
    }

    public static String getId(int position) {
        return user.get(position).getId();
    }

    public static String getemail(int position) {
        return user.get(position).getEmail();
    }

    public static String getRoles(int position) {
        return user.get(position).getRoles().get(position);
    }


    public static void login(String email, String password, PresenterCallback callback) {
        API api = new RetrofitInstance().getRetrofitInstance();
        Call<Login> call = api.doLogin(new LoginRequest(email, password, "admin"));

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()) {
                    // Do something with the response
                    Login movieDetail = response.body();
                    Log.e("hoho", "berhasil");
                    callback.loginSuccess(movieDetail.getToken());
                } else {
                    Log.e("hoho", "gagal");
                    // Handle error case
                    callback.loginError("login error");
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                // Handle failure
                Log.e("hoho", "fail");
                callback.loginError("login error");
            }
        });
//
//        boolean checker=false;
//        boolean checkerRole=false;
//        System.out.println(radio);
//
//        for(int i=0;i<user.size();i++){
//            if(getemail(i).equals(email) ){
//                checker=true;
//                for(int k=0;k<getRoles(i).length();k++){
//                    String x=getRoles(i).replace("[","");
//                    x=x.replace("]","");
//                    x=x.replace("\"","");
//                    System.out.println(x);
//                    if(x.equals("admin") && radio==2131231246){
//                        checkerRole=true;
//                    }
//                    if(x.equals("lecturer") && radio== 2131231247){
//                        checkerRole=true;
//                    }
//                     if(x.equals("student") && radio== 2131231248){
//                        checkerRole=true;
//                    }
//
//
//                }
//                break;
//            }
//            else{
//                checker=false;
//            }
//        }

//        System.out.println(checkerRole);
//        return checker&&checkerRole;
    }

//&& getRoles(i).equals("admin")
}
