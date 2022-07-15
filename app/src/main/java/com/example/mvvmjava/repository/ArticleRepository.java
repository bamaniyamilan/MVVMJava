package com.example.mvvmjava.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmjava.response.ArticleRespose;
import com.example.mvvmjava.retrofit.ApiRequest;
import com.example.mvvmjava.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public class ArticleRepository {

    private static final String TAG = ArticleRepository.class.getSimpleName();
    private final ApiRequest apiRequest;


    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleRespose> getDashboardNews() {
        final MutableLiveData<ArticleRespose> data = new MutableLiveData<>();
        apiRequest.getTopHeadlines().enqueue(new Callback<ArticleRespose>() {
            @Override
            public void onResponse(Call<ArticleRespose> call, Response<ArticleRespose> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArticleRespose> call, Throwable t) {

                data.setValue(null);
            }
        });
        return data;
    }
}
