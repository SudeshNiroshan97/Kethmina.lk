package com.example.kethminalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegProfileActivity extends AppCompatActivity {

    Button createProf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_profile);

        createProf = (Button) findViewById(R.id.CreateProfile);


        createProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OpenNewPage();

            }
        });

    }

    private void OpenNewPage() {

        Intent intent = new Intent(RegProfileActivity.this,CreateProfileActivity.class);
        startActivity(intent);


    }
}
