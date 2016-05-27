package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ilmare.androidvstore.Domain.UserInfo;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.UIManager.MiddleViewManager;
import com.ilmare.androidvstore.Utils.ConstantValue;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AccountView extends RecyclerView.ViewHolder implements View.OnClickListener {


    @InjectView(R.id.tv_username)
    TextView tvUsername;
    @InjectView(R.id.tv_grade)
    TextView tvGrade;
    @InjectView(R.id.tv_integral)
    TextView tvIntegral;


    @InjectView(R.id.my_name_lin1)
    LinearLayout myNameLin1;
    @InjectView(R.id.my_name_lin2)
    LinearLayout myNameLin2;
    @InjectView(R.id.my_name_lin3)
    LinearLayout myNameLin3;
    @InjectView(R.id.my_name_lin4)
    LinearLayout myNameLin4;

    private Context context;

    private View rootView ;
    public AccountView(Context context) {
        this(View.inflate(context,R.layout.account_activity,null),context);
    }

    public AccountView(View view,Context context) {
        super(view);
        ButterKnife.inject(this, view);

        this.rootView=view;
        this.context=context;

        this.rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));

        myNameLin1.setOnClickListener(this);
        myNameLin2.setOnClickListener(this);
        myNameLin3.setOnClickListener(this);
        myNameLin4.setOnClickListener(this);


        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        String userJson=sp.getString("currentUser", "");
        Gson gson=new Gson();
        UserInfo info=gson.fromJson(userJson,UserInfo.class);

        tvUsername.setText(info.getListCus().get(0).getCusName());

    }

    public View getRootView() {
        return rootView;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_name_lin1:


                MiddleViewManager.getInstance().changeView(ConstantValue.VIEW_ORDER_LIST);
                Toast.makeText(context, "我的订单", Toast.LENGTH_SHORT).show();



                break;
            case R.id.my_name_lin2:

                Toast.makeText(context, "地址管理", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_name_lin3:

                Toast.makeText(context, "优惠券/礼物卡", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_name_lin4:

                Toast.makeText(context, "收藏夹", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
