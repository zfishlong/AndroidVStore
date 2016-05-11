package com.ilmare.androidvstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ilmare.androidvstore.UIManager.BottomBarManager;
import com.ilmare.androidvstore.UIManager.MiddleViewManager;
import com.ilmare.androidvstore.UIManager.TitleBarManager;
import com.ilmare.androidvstore.Utils.ConstantValue;
import com.ilmare.androidvstore.Utils.VStoreApplication;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        VStoreApplication.activity = this;

        MiddleViewManager.getInstance().initView(this);
        BottomBarManager.getInstance().initView(this);
        TitleBarManager.getInstance().initView(this);

        MiddleViewManager.getInstance().addObserver(TitleBarManager.getInstance());

        MiddleViewManager.getInstance().changeView(ConstantValue.VIEW_HOME);


    }

    private long lastMillions;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        long currentMillion=System.currentTimeMillis();
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            boolean result = MiddleViewManager.getInstance().goBack();
            if (!result) {

                if(currentMillion-lastMillions>2000){
                    Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                    lastMillions = currentMillion;
                }else{
                   System.exit(0);
                }
            }
            return false;
        }
        return false;
    }


}

