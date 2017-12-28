package com.example.android.newsfeed;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.newsfeed.data.Article;
import com.example.android.newsfeed.data.ArticleAdapter;
import com.example.android.newsfeed.data.ArticleLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashid Saleem on 26-Dec-17.
 */

//public class TopHeadlinesFragment extends Fragment
//                         implements android.support.v4.app.LoaderManager.LoaderCallbacks<List<Article>> {

    public class TopHeadlinesFragment extends Fragment
                        implements OnArticleLoadListener
{

    private static final String NEWS_REQUEST_URL = "https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=542354984a344ae4840697bae66404fd";

    private static final int NEWS_LOADER_ID = 3;

    private ListView mArticleListView;

    private ArticleAdapter mArticleAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        LoaderManager loaderManager = this.getLoaderManager();

        // Initialize the loader.. Pass in the int ID constant defined above and pass in null for the bundle.
        // Pass in this activity for the LoaderCallbacks parameter (which is valid because this activity implements the LoaderCallbacks interface).
//        loaderManager.initLoader(NEWS_LOADER_ID, null, (LoaderManager.LoaderCallbacks<Object>) getContext());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.news_list, container, false);

//        mArticleListView = (ListView) rootView.findViewById(R.id.news_list);
//        mArticleAdapter =
//                new ArticleAdapter(container.getContext(), new ArrayList<Article>());
//        mArticleListView.setAdapter(mArticleAdapter);
//
//        // Get a reference to the LoaderManager, in order to interact with loaders.
//        LoaderManager loaderManager = this.getLoaderManager();
//
//        // Initialize the loader.. Pass in the int ID constant defined above and pass in null for the bundle.
//        // Pass in this activity for the LoaderCallbacks parameter (which is valid because this activity implements the LoaderCallbacks interface).
//        loaderManager.initLoader(NEWS_LOADER_ID, null, (LoaderManager.LoaderCallbacks<Object>) container.getContext());


        return rootView;
    }

    @Override
    public void onArticleLoaded(String str) {

        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();

    }


//    @Override
//    public android.support.v4.content.Loader onCreateLoader(int id, Bundle args) {
//        // Create a new loader for the given URL
//
////        return new ArticleLoader(getActivity(), NEWS_REQUEST_URL);
//
//        return new ArticleLoader(getActivity(), NEWS_REQUEST_URL);
//    }
//
//    @Override
//    public void onLoadFinished(android.support.v4.content.Loader<List<Article>> loader, List<Article> data) {
//        // Clear the adapter of previous article data
//        mArticleAdapter.clear();
//
//        // If there is a valid list of {@link Article}s, then add them to the adapter's data set.
//        // This will trigger the ListView to update.
//        if (data != null && !data.isEmpty()) {
//            mArticleAdapter.addAll(data);
//        }
//
//    }
//
//    @Override
//    public void onLoaderReset(android.support.v4.content.Loader<List<Article>> loader) {
//        // Loader reset, so we can clear out our existing data.
//        mArticleAdapter.clear();
//    }


}
