package com.knnwulf.simpleanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mShowContainer = (Button) findViewById(R.id.show_container);
        Button mHideContainer = (Button) findViewById(R.id.hide_container);
        mContainer = (LinearLayout) findViewById(R.id.container);

        mShowContainer.setOnClickListener(showContainer);
        mHideContainer.setOnClickListener(hideContainer);
        mContainer.setVisibility(View.GONE);
    }

    private View.OnClickListener showContainer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mContainer.getVisibility() == View.GONE) {
                showContainer(true);
            }
        }
    };

    private View.OnClickListener hideContainer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mContainer.getVisibility() == View.VISIBLE) {
                showContainer(false);
            }
        }
    };

    private void showContainer(boolean show) {
        Animation animation;

        if (show) {
            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT, 0.0f,
                    Animation.RELATIVE_TO_PARENT, 0.0f,
                    Animation.RELATIVE_TO_PARENT, 1.0f,
                    Animation.RELATIVE_TO_PARENT, 0.0f);
            mContainer.setVisibility(View.VISIBLE);
        } else {
            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT, 0.0f,
                    Animation.RELATIVE_TO_PARENT, 0.0f,
                    Animation.RELATIVE_TO_PARENT, 0.0f,
                    Animation.RELATIVE_TO_PARENT, 1.0f);
            mContainer.setVisibility(View.GONE);
        }

        animation.setDuration(500);
        mContainer.startAnimation(animation);
    }

}
