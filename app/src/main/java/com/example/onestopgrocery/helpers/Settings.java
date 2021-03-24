package com.example.onestopgrocery.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class Settings {
    private static SharedPreferences settings;
    private Settings() {}

    public static final String USER_LOGGED_KEY = "IS_USER_LOGGED";

    public static SharedPreferences getSettings(Context context) {
        if (settings == null) {
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return settings;
    }

    public static boolean IsUserLoggedIn(Context context) {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(context);
        return account != null || getSettings(context).getBoolean(USER_LOGGED_KEY, false);
    }
}
