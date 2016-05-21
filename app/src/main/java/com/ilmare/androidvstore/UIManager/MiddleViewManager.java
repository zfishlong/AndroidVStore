package com.ilmare.androidvstore.UIManager;

import android.view.View;
import android.widget.RelativeLayout;

import com.ilmare.androidvstore.Domain.ProductList;
import com.ilmare.androidvstore.MainActivity;
import com.ilmare.androidvstore.MiddleViews.AccountView;
import com.ilmare.androidvstore.MiddleViews.CategoryView;
import com.ilmare.androidvstore.MiddleViews.HomeViews;
import com.ilmare.androidvstore.MiddleViews.LoginView;
import com.ilmare.androidvstore.MiddleViews.MoreView;
import com.ilmare.androidvstore.MiddleViews.MyOrderView;
import com.ilmare.androidvstore.MiddleViews.ProductDetailView;
import com.ilmare.androidvstore.MiddleViews.ProductListView;
import com.ilmare.androidvstore.MiddleViews.RegistView;
import com.ilmare.androidvstore.MiddleViews.SearchView;
import com.ilmare.androidvstore.MiddleViews.ShopingCarDatasView;
import com.ilmare.androidvstore.MiddleViews.ShopingCarNoDataView;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.Utils.ConstantValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Created by zhangchenggeng
 * Time 5/7/2016 11:05 PM.
 * Descripton:
 * History:
 * 版权所有
 */

public class MiddleViewManager extends Observable {


    private MainActivity activity;

    private RelativeLayout dlRlMiddle;

    private Map<Integer, View> viewMap = new HashMap<>();

    private static AppStackManager appStackManager;
    private static MiddleViewManager middleViewManager = new MiddleViewManager();


    private Object dataToNextView;

    public int CURRENTTAG=0;

    public void setDataToNextView(Object dataToNextView) {
        this.dataToNextView = dataToNextView;
    }

    private MiddleViewManager() {

    }

    public static MiddleViewManager getInstance() {
        appStackManager=AppStackManager.getInstance();
        return middleViewManager;
    }

    public void initView(MainActivity activity) {
        this.activity = activity;
        dlRlMiddle = (RelativeLayout) activity.findViewById(R.id.dl_rl_middle);
    }


    public void changeView(int viewID) {
        dlRlMiddle.removeAllViews();

        if (viewMap.get(viewID) == null) {
            switch (viewID) {
                case ConstantValue.VIEW_HOME:  //切换到主界面

                    HomeViews homeViews = new HomeViews(activity);
                    homeViews.getRootView().setTag(ConstantValue.VIEW_HOME);
                    dlRlMiddle.addView(homeViews.getRootView());
                    viewMap.put(ConstantValue.VIEW_HOME, homeViews.getRootView());
                    appStackManager.addStack(homeViews.getRootView());
                    break;

                case ConstantValue.VIEW_BRAND:  //品牌分类
                    CategoryView categoryView = new CategoryView(activity);
                    categoryView.getRootView().setTag(ConstantValue.VIEW_BRAND);
                    dlRlMiddle.addView(categoryView.getRootView());
                    viewMap.put(ConstantValue.VIEW_BRAND, categoryView.getRootView());
                    appStackManager.addStack(categoryView.getRootView());
                    break;

                case ConstantValue.VIEW_SHOPPINGCART_NODATA: //购物车
                    ShopingCarNoDataView shopingCarNoDataView=new ShopingCarNoDataView(activity);
                    shopingCarNoDataView.getRootView().setTag(ConstantValue.VIEW_SHOPPINGCART_NODATA);
                    dlRlMiddle.addView(shopingCarNoDataView.getRootView());
                    viewMap.put(ConstantValue.VIEW_SHOPPINGCART_NODATA, shopingCarNoDataView.getRootView());
                    appStackManager.addStack(shopingCarNoDataView.getRootView());
                    break;

                case ConstantValue.VIEW_SEARCH: //查找
                    SearchView searchView=new SearchView(activity);
                    searchView.getRootView().setTag(ConstantValue.VIEW_SEARCH);
                    dlRlMiddle.addView(searchView.getRootView());
                    viewMap.put(ConstantValue.VIEW_SEARCH, searchView.getRootView());
                    appStackManager.addStack(searchView.getRootView());
                    break;

                case ConstantValue.VIEW_MYCOUNT: //关于界面
                    MoreView moreView = new MoreView(activity);
                    moreView.getRootView().setTag(ConstantValue.VIEW_MYCOUNT);
                    dlRlMiddle.addView(moreView.getRootView());
                    viewMap.put(ConstantValue.VIEW_MYCOUNT, moreView.getRootView());
                    appStackManager.addStack(moreView.getRootView());
                    break;

                case ConstantValue.LOGIN_VIEW:   //登录界面
                    LoginView loginView=new LoginView(activity);
                    loginView.getRootView().setTag(ConstantValue.LOGIN_VIEW);
                    dlRlMiddle.addView(loginView.getRootView());
                    viewMap.put(ConstantValue.LOGIN_VIEW, loginView.getRootView());
                    appStackManager.addStack(loginView.getRootView());
                    break;

                case ConstantValue.ACCOUNT_VIEW: //账户界面
                    AccountView accountView=new AccountView(activity);
                    accountView.getRootView().setTag(ConstantValue.ACCOUNT_VIEW);
                    dlRlMiddle.addView(accountView.getRootView());
                    viewMap.put(ConstantValue.ACCOUNT_VIEW, accountView.getRootView());
                    appStackManager.addStack(accountView.getRootView());
                    break;

                case ConstantValue.PRODUCT_LIST_VIEW:
                    ProductListView productListView=new ProductListView(activity);
                    productListView.getRootView().setTag(ConstantValue.PRODUCT_LIST_VIEW);
                    dlRlMiddle.addView(productListView.getRootView());
                    viewMap.put(ConstantValue.PRODUCT_LIST_VIEW, productListView.getRootView());
                    appStackManager.addStack(productListView.getRootView());
                    break;
                case ConstantValue.PRODUCT_DETAIL_VIEW:
                    ProductDetailView productDetailView=new ProductDetailView(activity);
                    productDetailView.getRootView().setTag(ConstantValue.PRODUCT_DETAIL_VIEW);
                    dlRlMiddle.addView(productDetailView.getRootView());
                    if(dataToNextView!=null){
                        productDetailView.setProductEntity((ProductList.ProductEntity) dataToNextView);
                    }
                    appStackManager.addStack(productDetailView.getRootView());
                    break;
                case ConstantValue.REGISTER_VIEW:
                    RegistView registView=new RegistView(activity);
                    registView.getRootView().setTag(ConstantValue.REGISTER_VIEW);
                    dlRlMiddle.addView(registView.getRootView());
                    viewMap.put(ConstantValue.REGISTER_VIEW, registView.getRootView());
                    appStackManager.addStack(registView.getRootView());
                    break;

                case ConstantValue.VIEW_SHOPPINGCART:
                    ShopingCarDatasView shopingCarDatasView=new ShopingCarDatasView(activity);
                    shopingCarDatasView.getRootView().setTag(ConstantValue.VIEW_SHOPPINGCART);
                    dlRlMiddle.addView(shopingCarDatasView.getRootView());
                    viewMap.put(ConstantValue.VIEW_SHOPPINGCART, shopingCarDatasView.getRootView());
                    appStackManager.addStack(shopingCarDatasView.getRootView());
                    break;

                case ConstantValue.VIEW_ORDER_LIST:
                    MyOrderView myOrderView=new MyOrderView(activity);
                    myOrderView.getRootView().setTag(ConstantValue.VIEW_ORDER_LIST);
                    dlRlMiddle.addView(myOrderView.getRootView());
                    viewMap.put(ConstantValue.VIEW_ORDER_LIST, myOrderView.getRootView());
                    appStackManager.addStack(myOrderView.getRootView());
                    break;
            }
        }else{
            dlRlMiddle.addView(viewMap.get(viewID));  //使用缓存
            appStackManager.addStack(viewMap.get(viewID));
        }

        setNotifyTitleAndBottom(viewID);


    }

    private void setNotifyTitleAndBottom(int viewID) {
        //关键代码
        setChanged();
        notifyObservers(viewID);
    }


    public boolean goBack() {
        if (appStackManager.getAppStackSize() > 0) {
            // 当用户误操作返回键（不退出应用）
            if (appStackManager.getAppStackSize() == 1) {
                return false;
            }

            if (appStackManager.getAppStackSize() > 0) {
                appStackManager.removeCurrentView();

                dlRlMiddle.removeAllViews();

                View targetView = appStackManager.currentView();
                dlRlMiddle.addView(targetView);

                setNotifyTitleAndBottom((Integer) targetView.getTag());

                return true;
            }
        }

        return false;
    }




}
