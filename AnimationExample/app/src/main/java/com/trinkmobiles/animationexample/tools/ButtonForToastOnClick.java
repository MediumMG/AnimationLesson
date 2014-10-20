package com.trinkmobiles.animationexample.tools;

import android.view.View;
import android.widget.Toast;

/**
 * Created by MediumMG on 17.10.2014.
 */
public class ButtonForToastOnClick implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "OnClick", Toast.LENGTH_SHORT).show();
    }
}
