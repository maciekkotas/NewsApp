package com.newsapp.android.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by macie on 22.06.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mNews;
    private MainActivity mContext;


    public NewsAdapter(MainActivity context, List<News> newses) {
        mContext = context;
        mNews = newses;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final NewsAdapter.ViewHolder holder, int position) {
        final News currentNews = mNews.get(position);
        holder.title.setText(currentNews.getTitle());
        holder.info.setText(currentNews.getInfo());
        holder.date.setText(currentNews.getDate());
        Picasso.with(mContext).load(currentNews.getImageId()).into(holder.image);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(currentNews.getWebUrl()));
                mContext.startActivity(i);
            }
        });
    }

    public int getItemCount() {
        return mNews.size();
    }

    public void removeItem(int position) {
        mNews.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mNews.size());

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView info;
        ImageView image;
        TextView date;
        CardView cardView;
        RecyclerView mRecycleView;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text_view);
            info = (TextView) itemView.findViewById(R.id.info_text_view);
            image = (ImageView) itemView.findViewById(R.id.image_view);
            date = (TextView) itemView.findViewById(R.id.date_text_view);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            mRecycleView = (RecyclerView) itemView.findViewById(R.id.my_recycler_view);

        }
    }
}


