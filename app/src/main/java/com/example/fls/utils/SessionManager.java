package com.example.fls.utils;

import android.content.Context;
import android.content.SharedPreferences;



public class SessionManager {
    private static String TAG = SessionManager.class.getName();
    SharedPreferences preferences;
    Context context;
    SharedPreferences.Editor editor;
    private int PRE_MODE = 1;
    private static final String NAME = "4life_V2";
    private static final String KEY_LOGIN = "islogin";

    public SessionManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NAME, PRE_MODE);
        editor = preferences.edit();
    }

    public void SetLogin(boolean isLogin) {
        editor.putBoolean(KEY_LOGIN, isLogin);
        editor.commit();
    }

    public boolean IsLogin() {
        return preferences.getBoolean(KEY_LOGIN, false);
    }
}
