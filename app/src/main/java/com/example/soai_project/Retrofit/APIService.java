package com.example.soai_project.Retrofit;


import com.example.soai_project.DataModel.FounderModel;
import com.example.soai_project.DataModel.FunderModel;
import com.example.soai_project.Founderr1.Response1;
import com.example.soai_project.companydetails.Companies;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST("signup")
    Call<JsonObject> funderregisteraddedsucessfully(@Body JsonObject jsonObject);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST("signup")
    Call<JsonObject> founderregisteraddedsuccessfully(@Body JsonObject jsonObject);


    @GET("companydetails")
    Call<Companies> getCompanyList();


}
