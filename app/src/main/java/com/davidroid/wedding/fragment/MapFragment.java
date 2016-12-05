package com.davidroid.wedding.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidroid.weeding.R;

import java.util.Locale;

/**
 * Created by david on 27/11/16.
 */

@SuppressWarnings("ALL")
public class MapFragment extends Fragment {

    private CardView mapAjuntament;
    private CardView mapRestaurant;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_fragment, container, false);
        android.support.v7.widget.Toolbar toolbar = ((android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar));
        ((TextView) toolbar.findViewById(R.id.text_toolbar)).setText("Ubicaciones y cómo llegar");

        mapAjuntament = (CardView) view.findViewById(R.id.map_ajuntament);
        mapRestaurant = (CardView) view.findViewById(R.id.map_restaurant);

        mapAjuntament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.getDefault(), "google.navigation:q=Raval de Monsterrat, 14, 08221, Terrassa");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                getActivity().startActivity(intent);
            }
        });

        mapRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.getDefault(), "google.navigation:q=N-150, 15, 08227 Terrassa, Barcelona");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                getActivity().startActivity(intent);
            }
        });

        return view;
    }
}
