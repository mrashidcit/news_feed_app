package com.example.android.newsfeed.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsfeed.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashid Saleem on 12/22/2017.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(@NonNull Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        Article currentArticle = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.article_image);
        TextView titleView = (TextView) listItemView.findViewById(R.id.tv_title);
        TextView authorView = (TextView) listItemView.findViewById(R.id.tv_author);
        TextView publishedAtView = (TextView) listItemView.findViewById(R.id.tv_published_at);

//        Uri imageUri = Uri.parse(currentArticle.getUrlToImage());
        String urlToImage = currentArticle.getUrlToImage();

        Picasso.with(getContext()).load(urlToImage)
                .resize(80, 80)
                .centerCrop()
                .into(imageView);

//        imageView.setImageBitmap(bmp);
        titleView.setText(currentArticle.getTitle());
        authorView.setText(currentArticle.getAuthor());

        String publishAt = currentArticle.getPublicedAt();

        publishedAtView.setText(currentArticle.getPublicedAt());



        return listItemView;
    }
}























