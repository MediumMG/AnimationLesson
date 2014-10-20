package com.trinkmobiles.animationexample.fragments;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.trinkmobiles.animationexample.R;


/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class PropertyFragment extends Fragment {

    private Button btnAlpha, btnScale, btnRotate, btnTranslate, btnSet;
    private TextView txtCustom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_property, container, false);

        btnAlpha = (Button) rootView.findViewById(R.id.fragment_property_alpha);
        btnScale = (Button) rootView.findViewById(R.id.fragment_property_scale);
        btnRotate = (Button) rootView.findViewById(R.id.fragment_property_rotate);
        btnTranslate = (Button) rootView.findViewById(R.id.fragment_property_translate);
        btnSet = (Button) rootView.findViewById(R.id.fragment_property_set);

        ObjectAnimator translateAnimation = ObjectAnimator.ofFloat(btnTranslate, "translationX", 0, 300);
        translateAnimation.setDuration(1000);

        btnAlpha.setOnClickListener(new ViewOnClick(R.animator.alpha_animator_example));
        btnScale.setOnClickListener(new ViewOnClick(R.animator.scale_animator_example));
        btnRotate.setOnClickListener(null);
        btnTranslate.setOnClickListener(new ViewOnClick(R.animator.translate_animator_example));
//        btnTranslate.setOnClickListener(new ViewOnClick(translateAnimation));

        btnSet.setOnClickListener(new ViewOnClick(R.animator.set_animator_example));

        return rootView;
    }

    private class ViewOnClick implements View.OnClickListener {

        private Animator mAnimator;

        public ViewOnClick(int animResID) {
            mAnimator = AnimatorInflater.loadAnimator(getActivity(), animResID);
        }

        public ViewOnClick(Animator animator) {
            mAnimator = animator;
        }

        @Override
        public void onClick(View v) {
            mAnimator.setTarget(v);
            mAnimator.start();
        }
    }



}
