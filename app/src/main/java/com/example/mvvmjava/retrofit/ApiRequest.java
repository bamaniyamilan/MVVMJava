package com.example.mvvmjava.retrofit;

import static com.example.mvvmjava.constants.AppConstant.API_KEY;

import com.example.mvvmjava.response.ArticleRespose;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public interface ApiRequest {

    @GET("top-headlines?country=ca&category=entertainment&apiKey="+API_KEY)
    Call<ArticleRespose> getTopHeadlines();

}
