package com.trinkmobiles.animationexample.fragments;


import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.trinkmobiles.animationexample.R;


/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class DrawableFragment extends Fragment {

    private ImageView ivSound;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drawable, container, false);
        ivSound = (ImageView) rootView.findViewById(R.id.fragment_drawable_sound);

        ivSound.setOnClickListener(new SoundOnClick());

        return rootView;
    }


    private class SoundOnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v instanceof ImageView) {
                if (((ImageView) v).getDrawable() instanceof AnimationDrawable) {
                    AnimationDrawable drawable = (AnimationDrawable) ((ImageView) v).getDrawable();

                    if (drawable.isRunning())
                        drawable.stop();
                    else
                        drawable.start();
                }
            }
        }
    }

}
