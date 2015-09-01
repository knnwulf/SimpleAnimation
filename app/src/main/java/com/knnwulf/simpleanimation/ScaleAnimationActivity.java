package com.knnwulf.simpleanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

public class ScaleAnimationActivity extends AppCompatActivity {

    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_animation);

        Button mShowContainer = (Button) findViewById(R.id.show_container);
        Button mHideContainer = (Button) findViewById(R.id.hide_container);
        mContainer = (LinearLayout) findViewById(R.id.container);

        mShowContainer.setOnClickListener(showFromTop);
        mHideContainer.setOnClickListener(showFromBottom);
        mContainer.setVisibility(View.INVISIBLE);
    }

    private View.OnClickListener showFromTop = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showAnimation(v.getLeft(), v.getTop(), v.getHeight());
        }
    };

    private View.OnClickListener showFromBottom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showAnimation(v.getLeft(), v.getTop(), v.getHeight());
        }
    };

    /**
     * Animate the layout from the center of clicked button to the layout position
     * @param fromX The X coordinate to start the translate animation
     * @param fromY The Y coordinate to start the translate animation
     * @param height Height of button clicked
     */
    private void showAnimation(float fromX, float fromY, int height) {
        float newFromY = -mContainer.getTop() + fromY + (height / 2);

        Animation scale = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        Animation translate = new TranslateAnimation(fromX, 0, newFromY, 0);
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(scale);
        set.addAnimation(translate);
        set.setFillBefore(false);
        set.setDuration(700);

        mContainer.setVisibility(View.VISIBLE);
        mContainer.startAnimation(set);
    }
}
