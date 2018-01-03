package com.example.android.newsfeed.NewsCategory;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

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

public class ScienceFragment extends Fragment
                        implements LoaderManager.LoaderCallbacks<List<Article>>{

    private static final String NEWS_REQUEST_URL = "https://newsapi.org/v2/top-headlines?category=science-and-nature&language=en&apiKey=542354984a344ae4840697bae66404fd";

    private static final int NEWS_LOADER_ID = 7;
    private static final String LOG_TAG = BusinessFragment.class.getSimpleName();

    private ListView mArticleListView;

    private OnArticleLoadListener mOnArticleLoadListener;

    private ArticleAdapter mArticleAdapter;

    private ProgressBar mLoadingIndicator;

    private TextView mEmptyStateTextView;

    private Context mContext;

    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // Find the current Article that was clicked on
            Article currentArticle = mArticleAdapter.getItem(position);

            // Convert the String URL into a URI object (to pass into the Intent constructor)
            Uri articleUri = Uri.parse(currentArticle.getUrl());

            // Create a new intent to view the article URI
            Intent webisiteIntent = new Intent(Intent.ACTION_VIEW, articleUri);

            // Send the intent to launch a new activity
            startActivity(webisiteIntent);
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.news_list, container, false);

        mEmptyStateTextView = (TextView) rootView.findViewById(R.id.empty_view);

        mLoadingIndicator = (ProgressBar) rootView.findViewById(R.id.loading_indicator);

        mArticleListView = (ListView) rootView.findViewById(R.id.news_list);
        mArticleListView.setEmptyView(mEmptyStateTextView);

        mArticleAdapter = new ArticleAdapter(getContext(), new ArrayList<Article>());
        mArticleListView.setAdapter(mArticleAdapter);
        mArticleListView.setOnItemClickListener(mOnItemClickListener);

        mContext = getContext();


        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader.. Pass in the int ID constant defined above and pass in null for the bundle.
            // Pass in this activity for the LoaderCallbacks paramter (which is valid because this activity implement the LoaderCallbacks interface).
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);

        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            mLoadingIndicator.setVisibility(View.GONE);

            // Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);

        }

        return rootView;
    }

    @Override
    public Loader<List<Article>> onCreateLoader(int id, Bundle args) {

        // Show Loading Indicator
        mLoadingIndicator.setVisibility(View.VISIBLE);

        // Create a new loader for the given URL

        return new ArticleLoader(getContext(), NEWS_REQUEST_URL);

    }


    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> data) {

        // Hide Loading Indicator
        mLoadingIndicator.setVisibility(View.GONE);

        // Clear the adapter of previous article data
        mArticleAdapter.clear();

        // If there is a vlid list of {@link Article}s, then add them to the adapter's data set.
        // This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mArticleAdapter.addAll(data);
        } else {
            mEmptyStateTextView.setText(R.string.no_news);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        // Loader reset, so we can clear out our existing data.
        mArticleAdapter.clear();
    }

}
