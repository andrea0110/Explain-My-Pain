package com.example.andreadellaporta.explainmypain;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by andreadellaporta on 25/01/17.
 */

public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USER_EMAIL= "email";
    private static final String KEY_USER_ID= "userid";
    private static final String KEY_USER_NAME= "name";
    private static final String KEY_USER_SURNAME= "surname";
    private static final String KEY_USER_BIRTH= "birth";
    private static final String KEY_USER_GENDER= "gender";


    private SharedPrefManager(Context context) {
        mCtx = context;


    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

   public boolean userLogin(int id, String email, String name, String surname, String birth, String gender){

       SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
       SharedPreferences.Editor editor =sharedPreferences.edit();
       editor.putInt(KEY_USER_ID,id);
       editor.putString(KEY_USER_EMAIL,email);
       editor.putString(KEY_USER_NAME,name);
       editor.putString(KEY_USER_SURNAME,surname);
       editor.putString(KEY_USER_BIRTH,birth);
       editor.putString(KEY_USER_GENDER,gender);

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

    public String getBirth(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_BIRTH,null);
    }

    public String getGender(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_GENDER,null);
    }

}
