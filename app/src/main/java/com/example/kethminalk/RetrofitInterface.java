package com.example.kethminalk;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/login")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    @POST("/signup")
    Call<Void> executeSignup(@Body HashMap<String, String> map);


    @Headers("Content_Type: application/json")
    @POST("/users/createProfile")
    Call<Void> createProfile(@Body HashMap<String, String> map);

    @Headers("Content_Type: application/json")
    @POST("/post")
    Call<Void> post(@Body HashMap<String, String> map);

    @GET("/userData")
    Call<Void> userDetails(@Body HashMap<String, String> map);

    @Headers("Content-Type: application/json")
    @POST("users/signup")
    Call<SignupResponse> signUp(@Body User user);



}
