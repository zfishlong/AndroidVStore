package com.ilmare.androidvstore.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilmare.androidvstore.R;

/**
 * Created by zhangchenggeng
 * Time 5/7/2016 4:29 PM.
 * Descripton:
 * History:
 * 版权所有
 */
public class WelcomeFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         return inflater.inflate(R.layout.frame_welcome_two, null);
    }
}
