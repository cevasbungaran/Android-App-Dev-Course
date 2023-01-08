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
    public static String getRoles(int position){
        return user.get(position).getRoles();
    }


    public static boolean login(String email,int radio){
        boolean checker=false;
        boolean checkerRole=false;
        System.out.println(radio);

        for(int i=0;i<user.size();i++){
            if(getemail(i).equals(email) ){
                checker=true;
                for(int k=0;k<getRoles(i).length();k++){
                    String x=getRoles(i).replace("[","");
                    x=x.replace("]","");
                    x=x.replace("\"","");
                    System.out.println(x);
                    if(x.equals("admin") && radio==2131231246){
                        checkerRole=true;
                    }
                    if(x.equals("lecturer") && radio== 2131231247){
                        checkerRole=true;
                    }
                     if(x.equals("student") && radio== 2131231248){
                        checkerRole=true;
                    }


                }
                break;
            }
            else{
                checker=false;
            }
        }

        System.out.println(checkerRole);
        return checker&&checkerRole;
    }

//&& getRoles(i).equals("admin")
}
