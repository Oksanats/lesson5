package ru.less5.utils;

import lombok.experimental.UtilityClass;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.Duration;

@UtilityClass
public class RetrofitUtils{
    public Retrofit getRetrofit(){

        return new Retrofit.Builder()
                .baseUrl("http://localhost:8189/market/api/v1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }

}
