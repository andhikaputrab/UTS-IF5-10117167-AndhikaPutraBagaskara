package com.apps.andhikaapps.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static final String PREF_SESSION = "com.apps.andhika.latihanpreference.session";
    private static final String LAUNCH_STATUS = "LAUNCH_STATUS";

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public Preferences(){
    }

    public static void setFirstTimeStatus(boolean FirstLaunch, Context context){
        sharedPreferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(LAUNCH_STATUS, FirstLaunch);
        editor.apply();
    }
    public static boolean getFirstTimeStatus(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(LAUNCH_STATUS, UtilStatic.DEFAULT_BOOLEAN);
    }

    public static void setLogOut(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_SESSION, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.remove(LAUNCH_STATUS);
        editor.apply();
    }
}
