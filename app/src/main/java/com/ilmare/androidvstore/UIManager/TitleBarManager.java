package com.ilmare.androidvstore.UIManager;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ilmare.androidvstore.MainActivity;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.Utils.ConstantValue;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by zhangchenggeng
 * Time 5/7/2016 9:21 PM.
 * Descripton:
 * History:
 * 版权所有
 */
public class TitleBarManager implements Observer {

    // EditText dlHomeSearchTitleEd;
//    ImageView dlIvTitleQrcode;
    EditText dlSearchTitleEd;
    ImageView dlSearchMyTitleImg;
    ImageView dlIvTitleSearchDelete;
    ImageView dlIvLeft;
    TextView tvAlert;
    ImageView dlIvRigth;
    TextView shoppingCartTitleTv;


    LinearLayout shoppingCartDeleteLayout;
    LinearLayout irShoppingTitle;  //购物车头信息
    LinearLayout dlRlSearchTitle; //查询标题
    LinearLayout irCommonTitle;   //通用标题
    LinearLayout idShoppingCartGoback;//增加购物车头功能

    LinearLayout dlRlHomeTitle;   //首页标题

    private MainActivity activity;

    private static TitleBarManager titleManager = new TitleBarManager();

    private TitleBarManager() {

    }

    public static TitleBarManager getInstance() {
        return titleManager;
    }


    public void initView(MainActivity activity) {

        this.activity = activity;

        dlRlHomeTitle = (LinearLayout) activity.findViewById(R.id.dl_rl_home_title);
        dlRlSearchTitle = (LinearLayout) activity.findViewById(R.id.dl_rl_search_title);
        irCommonTitle = (LinearLayout) activity.findViewById(R.id.ir_common_title);

        // 购物车头信息 fun 2014-04-17 14:13:33
        irShoppingTitle = (LinearLayout) activity.findViewById(R.id.ir_shopping_title);
        shoppingCartDeleteLayout = (LinearLayout) activity.findViewById(R.id.shopping_cart_delete_layout);

        // 增加购物车头功能 fun 2014-04-18 17:24:24
        idShoppingCartGoback = (LinearLayout) activity.findViewById(R.id.id_shopping_cart_goback);
        shoppingCartTitleTv = (TextView) activity.findViewById(R.id.shopping_cart_title_tv);


        tvAlert = (TextView) irCommonTitle.findViewById(R.id.tv_alert);
        dlIvTitleSearchDelete = (ImageView) activity.findViewById(R.id.dl_iv_title_search_delete);
        dlIvLeft = (ImageView) irCommonTitle.findViewById(R.id.dl_iv_left);
        dlIvRigth = (ImageView) irCommonTitle.findViewById(R.id.dl_iv_rigth);
        dlSearchTitleEd = (EditText) activity.findViewById(R.id.dl_search_title_ed);
        dlSearchMyTitleImg = (ImageView) activity.findViewById(R.id.dl_search_my_title_img);

        showHomeTitle();
    }

    /**
     * 显示首页的Title标题
     */
    public void showHomeTitle() {
        initTitle();
        dlRlHomeTitle.setVisibility(View.VISIBLE);
    }

    /**
     * 显示首页的Title标题
     */
    public void showCommonTitle(String title) {
        initTitle();
        irCommonTitle.setVisibility(View.VISIBLE);
        tvAlert.setText(title);
    }

    /**
     * 显示搜索的Title
     */
    public void showSearchTitle() {
        initTitle();
        dlRlSearchTitle.setVisibility(View.VISIBLE);
    }

    /**
     * 初始化头部标签
     */
    private void initTitle() {
        dlRlHomeTitle.setVisibility(View.GONE);
        dlRlSearchTitle.setVisibility(View.GONE);
        irCommonTitle.setVisibility(View.GONE);
        // 隐藏购物车标题 fun 2014-04-17 14:14:19
        irShoppingTitle.setVisibility(View.GONE);
    }


    @Override
    public void update(Observable observable, Object data) {
        if (data != null) {
            int ViewID = Integer.parseInt(data.toString());
            switch (ViewID) {
                case ConstantValue.VIEW_HOME:  //切换到主界面
                    showHomeTitle();
                    break;
                case ConstantValue.VIEW_BRAND:  //品牌分类
                    showCommonTitle("商品分类");
                    break;
                case ConstantValue.VIEW_SHOPPINGCART: //购物车
                    showCommonTitle("购物车");
                    break;
                case ConstantValue.VIEW_SEARCH: //查找
                    showCommonTitle("搜索");
                    break;
                case ConstantValue.VIEW_MYCOUNT: //关于界面
                    showCommonTitle("我的信息");
                    break;
                case ConstantValue.ACCOUNT_VIEW:
                    showCommonTitle("我的信息");
                    break;
                case ConstantValue.LOGIN_VIEW:
                    showCommonTitle("登录");
                    break;
                case ConstantValue.PRODUCT_LIST_VIEW:
                    showCommonTitle("商品列表");
                    break;
                case ConstantValue.PRODUCT_DETAIL_VIEW:
                    showCommonTitle("商品信息");
                    break;
            }
        }
    }
}
