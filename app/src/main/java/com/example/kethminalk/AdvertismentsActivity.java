package com.example.kethminalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdvertismentsActivity extends AppCompatActivity {


    private Retrofit retrofit;
    private com.example.kethminalk.RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.168.1.102:3000";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisments);


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(com.example.kethminalk.RetrofitInterface.class);


        findViewById(R.id.Send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSubmitDialog();
            }
        });

    }

    private void handleSubmitDialog() {


        Button sendBtn = (Button)findViewById(R.id.Send);
        final EditText post = (EditText)findViewById(R.id.TypeMessage);



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, String> map = new HashMap<>();

                map.put("Post", post.getText().toString());


                Call<Void> call = retrofitInterface.post(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Toast.makeText(AdvertismentsActivity.this,
                                    "Your Post Submitted successfully", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(AdvertismentsActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

            }
        });






    }
}
