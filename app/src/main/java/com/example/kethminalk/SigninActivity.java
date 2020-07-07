package com.example.kethminalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SigninActivity extends AppCompatActivity {

    TextView account;

    private Retrofit retrofit;
    private com.example.kethminalk.RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://172.20.10.3:5000/api/auth/";

    EditText edtxtNsme, edtxtemail;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        edtxtNsme = (EditText) findViewById(R.id.Email);
        edtxtemail = (EditText) findViewById(R.id.Password);

        btn = (Button) findViewById(R.id.LoginBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                User user = new User(

                        edtxtNsme.getText().toString(),
                        edtxtemail.getText().toString()

                );

                submit(user);
            }

        });



      /*  account = (TextView) findViewById(R.id.CreateAccount);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registered();

            }
        });


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(com.example.kethminalk.RetrofitInterface.class);


        findViewById(R.id.LoginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLoginDialog();

            }
        });
//

}




    private void registered() {

        Intent intent = new Intent(SigninActivity.this,RegisterActivity.class);
        startActivity(intent);


    }


   private void handleLoginDialog() {


        Button loginBtn = (Button)findViewById(R.id.LoginBtn);
        final EditText emailEdit = (EditText)findViewById(R.id.Email);
        final EditText passwordEdit = (EditText)findViewById(R.id.Password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, String> map = new HashMap<>();

                map.put("email", emailEdit.getText().toString());
                map.put("password", passwordEdit.getText().toString());

                Call<com.example.kethminalk.LoginResult> call = retrofitInterface.executeLogin(map);

                call.enqueue(new Callback<com.example.kethminalk.LoginResult>() {
                    @Override
                    public void onResponse(Call<com.example.kethminalk.LoginResult> call, Response<com.example.kethminalk.LoginResult> response) {

                        if (response.code() == 200) {

                            *//*com.example.kethminalk.LoginResult result = response.body();

                            AlertDialog.Builder builder1 = new AlertDialog.Builder(SigninActivity.this);
                            builder1.setTitle(result.getName());
                            builder1.setMessage(result.getEmail());

                            builder1.show();*//*

                            Toast.makeText(SigninActivity.this,"you have signing successfully!",Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(SigninActivity.this,DashboardActivity.class);
                            startActivity(intent);



                        } else if (response.code() == 404) {
                            Toast.makeText(SigninActivity.this, "Your email or password incorrect!",
                                    Toast.LENGTH_LONG).show();
                        }

                    }



                    @Override
                    public void onFailure(Call<com.example.kethminalk.LoginResult> call, Throwable t) {
                        Toast.makeText(SigninActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

            }
        });



    }
*/
    }

    public void submit(User user) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        RetrofitInterface apiService = retrofit.create(RetrofitInterface.class);
        Call<SignupResponse> responseCall = apiService.signUp(user);

        responseCall.enqueue(
                new Callback<SignupResponse>() {
                    @Override
                    public void onResponse(Call<SignupResponse> call, retrofit2.Response<SignupResponse> response) {

                        if(response.body()!=null){
                            Log.e("RESPONSE", ""+response.body().getMessage());
                        }else{
                            Log.e("No RES", "");
                        }
                    }

                    @Override
                    public void onFailure(Call<SignupResponse> call, Throwable t) {
                        Log.e("FAIL", ""+t.getMessage());
                    }
                }
        );
    }



}





