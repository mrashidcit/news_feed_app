package com.example.android.newsfeed;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.newsfeed.NewsCategory.BusinessFragment;
import com.example.android.newsfeed.NewsCategory.EntertainmentFragment;
import com.example.android.newsfeed.NewsCategory.ScienceFragment;
import com.example.android.newsfeed.NewsCategory.SportsFragment;
import com.example.android.newsfeed.NewsCategory.TechnologyFragment;
import com.example.android.newsfeed.NewsCategory.TopStoriesFragment;
import com.example.android.newsfeed.NewsCategory.WorldFragment;

/**
 * Created by Rashid Saleem on 02-Jan-18.
 */

public class NewsCategoryAdapter extends FragmentPagerAdapter {

    // Context of the app
    private Context mContext;

    /**
     *
     * @param context
     * @param fm
     */
    public NewsCategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     *
     * @param position
     * @return {@link Fragment} that should be displayed for the give page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new BusinessFragment();
        } else if (position == 1) {
            return new WorldFragment();
        } else if (position == 2) {
            return new BusinessFragment();
        } else if (position == 3) {
            return new TechnologyFragment();
        } else if (position == 4) {
            return new EntertainmentFragment();
        } else if (position == 5) {
            return new SportsFragment();
        } else {
            return new ScienceFragment();
        }

    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
//            return mContext.getString(R.string.news_category_top_stories);
            return mContext.getString(R.string.news_category_business);
        } else if (position == 1) {
            return mContext.getString(R.string.news_category_world);

        } else if (position == 2) {
            return mContext.getString(R.string.news_category_business);
        } else if (position == 3) {
            return mContext.getString(R.string.news_category_technology);
        } else if (position == 4) {
            return mContext.getString(R.string.news_category_entertainment);
        } else if (position == 5) {
            return mContext.getString(R.string.news_category_sports);
        } else {
            return mContext.getString(R.string.news_category_science);
        }

    }
}
