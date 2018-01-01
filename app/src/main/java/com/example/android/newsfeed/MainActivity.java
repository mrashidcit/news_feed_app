package com.example.android.newsfeed;

import android.app.LoaderManager;
import android.content.Loader;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list);


        String publishAt = "2018-01-01T13:06:33+00:00";

        Date publishDate = null;
        SimpleDateFormat formatter;
        String output;
        long timeInMillis;
        long currentTimeInMillis;
        Time time;
        LocalTime localTime;

//        formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            publishDate = formatter.parse(publishAt);
            timeInMillis = publishDate.getTime();

//            Log.v(LOG_TAG, "Publish(Day, Month, Year)" + "(" +
//                    publishDate.getDate() + ", " +
//                    publishDate.getMonth() + ", " +
//                    publishDate.getYear() + ")"
//            );

            Calendar c = Calendar.getInstance();
            Date currentDate = c.getTime();

            if ( currentDate.getDay() == publishDate.getDay() &&
                currentDate.getMonth() == publishDate.getMonth() &&
                currentDate.getYear() == publishDate.getYear() ) {

                int publishHour = publishDate.getHours();
                int currentHour = currentDate.getHours();

                int hourDifference = currentHour - publishHour;

                Log.v(LOG_TAG, hourDifference + "h ago");

                Log.v(LOG_TAG, "publishHour : " + publishHour);
                Log.v(LOG_TAG, "currentHour : " + currentHour);
            }

            Log.v(LOG_TAG, "Current(Day, Month, Year)" + "(" +
                    currentDate.getDate() + ", " +
                    currentDate.getMonth() + ", " +
                    currentDate.getYear() + ")"
            );

            if (currentDate.equals(publishDate)){
                Log.v(LOG_TAG, "Compare : " + "Same");
            }

//            Log.v(LOG_TAG, "Compare : " + c.getTime());

            //            Log.v(LOG_TAG, "Current time : " + c.getTime());

//            localTime = new LocalTime(timeInMillis);

//            Long dateInMillies =  publishDate

            output = formatter.format(publishDate);
            Log.v(LOG_TAG, "Published At: " + output);
            Log.v(LOG_TAG, "Time: " + timeInMillis);

        } catch (ParseException e) {
            e.printStackTrace();
        }


//        Date today;
//        String output;
//        SimpleDateFormat formatter;
//
//        formatter = new SimpleDateFormat("EEE, MMM d, yyyy");
//        today = new Date();
//        output = formatter.format(today);
//        Log.v(LOG_TAG, "Today: " + output);


//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, new TopHeadlinesFragment())
//                .commit();


        mArticleListView = (ListView) findViewById(R.id.news_list);
        mArticleAdapter =
                new ArticleAdapter(this, new ArrayList<Article>());
        mArticleListView.setAdapter(mArticleAdapter);

        // Get a reference to the LoaderManager, in order to interact with loaders.
        LoaderManager loaderManager = getLoaderManager();

        // Initialize the loader.. Pass in the int ID constant defined above and pass in null for the bundle.
        // Pass in this activity for the LoaderCallbacks parameter (which is valid because this activity implements the LoaderCallbacks interface).
        loaderManager.initLoader(NEWS_LOADER_ID, null, this);

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

    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        // Loader reset, so we can clear out our existing data.
        mArticleAdapter.clear();
    }

}


















