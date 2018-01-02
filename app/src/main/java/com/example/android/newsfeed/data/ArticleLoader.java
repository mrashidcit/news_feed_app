package com.example.android.newsfeed.data;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Rashid Saleem on 12/22/2017.
 */

//public class ArticleLoader extends AsyncTaskLoader<List<Article>> {
public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    // Tag for log messages
    private static final String LOG_TAG = ArticleLoader.class.getSimpleName();

    // Query URL
    private String mUrl;

    public ArticleLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();

    }


    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Article> articles = QueryUtils.fetchArticleData(mUrl);

        return articles;
    }
}
