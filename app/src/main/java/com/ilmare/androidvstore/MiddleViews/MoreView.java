package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.UIManager.MiddleViewManager;
import com.ilmare.androidvstore.Utils.ConstantValue;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MoreView implements View.OnClickListener {

    @InjectView(R.id.my_account_rl)
    RelativeLayout myAccountRl;
    @InjectView(R.id.my_account_text)
    TextView myAccountText;
    @InjectView(R.id.my_order_rl)
    RelativeLayout myOrderRl;
    @InjectView(R.id.my_ordr_text)
    TextView myOrdrText;
    @InjectView(R.id.address_manage_rl)
    RelativeLayout addressManageRl;
    @InjectView(R.id.address_manage_text)
    TextView addressManageText;
    @InjectView(R.id.my_favorite_rl)
    RelativeLayout myFavoriteRl;
    @InjectView(R.id.my_favorite_text)
    TextView myFavoriteText;
    @InjectView(R.id.recent_browse_rl)
    RelativeLayout recentBrowseRl;
    @InjectView(R.id.recent_browse_text)
    TextView recentBrowseText;
    @InjectView(R.id.helpRelLay)
    RelativeLayout helpRelLay;
    @InjectView(R.id.userfeedback)
    RelativeLayout userfeedback;
    @InjectView(R.id.aboutRelLay)
    RelativeLayout aboutRelLay;

   private  View rootView;
    private Context contetx;
    public MoreView(Context context) {

        this(View.inflate(context, R.layout.more_activity, null));
        this.contetx=context;
    }

    public MoreView(View view) {
        ButterKnife.inject(this, view);
        this.rootView=view;

        myAccountRl.setOnClickListener(this);
        myFavoriteRl.setOnClickListener(this);
        recentBrowseRl.setOnClickListener(this);
        helpRelLay.setOnClickListener(this);
        userfeedback.setOnClickListener(this);
        aboutRelLay.setOnClickListener(this);
        addressManageRl.setOnClickListener(this);
        myOrderRl.setOnClickListener(this);
     
    }

    public View getRootView() {
        return rootView;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.my_account_rl:  //我的账户 --->登录
//                Toast.makeText(contetx, "我的账户", Toast.LENGTH_SHORT).show();
                MiddleViewManager.getInstance().changeView(ConstantValue.LOGIN_VIEW);
                break;

            case R.id.my_favorite_rl:
                Toast.makeText(contetx, "我的收藏", Toast.LENGTH_SHORT).show();
                //TODO 切换到我的收藏页面
                break;

            case R.id.address_manage_rl:
                Toast.makeText(contetx, "地址管理", Toast.LENGTH_SHORT).show();
                //TODO 地址管理页面
                break;

            case   R.id.recent_browse_rl:
                Toast.makeText(contetx, "最近浏览", Toast.LENGTH_SHORT).show();
                //TODO 最近浏览
                break;

            case R.id.helpRelLay:
                Toast.makeText(contetx, "帮助中心", Toast.LENGTH_SHORT).show();
                //TODO 帮助中心
                break;

            case R.id.userfeedback:
                Toast.makeText(contetx, "用户反馈", Toast.LENGTH_SHORT).show();
                //TODO 用户反馈
                break;
            case R.id.aboutRelLay:
                Toast.makeText(contetx, "关于我们", Toast.LENGTH_SHORT).show();
                //TODO 关于我们
                break;
            case R.id.my_order_rl:
                Toast.makeText(contetx, "我的订单", Toast.LENGTH_SHORT).show();
                //TODO 我的订单
                break;
        }



    }
}
