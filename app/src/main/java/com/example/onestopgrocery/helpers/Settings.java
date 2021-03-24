package com.example.onestopgrocery.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.onestopgrocery.UserProfileActivity;
import com.example.onestopgrocery.entities.User;
import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Settings {
    private static SharedPreferences settings;
    private Settings() {}

    public static final String USER_LOGGED_KEY = "IS_USER_LOGGED";
    public static final String USER_INFO = "USER_INFO";

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

    public static User getLoggedUserData(Context context) {
        User userGoggle = getGoogleLoggedUser(context);
        User userFB = getFacebookLoggedUser();
        User localStored = getStoredUser(context);
        if (userGoggle != null) {
            return userGoggle;
        } else if (userFB != null) {
            return userFB;
        } else {
            return localStored;
        }
    }

    public interface OnSignOff {
        void onSignOffComplete();
    }

    public static void signOut(Context context, OnSignOff onSignOff) {
        User userGoggle = getGoogleLoggedUser(context);
        User userFB = getFacebookLoggedUser();
        if (userGoggle != null) {
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();
            // Build a GoogleSignInClient with the options specified by gso.
            GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(context, gso);
            mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    onSignOff.onSignOffComplete();
                }
            });
        } else if (userFB != null) {
            // Nothing here, TODO
        } else {
            getSettings(context).edit().remove(USER_LOGGED_KEY).commit();
            getSettings(context).edit().remove(USER_INFO).commit();
            onSignOff.onSignOffComplete();
        }
    }

    private static User getGoogleLoggedUser(Context context) {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(context);
        if (account != null) {
            return new User() {
                {
                    fullName = String.format("%s %s", account.getGivenName(), account.getFamilyName());
                    email = account.getEmail();
                    login = account.getDisplayName();
                }
            };
        }
        return null;
    }

    private static User getFacebookLoggedUser() {
        AccessToken facebookAccessToken = AccessToken.getCurrentAccessToken();
        // There is no clear and easy way of getting logged user information
        return null;
    }

    private static User getStoredUser(Context context) {
        String rawInfo = getSettings(context).getString(Settings.USER_INFO, "");
        String[] splitInfo = rawInfo.split("\\|");
        if (splitInfo != null && splitInfo.length >= 3) {
            return new User() {
                {
                    login = splitInfo[0];
                    fullName = splitInfo[1];
                    email = splitInfo[2];
                }
            };
        } else {
            return null;
        }
    }
}
