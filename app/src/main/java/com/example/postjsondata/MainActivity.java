package com.example.postjsondata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2;
    private TextView textView;
    String name,hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.editText1Id);
        e2=findViewById(R.id.editText2Id);
        textView=findViewById(R.id.textViewId);
    }

    public void PostData(View view) {
        name=e1.getText().toString();
        hobby=e2.getText().toString();

       Retrofit retrofit=new Retrofit.Builder().baseUrl("https://httpbin.org")
               .addConverterFactory(GsonConverterFactory.create())
               .build();

        OurRetrofit ourRetrofit =retrofit.create(OurRetrofit.class);
        OurDataSet ourDataSet = new OurDataSet(name,hobby);
        Call<OurDataSet>call= ourRetrofit.PostData(ourDataSet);
        call.enqueue(new Callback<OurDataSet>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<OurDataSet> call, Response<OurDataSet> response) {
                textView.setText(response.body().getJson().getName() + "\n" +response.body().getJson().getHobby());

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFailure(Call<OurDataSet> call, Throwable t) {
                textView.setText("connection fail");
            }
        });
    }
}