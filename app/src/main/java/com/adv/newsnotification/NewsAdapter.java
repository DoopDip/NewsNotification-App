package com.adv.newsnotification;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by narit on 15/11/2017 AD.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private final String TAG_NEWS = "ข่าวเศรษกิจ";
    private final String TAG_POLITICAL = "ข่าวการเมือง";
    private final String TAG_TECHNOLOGY = "ข่าวเทคโนโลยี";
    private final String TAG_ENTERTAINMENT = "ข่าวบันเทิง";
    private final String TAG_EDUCATION = "ข่าวการศึกษา";
    private final String TAG_CRIMINAL = "ข่าวอาชญากรรม";
    private final String TAG_SPORT = "ข่าวกีฬา";
    private final String TAG_SOCIAL = "ข่าวสังคม";

    private List<News> list;

    public NewsAdapter(List<News> list) {
        this.list = list;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        News news = list.get(position);
        holder.textViewTitle.setText(news.title);
        holder.newsId = news.id;

        holder.textViewType.setText(tagsName(news.type));

        Picasso.with(holder.imageView.getContext()).load(news.image).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class NewsHolder extends RecyclerView.ViewHolder {

        private Context context;

        public ImageView imageView;
        public TextView textViewTitle;
        public TextView textViewType;
        public RelativeLayout relativeLayout;

        public int newsId;

        public NewsHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.listNews_image);
            textViewTitle = (TextView) itemView.findViewById(R.id.listNews_title);
            textViewType = (TextView) itemView.findViewById(R.id.listNews_type);

            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.listNews_box);
            context = itemView.getContext();
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NewsClick","List:"+getAdapterPosition()+" / NewsID:"+newsId);
                    Intent intent = new Intent(context , ReadActivity.class);
                    intent.putExtra("newsId", String.valueOf(newsId));
                    context.startActivity(intent);
                }
            });
        }
    }

    private String tagsName(int tag) {
        if (tag == 1)
            return TAG_NEWS;
        else if (tag == 2)
            return TAG_POLITICAL;
        else if (tag == 3)
            return TAG_TECHNOLOGY;
        else if (tag == 4)
            return TAG_ENTERTAINMENT;
        else if (tag == 5)
            return TAG_EDUCATION;
        else if (tag == 6)
            return TAG_CRIMINAL;
        else if (tag == 7)
            return TAG_SPORT;
        else if (tag == 8)
            return TAG_SOCIAL;
        return "Tags Error";
    }

}
