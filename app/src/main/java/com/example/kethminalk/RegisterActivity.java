package com.example.kethminalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class RegisterActivity extends AppCompatActivity {


    private Retrofit retrofit;
    private com.example.kethminalk.RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://172.20.10.3:5000/api/users/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(com.example.kethminalk.RetrofitInterface.class);


        findViewById(R.id.Register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSignupDialog();
            }
        });

    }

    private void handleSignupDialog() {

      /*  View view = getLayoutInflater().inflate(R.layout.signup_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view).show();*/

        Button signupBtn = (Button)findViewById(R.id.Register);
        final EditText name = (EditText) findViewById(R.id.Name);
        final EditText email = (EditText)findViewById(R.id.Email);
        final EditText passwordEdit = (EditText) findViewById(R.id.Passcode);
        final EditText confirmPasswordEdit = (EditText)findViewById(R.id.ConfirmPassword);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, String> map = new HashMap<>();

                map.put("name", name.getText().toString());
                map.put("email", email.getText().toString());
                map.put("password", passwordEdit.getText().toString());
//                map.put("confirmPassword", confirmPasswordEdit.getText().toString());

                Call<Void> call = retrofitInterface.executeSignup(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {


                        if (response.code() == 200) {
                            Toast.makeText(RegisterActivity.this,
                                    "Signed up successfully", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(RegisterActivity.this,RegProfileActivity.class);
                            startActivity(intent);



                        } else if (response.code() == 400) {
                            Toast.makeText(RegisterActivity.this,
                                    "Already registered", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

            }
        });





    }
}
