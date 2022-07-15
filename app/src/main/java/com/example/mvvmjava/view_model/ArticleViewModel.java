package com.example.mvvmjava.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmjava.model.Article;
import com.example.mvvmjava.repository.ArticleRepository;
import com.example.mvvmjava.response.ArticleRespose;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleRespose> articleResposeLiveData;

    public ArticleViewModel(@NonNull Application application) {

        super(application);
        articleRepository = new ArticleRepository();
        this.articleResposeLiveData = articleRepository.getDashboardNews();
    }

    public LiveData<ArticleRespose> getBashboardNewsResponseLiveData(){
        return articleResposeLiveData;
    }
}
