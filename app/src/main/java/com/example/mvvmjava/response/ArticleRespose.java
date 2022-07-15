package com.example.mvvmjava.response;

import com.example.mvvmjava.model.Article;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public class ArticleRespose {

    @SerializedName("articles")
    @Expose
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "BashboardNewsRespose{" +
                "articles=" + articles + '}';
    }
}
