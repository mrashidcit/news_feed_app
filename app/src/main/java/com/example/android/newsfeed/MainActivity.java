package com.example.android.newsfeed;

import android.support.design.widget.TabLayout;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.android.newsfeed.data.Article;
import com.example.android.newsfeed.data.ArticleAdapter;
import com.example.android.newsfeed.data.ArticleLoader;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
                            implements LoaderManager.LoaderCallbacks<List<Article>> {


    private static final String NEWS_REQUEST_URL = "https://newsapi.org/v2/top-headlines?sources=bbc-news,google-news&language=en&apiKey=542354984a344ae4840697bae66404fd";

    private static final int NEWS_LOADER_ID = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    private ListView mArticleListView;

    private OnArticleLoadListener mOnArticleLoadListener;

    private ArticleAdapter mArticleAdapter;

    // view pager that will allow the user to swipe between fragments
    ViewPager viewPager;

    // tab layout that shows the tabs
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Create an adapter that knows which fragment should be shown on each page
        NewsCategoryAdapter adapter = new NewsCategoryAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that showns the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);


//        mArticleListView = (ListView) findViewById(R.id.news_list);
//        mArticleAdapter =
//                new ArticleAdapter(this, new ArrayList<Article>());
//        mArticleListView.setAdapter(mArticleAdapter);

        // Get a reference to the LoaderManager, in order to interact with loaders.
//        LoaderManager loaderManager = getLoaderManager();

        // Initialize the loader.. Pass in the int ID constant defined above and pass in null for the bundle.
        // Pass in this activity for the LoaderCallbacks parameter (which is valid because this activity implements the LoaderCallbacks interface).
//        loaderManager.initLoader(NEWS_LOADER_ID, null, this);

    }


    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        // Create a new loader for the given URL

        return new ArticleLoader(this, NEWS_REQUEST_URL);
//        return new Loader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> data) {
        // Clear the adapter of previous article data
        mArticleAdapter.clear();

        // If there is a valid list of {@link Article}s, then add them to the adapter's data set.
        // This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mArticleAdapter.addAll(data);
        }
    }

// @Override
//    public void onLoadFinished(Loader<List<Article>> loader, List<Article> data) {
//
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

    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        // Loader reset, so we can clear out our existing data.
        mArticleAdapter.clear();
    }

}


















