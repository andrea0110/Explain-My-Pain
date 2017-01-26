package com.example.andreadellaporta.explainmypain;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by andreadellaporta on 25/01/17.
 */

public class SharedPrefManagerD {
    private static SharedPrefManagerD mInstance;
    private static Context mCtx;

    private static  final  String SHARED_PREF_NAME = "mysharedpref12d";
    private static final String KEY_USER_EMAIL= "email";
    private static final String KEY_USER_ID= "id";
    private static final String KEY_USER_NAME= "name";
    private static final String KEY_USER_SURNAME= "surname";



    private SharedPrefManagerD(Context context) {
        mCtx = context;


    }

    public static synchronized SharedPrefManagerD getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManagerD(context);
        }
        return mInstance;
    }

   public boolean doctorLogin(int id, String email,String name, String surname){

       SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
       SharedPreferences.Editor editor =sharedPreferences.edit();
       editor.putInt(KEY_USER_ID,id);
       editor.putString(KEY_USER_EMAIL,email);
       editor.putString(KEY_USER_NAME,name);
       editor.putString(KEY_USER_SURNAME,surname);

       editor.apply();

       return true;

   }

    public boolean isLoggedIn(){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USER_EMAIL,null) != null){
            return true;
        }

        return false;

    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    public String getName(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_NAME,null);
    }

    public String getSurname(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_SURNAME,null);
    }



}
