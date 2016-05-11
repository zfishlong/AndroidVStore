package com.ilmare.androidvstore.MiddleViews;

import android.app.ActionBar;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.UIManager.MiddleViewManager;
import com.ilmare.androidvstore.Utils.ConstantValue;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShopingCarNoDataView implements View.OnClickListener {
    @InjectView(R.id.dl_cart_no_data_state_tv)
    TextView dlCartNoDataStateTv;
    @InjectView(R.id.dl_cart_no_data_forward_cuxiao)
    Button dlCartNoDataForwardCuxiao;

    private Context context;
    private View rootView;

    public ShopingCarNoDataView(Context context) {

        this(View.inflate(context,R.layout.dl_shopping_cart_no_data_layout, null));
        this.context=context;
    }

    public ShopingCarNoDataView(View view) {
        ButterKnife.inject(this, view);
        this.rootView=view;

        rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));

        dlCartNoDataForwardCuxiao.setOnClickListener(this);
    }
    public Button getDlCartNoDataForwardCuxiao() {
        return dlCartNoDataForwardCuxiao;
    }

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public TextView getDlCartNoDataStateTv() {
        return dlCartNoDataStateTv;
    }

    @Override
    public void onClick(View v) {
        MiddleViewManager.getInstance().changeView(ConstantValue.VIEW_HOME);
    }
}
