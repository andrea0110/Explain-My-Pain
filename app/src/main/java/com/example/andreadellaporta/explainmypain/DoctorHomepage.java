package com.example.andreadellaporta.explainmypain;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DoctorHomepage extends AppCompatActivity {

    private TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button addPatient= (Button) findViewById(R.id.register);
        addPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), NewPatientRegistration.class);
                startActivity(intent);
            }
        });

        Button confirm= (Button) findViewById(R.id.confirmPatient);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(), TabbedDoctor.class);
                startActivity(intent2);
            }
        });

        textViewName=(TextView) findViewById(R.id.namesurnamed);

        textViewName.setText(SharedPrefManagerD.getInstance(this).getName()+" "+SharedPrefManagerD.getInstance(this).getSurname());


    }

}
