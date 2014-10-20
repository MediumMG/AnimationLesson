package com.trinkmobiles.animationexample.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.trinkmobiles.animationexample.R;
import com.trinkmobiles.animationexample.tools.CounterAnimation;


/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class ViewFragment extends Fragment {

    private Button btnAlpha, btnScale, btnRotate, btnTranslate, btnSet;
    private TextView txtCustom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view, container, false);

        btnAlpha = (Button) rootView.findViewById(R.id.fragment_view_alpha);
        btnScale = (Button) rootView.findViewById(R.id.fragment_view_scale);
        btnRotate = (Button) rootView.findViewById(R.id.fragment_view_rotate);
        btnTranslate = (Button) rootView.findViewById(R.id.fragment_view_translate);
        btnSet = (Button) rootView.findViewById(R.id.fragment_view_set);
        txtCustom = (TextView) rootView.findViewById(R.id.fragment_view_custom);

//        TranslateAnimation translateAnimation = new TranslateAnimation(
//                Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 1.5f,
//                Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0);
//        translateAnimation.setDuration(1000);
//        translateAnimation.setInterpolator(new LinearInterpolator());

        btnAlpha.setOnClickListener(new ViewOnClick(R.anim.alpha_animation_example));
        btnScale.setOnClickListener(new ViewOnClick(R.anim.scale_animation_example));
        btnRotate.setOnClickListener(new ViewOnClick(R.anim.rotate_animation_example));
        btnTranslate.setOnClickListener(new ViewOnClick(R.anim.translate_animation_example));
        btnSet.setOnClickListener(new ViewOnClick(R.anim.set_animation_example));

        Animation animation = new CounterAnimation(txtCustom, 0, 199);
        animation.setDuration(1500);
        txtCustom.setOnClickListener(new ViewOnClick(animation));

        return rootView;
    }

    private class ViewOnClick implements View.OnClickListener {

        private Animation mAnimation;

        public ViewOnClick(int animResID) {
            mAnimation = AnimationUtils.loadAnimation(getActivity(), animResID);
        }

        public ViewOnClick(Animation animation) {
            mAnimation = animation;
        }

        @Override
        public void onClick(View v) {
            v.startAnimation(mAnimation);
        }
    }




}
