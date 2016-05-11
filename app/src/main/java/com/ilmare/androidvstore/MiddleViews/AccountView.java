package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ilmare.androidvstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AccountView extends RecyclerView.ViewHolder implements View.OnClickListener {
    @InjectView(R.id.li_message)
    LinearLayout liMessage;
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
    }

    public View getRootView() {
        return rootView;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_name_lin1:

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
