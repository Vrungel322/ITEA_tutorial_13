package com.nanddgroup.tutorial13.Fragments;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.nanddgroup.tutorial13.Fragments.FriendListFragment;
import com.nanddgroup.tutorial13.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoadingFragment extends Fragment {


    private View rootView;

    public LoadingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_loading, container, false);
        clockwise();
        return rootView;
    }

    public void clockwise(){
        TextView image = (TextView)rootView.findViewById(R.id.tvLoading);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.myanimation);
        image.startAnimation(animation);
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("TAG", "OnTick");

            }

            @Override
            public void onFinish() {
                FriendListFragment flf = new FriendListFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, flf);
                fragmentTransaction.addToBackStack("LoadingFragment");
                fragmentTransaction.commit();
            }
        }.start();
    }
}
