package com.davidroid.wedding.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.davidroid.wedding.fragment.ConfirmationFragment;
import com.davidroid.wedding.fragment.DateFragment;
import com.davidroid.wedding.fragment.ContactFragment;
import com.davidroid.wedding.fragment.MapFragment;
import com.davidroid.wedding.fragment.MusicFragment;
import com.davidroid.weeding.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    private Tracker tracker;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initAnalyticsTracker();

        BottomNavigationView bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        fragmentManager = getSupportFragmentManager();
        fillFragment(new ContactFragment());

        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleBottomNavigationItemSelected(item);
                return true;
            }
        });
    }

    private void handleBottomNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contact:
                trackerView(ContactFragment.class.getName());
                fragment = new ContactFragment();
                break;
            case R.id.date:
                trackerView(DateFragment.class.getName());
                fragment = new DateFragment();
                break;
            case R.id.map:
                trackerView(MapFragment.class.getName());
                fragment = new MapFragment();
                break;
            case R.id.music:
                trackerView(MusicFragment.class.getName());
                fragment = new MusicFragment();
                break;
            case R.id.confirm:
                trackerView(ConfirmationFragment.class.getName());
                fragment = new ConfirmationFragment();
                break;
        }
        fillFragment(fragment);
    }

    private void fillFragment(Fragment fragment) {
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();
    }

    private void initAnalyticsTracker() {
        tracker = getDefaultTracker();
    }

    synchronized public Tracker getDefaultTracker() {
        if (tracker == null) {
            tracker = GoogleAnalytics.getInstance(this).newTracker(R.xml.global_tracker);
        }
        return tracker;
    }

    public void trackerView(String screenName) {
        if (tracker == null) {
            getDefaultTracker();
        }
        if (tracker != null) {
            tracker.setScreenName(screenName);
            tracker.send(new HitBuilders.AppViewBuilder().build());
        }
    }
}
