package com.ilmare.androidvstore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.ilmare.androidvstore.Utils.AnimationController;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zhangchenggeng
 * Time 5/7/2016 3:39 PM.
 * Descripton:
 * History:
 * 版权所有
 */
public class SplashActivity extends AppCompatActivity {

    @InjectView(R.id.dl_iv_first_welcome)
    ImageView dlIvFirstWelcome;

    @InjectView(R.id.dl_iv_bearboy)
    ImageView dlIvBearboy;

    @InjectView(R.id.dl_iv_first_bear)
    ImageView dlIvFirstBear;


    private SharedPreferences sp;


    private Handler handler=new Handler(){

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);

        sp=getSharedPreferences("config", Context.MODE_PRIVATE);

        setAnimation();

        //三秒后进入
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sp.getBoolean("isFirstOpen",true)){

                    startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        },4000);

    }

    /**
     * 设置动画
     */
    private void setAnimation() {
        AnimationController.fadeIn(dlIvBearboy, 1000, 0);
        AnimationController.scaleIn(dlIvFirstBear, 1000, 1000);
        AnimationController.fadeIn(dlIvFirstWelcome, 1000, 2000);
    }




}
