package com.example.kethminalk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DashbordProfileActivity extends AppCompatActivity {

    TextView Name;
    TextView Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord_profile);

        Name = (TextView) findViewById(R.id.ProfileName);
        Email = (TextView) findViewById(R.id.ProfileEmail);




    }
}
