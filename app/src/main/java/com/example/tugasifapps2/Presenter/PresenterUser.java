package com.example.tugasifapps2.Presenter;

import com.example.tugasifapps2.Model.User;

import java.util.ArrayList;

public class PresenterUser {
    static ArrayList<User> user = new ArrayList<User>();
    public static void addToList(String id, String name, String email, String archived_at, String roles){
        user.add(new User(id, name, email, archived_at,roles));
    }

    public static String getUsername(int position){
        return user.get(position).getName();
    }
    public static String getId(int position){
        return user.get(position).getId();
    }
    public static String getemail(int position){
        return user.get(position).getEmail();
    }


    public static boolean login(String email){
        boolean checker=false;
        for(int i=0;i<user.size();i++){
            if(getemail(i).equals(email)){
                checker=true;
                break;
            }
            else{
                checker=false;
            }
        }

        return checker;
    }


}