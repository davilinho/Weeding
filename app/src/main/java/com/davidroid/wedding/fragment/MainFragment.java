package com.davidroid.wedding.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidroid.weeding.R;

/**
 * Created by davidmartin on 5/12/16.
 */

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        Toolbar toolbar = ((Toolbar) view.findViewById(R.id.toolbar));
        ((TextView) toolbar.findViewById(R.id.text_toolbar)).setText("David y Sandra");
        return view;
    }
}
