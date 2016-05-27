package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ilmare.androidvstore.Domain.OrderList;
import com.ilmare.androidvstore.Holder.MyOrderListitemHolder;
import com.ilmare.androidvstore.Net.NetUtils;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.Utils.ConstantValue;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MyOrderView extends RecyclerView.ViewHolder {
    @InjectView(R.id.my_order_tab)
    LinearLayout myOrderTab;
    @InjectView(R.id.my_order_month)
    TextView myOrderMonth;
    @InjectView(R.id.my_order_all)
    TextView myOrderAll;
    @InjectView(R.id.my_order_notsend)
    TextView myOrderNotsend;
    @InjectView(R.id.pb_load)
    ProgressBar pbLoad;
    @InjectView(R.id.my_order_list)
    ListView myOrderList;
    @InjectView(R.id.my_order_null_text)
    TextView myOrderNullText;

    private Context context;

    private View rootView;
    private   OrderList orderList;
    public MyOrderView(Context context) {
        this(View.inflate(context,R.layout.my_order_activity, null),context);
    }

    public MyOrderView(View view,Context context) {
        super(view);
        ButterKnife.inject(this, view);
        this.context=context;
        this.rootView=view;
        this.rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));

        //TODO 获取订单列表显示
        NetUtils.getJson(ConstantValue.ORDER_LIST, new NetUtils.NetAccessListener() {
            @Override
            public void onSeccuss(String json) {
                if(json!=null){
                    Gson gson =new Gson();
                    orderList = gson.fromJson(json,OrderList.class);
                    myOrderList.setAdapter(new MyOrderListAdapter());
                }
                pbLoad.setVisibility(View.GONE);
            }

            @Override
            public void onFailed(String error) {
                pbLoad.setVisibility(View.GONE);
            }
        });
    }


    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }



    private class MyOrderListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return orderList.getListCusorder().size();
        }

        @Override
        public Object getItem(int position) {
            return orderList.getListCusorder().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            MyOrderListitemHolder holder=null;
            if(convertView==null){
                convertView=View.inflate(context,R.layout.my_order_listitem,null);
                holder=new MyOrderListitemHolder(convertView);

                convertView.setTag(holder);
            }else{
                holder= (MyOrderListitemHolder) convertView.getTag();
            }

            OrderList.ListCusorderEntity listCusorderEntity = orderList.getListCusorder().get(position);


            //订单编号
            holder.getOrderIdText().setText(listCusorderEntity.getId());
            holder.getOrderPriceText().setText("服务器没给");
            holder.getOrderStateText().setText(listCusorderEntity.getStatusStr());
            holder.getOrderTimeText().setText(listCusorderEntity.getBeginDate().getYear()+1990+"-"+
                    (listCusorderEntity.getBeginDate().getMonth()+1)+"-"+listCusorderEntity.getBeginDate().getDate());

            return convertView;
        }
    }
}
