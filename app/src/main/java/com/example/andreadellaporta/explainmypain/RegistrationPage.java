package com.example.andreadellaporta.explainmypain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;



public class RegistrationPage extends AppCompatActivity implements View.OnClickListener {


    EditText inputName;
    EditText inputSurname;
    EditText inputEmail;
    EditText inputPassword;
    EditText inputBirth;
    RadioButton male, female,doctor,patient;
    String gender;
    private Button btnRegister;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        inputName=(EditText) findViewById(R.id.fname);
        inputSurname=(EditText) findViewById(R.id.lname);
        inputEmail=(EditText) findViewById(R.id.email);
        inputPassword=(EditText) findViewById(R.id.pword);
        inputBirth=(EditText) findViewById(R.id.birth);
        male=(RadioButton) findViewById(R.id.male);
        female=(RadioButton) findViewById(R.id.female);
        doctor=(RadioButton) findViewById(R.id.doctor);
        patient=(RadioButton) findViewById(R.id.patient);

        btnRegister = (Button) findViewById(R.id.register);


        progressDialog= new ProgressDialog(this);

        btnRegister.setOnClickListener(this);

    }

    private void registerUser(){
        final String name=inputName.getText().toString().trim();
        final String surname=inputSurname.getText().toString().trim();
        final String email=inputEmail.getText().toString().trim();
        final String password=inputPassword.getText().toString().trim();
        final String birth=inputBirth.getText().toString().trim();




        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        StringRequest stringRequest= new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();

                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("name",name);
                params.put("surname",surname);
                params.put("email",email);
                params.put("password",password);
                params.put("birth",birth);
                if(male.isChecked()) gender="m";
                else if(female.isChecked()) gender="f";
                params.put("gender", gender);
                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);


    }

    private void registerDoctor(){
        final String name=inputName.getText().toString().trim();
        final String surname=inputSurname.getText().toString().trim();
        final String email=inputEmail.getText().toString().trim();
        final String password=inputPassword.getText().toString().trim();



        progressDialog.setMessage("Registering doctor...");
        progressDialog.show();

        StringRequest stringRequest= new StringRequest(Request.Method.POST,
                Constants.DOCTOR_URL_REGISTER,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();

                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("name",name);
                params.put("surname",surname);
                params.put("email",email);
                params.put("password",password);

                return params;
            }
        };
        RequestHandlerD.getInstance(this).addToRequestQueue(stringRequest);


    }

    @Override
    public void onClick(View view) {
        if(view==btnRegister){
            if(patient.isChecked()) {
                registerUser();
                finish();
                Intent intent=new Intent(getApplicationContext(),LoginPageP.class);
                startActivity(intent);
            }
            else if(doctor.isChecked()) {
                registerDoctor();
                finish();
                Intent intent=new Intent(getApplicationContext(),LoginPageD.class);
                startActivity(intent);
            }
        }

    }
}





