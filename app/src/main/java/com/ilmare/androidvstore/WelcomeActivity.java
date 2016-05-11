package com.ilmare.androidvstore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ilmare.androidvstore.Fragment.WelcomeFragment1;
import com.ilmare.androidvstore.Fragment.WelcomeFragment2;
import com.ilmare.androidvstore.Fragment.WelcomeFragment3;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WelcomeActivity extends AppCompatActivity {

    @InjectView(R.id.viewPager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);

        viewPager.setAdapter(new WelcomeViewPager(getSupportFragmentManager()));
    }


    private class WelcomeViewPager extends FragmentStatePagerAdapter{
        List<Fragment> fragments=new ArrayList<>();
        public WelcomeViewPager(FragmentManager fm) {
            super(fm);
            fragments.add(new WelcomeFragment1());
            fragments.add(new WelcomeFragment2());
            fragments.add(new WelcomeFragment3());

        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }

}
