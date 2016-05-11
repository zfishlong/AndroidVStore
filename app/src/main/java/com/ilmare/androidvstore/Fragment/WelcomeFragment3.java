package com.ilmare.androidvstore.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ilmare.androidvstore.MainActivity;
import com.ilmare.androidvstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class WelcomeFragment3 extends Fragment {

    @InjectView(R.id.enter_homePage)
    Button enterHomePage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_welcome_three, null);
        ButterKnife.inject(this, view);

        enterHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();

                getActivity()
                        .getSharedPreferences("config",Context.MODE_PRIVATE)
                        .edit()
                        .putBoolean("isFirstOpen",false)
                        .commit();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
