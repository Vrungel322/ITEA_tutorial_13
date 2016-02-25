package com.nanddgroup.tutorial13;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.nanddgroup.tutorial13.Fragments.AuthFragment;

public class MainActivity extends AppCompatActivity {
    private boolean animated;
    public static  boolean onBackPressed;
    private CoordinatorLayout rootView;
    public static FloatingActionButton fabAdd;
    public static FloatingActionButton fabClearAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabClearAll = (FloatingActionButton) findViewById(R.id.fabClearAll);
        fabAdd.setVisibility(View.GONE);
        fabClearAll.setVisibility(View.GONE);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            AuthFragment af = new AuthFragment();
            ft.add(R.id.container, af);
            ft.commit();
        rootView = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        animated = false;
        onBackPressed = false;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!animated) {
            animationEnter();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void animationEnter() {
        animated = true;
        int cx = (rootView.getLeft() + rootView.getRight()) / 2;
        int cy = (rootView.getTop() + rootView.getBottom()) / 2;
        int finalRadius = Math.max(rootView.getWidth(), rootView.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(rootView, cx, cy, 0, finalRadius);
        anim.setDuration(1000);
        anim.start();
    }

    @Override
    public void onBackPressed() {
        if (onBackPressed == true) {
            fabClearAll.setVisibility(View.GONE);
            fabAdd.setVisibility(View.GONE);
            animationEnter();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            AuthFragment af = new AuthFragment();
            ft.replace(R.id.container, af, "AuthFragmentIsOn");
            ft.commit();
            onBackPressed = false;
        } else {
            onBackPressed = false;
            super.onBackPressed();
            finish();
        }

    }
}
