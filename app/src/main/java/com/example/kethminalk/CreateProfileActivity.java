package com.example.kethminalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateProfileActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private com.example.kethminalk.RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://172.20.10.3:5000";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(com.example.kethminalk.RetrofitInterface.class);


        findViewById(R.id.Submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleCreateProfileDialog();

            }
        });

    }

    private void handleCreateProfileDialog() {


        Button submitBtn = (Button)findViewById(R.id.Submit);
        final EditText status = (EditText)findViewById(R.id.Professional);
        final EditText company = (EditText) findViewById(R.id.Company);
        final EditText website = (EditText)findViewById(R.id.Website);
        final EditText location = (EditText)findViewById(R.id.Location);
        final EditText skills = (EditText)findViewById(R.id.Skills);
        final EditText Farm = (EditText)findViewById(R.id.FarmingMethod);
        final EditText bio = (EditText)findViewById(R.id.Bio);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HashMap<String, String> map = new HashMap<>();

                map.put("Status", status.getText().toString());
                map.put("Company", company.getText().toString());
                map.put("Website", website.getText().toString());
                map.put("Location", location.getText().toString());
                map.put("Skills", skills.getText().toString());
                map.put("Method", Farm.getText().toString());
                map.put("Bio", bio.getText().toString());


                Call<Void> call = retrofitInterface.createProfile(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Toast.makeText(CreateProfileActivity.this,
                                    "Create Profile successfully", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(CreateProfileActivity.this,SigninActivity.class);
                            startActivity(intent);


                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(CreateProfileActivity.this," Something went wrong,please try again later!",
                                Toast.LENGTH_LONG).show();
                    }
                });





            }
        });


    }
}
