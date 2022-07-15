package com.example.mvvmjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmjava.R;
import com.example.mvvmjava.model.Article;

import java.util.ArrayList;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final Context context;
    ArrayList<Article> articleArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {

        Article article = articleArrayList.get(position);
        holder.txTitle.setText(article.getTitle());
       // holder.tvDesc.setText(article.getDescription());
        Glide.with(context)
                .load(article.getUrlToImage())
                .into(holder.imgViewCover);


    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgViewCover;
        private final TextView txTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover = itemView.findViewById(R.id.imgViewCover);
            txTitle = itemView.findViewById(R.id.tvTitle);
            //tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}
