package com.trinkmobiles.animationexample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.trinkmobiles.animationexample.fragments.DrawableFragment;
import com.trinkmobiles.animationexample.fragments.PropertyFragment;
import com.trinkmobiles.animationexample.fragments.ViewFragment;

public class MainActivity extends Activity {

    public final String LOG_TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();

        ActionBar.Tab tabV = actionBar.newTab();
        tabV.setText(R.string.view);
        tabV.setTabListener(new AppTabListener(new ViewFragment()));
        actionBar.addTab(tabV);

        ActionBar.Tab tabP = actionBar.newTab();
        tabP.setText(R.string.property);
        tabP.setTabListener(new AppTabListener(new PropertyFragment()));
        actionBar.addTab(tabP);

        ActionBar.Tab tabD = actionBar.newTab();
        tabD.setText(R.string.drawable);
        tabD.setTabListener(new AppTabListener(new DrawableFragment()));
        actionBar.addTab(tabD);
    }


    private class AppTabListener implements ActionBar.TabListener {

        public Fragment fragment;

        public AppTabListener(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) { }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.fragment_container, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }

    }

}
