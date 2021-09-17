package com.example.android.nerdynews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result.getWebUrl()));
            context.startActivity(browserIntent);
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title_heading);
            subTitle=itemView.findViewById(R.id.subHeading_text);
            img=itemView.findViewById(R.id.image_item);

        }
    }
}
