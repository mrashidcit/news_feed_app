package com.example.android.newsfeed.NewsCategory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.newsfeed.MainActivity;
import com.example.android.newsfeed.OnArticleLoadListener;
import com.example.android.newsfeed.R;
import com.example.android.newsfeed.data.Article;
import com.example.android.newsfeed.data.ArticleAdapter;
import com.example.android.newsfeed.data.ArticleLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashid Saleem on 02-Jan-18.
 */

public class BusinessFragment extends Fragment
                                implements LoaderManager.LoaderCallbacks<List<Article>>{

    private static final String NEWS_REQUEST_URL = "https://newsapi.org/v2/top-headlines?category=business&language=en&apiKey=542354984a344ae4840697bae66404fd";

    private static final int NEWS_LOADER_ID = 1;
    private static final String LOG_TAG = BusinessFragment.class.getSimpleName();

    private ListView mArticleListView;

    private OnArticleLoadListener mOnArticleLoadListener;

    private ArticleAdapter mArticleAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.news_list, container, false);

        mArticleListView = (ListView) rootView.findViewById(R.id.news_list);

        mArticleAdapter = new ArticleAdapter(getContext(), new ArrayList<Article>());
        mArticleListView.setAdapter(mArticleAdapter);

        // Get a reference to the LoaderManager, in order to interact with loaders.
        LoaderManager loaderManager = getLoaderManager();

        // Initialize the loader.. Pass in the int ID constant defined above and pass in null for the bundle.
        // Pass in this activity for the LoaderCallbacks paramter (which is valid because this activity implement the LoaderCallbacks interface).
        loaderManager.initLoader(NEWS_LOADER_ID, null, this);

        return rootView;
    }

    @Override
    public Loader<List<Article>> onCreateLoader(int id, Bundle args) {
        // Create a new loader for the given URL

        return new ArticleLoader(getContext(), NEWS_REQUEST_URL);

    }


    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> data) {

        // Clear the adapter of previous article data
        mArticleAdapter.clear();

        // If there is a vlid list of {@link Article}s, then add them to the adapter's data set.
        // This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mArticleAdapter.addAll(data);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        // Loader reset, so we can clear out our existing data.
        mArticleAdapter.clear();
    }
}
