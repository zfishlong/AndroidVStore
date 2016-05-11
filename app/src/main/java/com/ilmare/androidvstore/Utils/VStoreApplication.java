package com.ilmare.androidvstore.Utils;

import android.app.Application;
import android.content.Context;

import com.ilmare.androidvstore.MainActivity;

/**
 * Created by zhangchenggeng
 * Time 5/8/2016 3:06 PM.
 * Descripton:
 * History:
 * 版权所有
 */
public class VStoreApplication extends Application {

    public static Context context;
    public static MainActivity activity=null;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }



}
