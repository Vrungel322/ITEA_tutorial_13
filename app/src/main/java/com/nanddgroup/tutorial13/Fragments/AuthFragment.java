package com.nanddgroup.tutorial13.Fragments;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.nanddgroup.tutorial13.MainActivity;
import com.nanddgroup.tutorial13.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AuthFragment extends Fragment {
    private static final long ANIM_DURATION = 1000;
    private View rootView;
    private Activity activity;
    private Button bLogIn;
    private EditText etEmail;
    private EditText etPassword;

    public AuthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_auth, container, false);
        bLogIn = (Button) rootView.findViewById(R.id.bLogIn);
        bLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                LoadingFragment lf = new LoadingFragment();
                fragmentTransaction.replace(R.id.container, lf);
                fragmentTransaction.addToBackStack("AuthFragment");
                fragmentTransaction.commit();
                MainActivity.onBackPressed = true;

            }
        });
        etEmail = (EditText) rootView.findViewById(R.id.etEmail);
        etPassword = (EditText) rootView.findViewById(R.id.etPassword);
        //TODO check input
        return rootView;
    }
}
