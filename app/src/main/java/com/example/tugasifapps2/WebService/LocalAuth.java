package com.example.tugasifapps2.WebService;

import android.content.Context;
import android.content.SharedPreferences;

//https://stackoverflow.com/questions/51596544/save-access-token-via-shared-preferences-android
public class LocalAuth {
    private static final String PREFS_NAME = "AuthPrefs";
    private static final String TOKEN_KEY = "token";
    private static final String ROLE_KEY = "role";

    private SharedPreferences preferences;

    public LocalAuth(Context context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setAuthToken(String token) {
        preferences.edit().putString(TOKEN_KEY, token).apply();
    }

    public String getAuthToken() {
        return preferences.getString(TOKEN_KEY, "");
    }

    public void setRole(String role) {
        preferences.edit().putString(ROLE_KEY, role).apply();
    }

    public String getRole() {
        return preferences.getString(ROLE_KEY, "");
    }

    public void clear() {
        preferences.edit().clear().apply();
    }
}
