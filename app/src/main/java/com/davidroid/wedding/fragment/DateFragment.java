package com.davidroid.wedding.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidroid.weeding.R;

/**
 * Created by david on 27/11/16.
 */

@SuppressWarnings("ALL")
public class DateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_fragmen, container, false);
        android.support.v7.widget.Toolbar toolbar = ((android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar));
        ((TextView) toolbar.findViewById(R.id.text_toolbar)).setText("Fecha y hora");

        return view;
    }
}
