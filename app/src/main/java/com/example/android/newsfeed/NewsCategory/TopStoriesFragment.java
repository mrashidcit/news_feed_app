package com.example.android.newsfeed.NewsCategory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.newsfeed.R;

/**
 * Created by Rashid Saleem on 26-Dec-17.
 */

public class TopStoriesFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.news_list, container, false);

        TextView sampleView = (TextView) rootView.findViewById(R.id.tvSample);

        sampleView.setText("Top Stories");

        return rootView;
    }
}











