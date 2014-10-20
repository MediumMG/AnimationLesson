package com.trinkmobiles.animationexample.tools;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

/**
 * Created by MediumMG on 17.10.2014.
 */
public class CounterAnimation extends Animation {

    private TextView txtTarget;
    private int mFromValue = 0;
    private int mToValue = 100;

    public CounterAnimation(TextView view) {
        super();

        this.txtTarget = view;
    }

    public CounterAnimation(TextView view, int fromValue, int toValue) {
        this(view);
        this.mFromValue = fromValue;
        this.mToValue = toValue;
    }


    public void setToValue(int mToValue) {
        this.mToValue = mToValue;
    }

    public void setFromValue(int mFromValue) {
        this.mFromValue = mFromValue;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        int value = (int) ((mToValue - mFromValue) * interpolatedTime);
        txtTarget.setText(String.valueOf(value));
    }
}
