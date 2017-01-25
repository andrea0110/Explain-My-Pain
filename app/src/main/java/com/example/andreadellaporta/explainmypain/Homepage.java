package com.example.andreadellaporta.explainmypain;
import android.content.Intent;
import android.widget.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button register=(Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), RegistrationPage.class);
                startActivity(intent);
            }
        });

        Button doctorLogin=(Button) findViewById(R.id.doctorLogin);
        doctorLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(getApplicationContext(), LoginPageD.class);
                startActivity(intent2);
            }
        });

        Button patientLogin=(Button) findViewById(R.id.patientLogin);
        patientLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3= new Intent(getApplicationContext(), LoginPageP.class);
                startActivity(intent3);
            }
        });


    }


}
