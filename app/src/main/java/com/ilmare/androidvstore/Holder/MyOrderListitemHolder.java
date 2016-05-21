package com.ilmare.androidvstore.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ilmare.androidvstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MyOrderListitemHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.order_item_rel)
    RelativeLayout orderItemRel;
    @InjectView(R.id.textOrderIDIcon)
    TextView textOrderIDIcon;
    @InjectView(R.id.orderId_text)
    TextView orderIdText;
    @InjectView(R.id.textPriceIcon)
    TextView textPriceIcon;
    @InjectView(R.id.orderPrice_text)
    TextView orderPriceText;
    @InjectView(R.id.textTimeIcon)
    TextView textTimeIcon;
    @InjectView(R.id.orderTime_text)
    TextView orderTimeText;
    @InjectView(R.id.textStateIcon)
    TextView textStateIcon;
    @InjectView(R.id.orderState_text)
    TextView orderStateText;
    @InjectView(R.id.linLine)
    LinearLayout linLine;

    public MyOrderListitemHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.my_order_listitem, parent, false));
    }

    public MyOrderListitemHolder(View view) {
        super(view);
        ButterKnife.inject(this, view);
    }

    public TextView getOrderStateText() {
        return orderStateText;
    }

    public LinearLayout getLinLine() {
        return linLine;
    }

    public TextView getOrderTimeText() {
        return orderTimeText;
    }

    public RelativeLayout getOrderItemRel() {
        return orderItemRel;
    }

    public TextView getTextOrderIDIcon() {
        return textOrderIDIcon;
    }

    public TextView getOrderIdText() {
        return orderIdText;
    }

    public TextView getOrderPriceText() {
        return orderPriceText;
    }

    public TextView getTextStateIcon() {
        return textStateIcon;
    }

    public TextView getTextTimeIcon() {
        return textTimeIcon;
    }

    public TextView getTextPriceIcon() {
        return textPriceIcon;
    }
}
