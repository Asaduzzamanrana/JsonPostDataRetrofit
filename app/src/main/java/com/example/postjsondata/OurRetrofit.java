package com.example.postjsondata;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OurRetrofit {
    @POST("/post")
    Call<OurDataSet> PostData(@Body OurDataSet ourDataSet);
}
