package com.ilmare.androidvstore.UIManager;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ilmare.androidvstore.MainActivity;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.Utils.ConstantValue;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zhangchenggeng
 * Time 5/7/2016 8:41 PM.
 * Descripton:
 * History:
 * 版权所有
 */
public class BottomBarManager implements View.OnClickListener, Observer {


    ImageView imgHome;
    ImageView imgClassify;
    ImageView imgSearch;
    ImageView imgShoppingCar;
    ImageView imgMore;
    LinearLayout iiBottomCommon;


    private MainActivity activity;

    //单列模式
    private static BottomBarManager bottomBarManager = new BottomBarManager();

    private BottomBarManager() {

    }

    public static BottomBarManager getInstance() {
        return bottomBarManager;

    }


    public void initView(MainActivity activity) {
        this.activity = activity;

        imgHome= (ImageView) activity.findViewById(R.id.imgHome);
        imgClassify= (ImageView) activity.findViewById(R.id.imgClassify);
        imgSearch= (ImageView) activity.findViewById(R.id.imgSearch);
        imgShoppingCar= (ImageView) activity.findViewById(R.id.imgShoppingCar);
        imgMore= (ImageView) activity.findViewById(R.id.imgMore);
        iiBottomCommon= (LinearLayout) activity.findViewById(R.id.ii_bottom_common);


        imgMore.setOnClickListener(this);
        imgShoppingCar.setOnClickListener(this);
        imgSearch.setOnClickListener(this);
        imgClassify.setOnClickListener(this);
        imgHome.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        initBottom();
        switch (v.getId()){
            case R.id.imgHome:   //首页的点击事件
                imgHome.setImageResource(R.mipmap.bar_home_selected);
                MiddleViewManager.getInstance().changeView(ConstantValue.VIEW_HOME);
                break;
            case R.id.imgClassify: //分类点击事件
                imgClassify.setImageResource(R.mipmap.bar_class_selected);
                MiddleViewManager.getInstance().changeView(ConstantValue.VIEW_BRAND);
                break;
            case R.id.imgMore:  //更多点击事件
                imgMore.setImageResource(R.mipmap.bar_more_selected);
                MiddleViewManager.getInstance().changeView(ConstantValue.VIEW_MYCOUNT);
                break;
            case R.id.imgSearch: //搜索查询事件
                imgSearch.setImageResource(R.mipmap.bar_search_selected);
                MiddleViewManager.getInstance().changeView(ConstantValue.VIEW_SEARCH);
                break;
            case R.id.imgShoppingCar:  //购物车点击事件
                imgShoppingCar.setImageResource(R.mipmap.bar_shopping_selected);

                File file=new File(activity.getCacheDir(), "a.txt");

                if(!file.exists()){
                    MiddleViewManager.getInstance().changeView(ConstantValue.VIEW_SHOPPINGCART_NODATA);
                }else{
                    MiddleViewManager.getInstance().changeView(ConstantValue.VIEW_SHOPPINGCART);
                }



                break;
        }


    }


    /**
     * 设置是否显示底部布局
     */
    public void setShowFoot(boolean isShowFoot) {
        if (isShowFoot) {
            iiBottomCommon.setVisibility(View.VISIBLE);
        } else {
            iiBottomCommon.setVisibility(View.GONE);
        }
    }

    /**
     * 初始化底部导航栏
     */
    private void initBottom() {
        imgHome.setImageResource(R.mipmap.bar_home_normal);
        imgSearch.setImageResource(R.mipmap.bar_search_normal);
        imgClassify.setImageResource(R.mipmap.bar_class_normal);
        imgShoppingCar.setImageResource(R.mipmap.bar_shopping_normal);
        imgMore.setImageResource(R.mipmap.bar_more_normal);
    }



    @Override
    public void update(Observable observable, Object data) {

    }


}
