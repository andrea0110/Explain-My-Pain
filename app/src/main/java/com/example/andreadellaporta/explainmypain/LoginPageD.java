package com.example.andreadellaporta.explainmypain;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginPageD extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            startActivity(new Intent(this, DoctorHomepage.class));
            return;
        }

        editTextEmail=(EditText) findViewById(R.id.emailD);
        editTextPassword=(EditText) findViewById(R.id.passwordd);
        buttonLogin=(Button) findViewById(R.id.login_d);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        buttonLogin.setOnClickListener(this);

    }

    private void doctorLogin(){
        final String email = editTextEmail.getText().toString().trim();
        final String password= editTextPassword.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest=new StringRequest(
                Request.Method.POST,
                Constants.DOCTOR_URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj= new JSONObject(response);
                            if(!obj.getBoolean("error")){
                                SharedPrefManagerD.getInstance(getApplicationContext()).doctorLogin(obj.getInt("id"), obj.getString("email"), obj.getString("name"), obj.getString("surname"));
                                startActivity(new Intent(getApplicationContext(), DoctorHomepage.class));
                                finish();
                            }else{
                                Toast.makeText(
                                        getApplicationContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    @Override
    public void onClick(View view) {
        if(view==buttonLogin){
            doctorLogin();
        }
    }
}
