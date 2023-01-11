package com.example.tugasifapps2.WebService;

import android.os.AsyncTask;
import android.util.Log;

import com.example.tugasifapps2.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import com.example.tugasifapps2.Presenter.PresenterUser;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://ifportal.labftis.net/api/v1/users");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Authorization","Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7InVzZXJfaWQiOiI2ZTY2ODZmMC0yOTZlLTRjNzItOGE0NS1hNmFjMWVkNDhlNDQiLCJyb2xlIjoiYWRtaW4ifSwiaWF0IjoxNjczNDE4MzU1fQ.3morsNHLeMMlUnE0DDApqffxhkvk-lN04QXIyCP4m0E");
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;

            StringBuffer response = new StringBuffer();
            int s=0;
            while ((output = in.readLine()) != null) {
                response.append(output);
             }
            String hasil=response.toString();
            JSONArray array = new JSONArray(hasil);

            in.close();
            // printing result from response
            System.out.println(array);
//
//            PresenterUser pu= new PresenterUser();
//            for (int i = 0; i < array.length(); i++){
//                JSONObject object = array.getJSONObject(i);
//                System.out.println(object.getString("name").toString());
//                System.out.println(object.getString("email").toString());
//                System.out.println(object.getString("roles").toString());
//                pu.addToList(object.getString("id").toString(),object.getString("name").toString(),object.getString("email").toString(),object.getString("archived_at").toString(),object.getString("roles").toString());
//            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Log.d("TAG", "onPostExecute: "+dataParsed);

    }

//    public static void addAlbum(String artis, String album,int rating,int listen,String desc,String release,boolean isi,String image){
//        presenterAlbum.addToList( artis,  album,rating, listen, desc, release,isi,image);
//    }

}