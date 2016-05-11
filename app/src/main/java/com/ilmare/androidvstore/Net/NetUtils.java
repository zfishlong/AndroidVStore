package com.ilmare.androidvstore.Net;

import android.os.Handler;
import android.os.Message;

import com.ilmare.androidvstore.Utils.VStoreApplication;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangchenggeng
 * Time 5/8/2016 2:27 PM.
 * Descripton:
 * History:
 * 版权所有
 */
public class NetUtils {

    public static ExecutorService executorService = Executors.newCachedThreadPool();

    public interface NetAccessListener {
        void onSeccuss(String  json);
        void onFailed(String error);
    }


    public static void getJson(final String url, final NetAccessListener netAccessListener) {

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        final String json=response.body().string();
                        VStoreApplication.activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                netAccessListener.onSeccuss(json);
                            }
                        });
                    }
                } catch (final IOException e) {
                    final Response finalResponse1 = response;
                    VStoreApplication.activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            netAccessListener.onFailed(e.toString());
                        }
                    });
                    e.printStackTrace();
                }
            }
        });

    }

}
