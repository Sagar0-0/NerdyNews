package com.example.android.nerdynews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final ArrayList<Result> results;
    private final Context context;

    public NewsAdapter(ArrayList<Result> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_rv,parent,false);
        return new ViewHolder(listItemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        Result result=results.get(position);
        holder.title.setText(result.getWebTitle());
        holder.subTitle.setText("Dated: "+ result.getWebPublicationDate());

        try{
            Picasso.get().load(result.getFields().getThumbnail()).into(holder.img);
        }catch(Exception ignored){}

        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(context, Webview.class);
            intent.putExtra("url",result.getWebUrl());
            context.startActivity(intent);
        });

        holder.shareNews.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String link=result.getWebUrl();
            String s="You should give it a check: "+link;
            intent.putExtra(Intent.EXTRA_TEXT,s);
            context.startActivity(Intent.createChooser(intent,"ShareVia"));
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final TextView subTitle;
        private final ImageView img;
        private final Button shareNews;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shareNews=itemView.findViewById(R.id.share_news);
            title=itemView.findViewById(R.id.title_heading);
            subTitle=itemView.findViewById(R.id.subHeading_text);
            img=itemView.findViewById(R.id.image_item);

        }
    }
}
