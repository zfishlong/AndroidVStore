package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ilmare.androidvstore.Domain.ShopingCarItem;
import com.ilmare.androidvstore.Domain.UserInfo;
import com.ilmare.androidvstore.Holder.PaymentCenterItemsHolder;
import com.ilmare.androidvstore.Net.NetUtils;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.UIManager.MiddleViewManager;
import com.ilmare.androidvstore.Utils.ConstantValue;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShopingCarDatasView extends RecyclerView.ViewHolder implements View.OnClickListener {

    @InjectView(R.id.payment_orderPrice_text)
    TextView paymentOrderPriceText;
    @InjectView(R.id.payment_address_rel)
    RelativeLayout paymentAddressRel;
    @InjectView(R.id.payment_address_text)
    TextView paymentAddressText;
    @InjectView(R.id.payment_payType_rel)
    RelativeLayout paymentPayTypeRel;
    @InjectView(R.id.payment_payHint_text)
    TextView paymentPayHintText;
    @InjectView(R.id.payment_payValue_text)
    TextView paymentPayValueText;
    @InjectView(R.id.payment_sendTime_rel)
    RelativeLayout paymentSendTimeRel;
    @InjectView(R.id.payment_sendTimeHint_text)
    TextView paymentSendTimeHintText;
    @InjectView(R.id.payment_sendTimeValue_text)
    TextView paymentSendTimeValueText;
    @InjectView(R.id.payment_invoice_rel)
    RelativeLayout paymentInvoiceRel;
    @InjectView(R.id.payment_invoiceHint_text)
    TextView paymentInvoiceHintText;
    @InjectView(R.id.payment_invoiceValue_text)
    TextView paymentInvoiceValueText;
    @InjectView(R.id.payment_remark_rel)
    RelativeLayout paymentRemarkRel;
    @InjectView(R.id.payment_remarkHint_text)
    TextView paymentRemarkHintText;
    @InjectView(R.id.payment_remarkView_text)
    TextView paymentRemarkViewText;
    @InjectView(R.id.payment_product_list)
    ListView paymentProductList;
    @InjectView(R.id.shopcar_total_buycount_text)
    TextView shopcarTotalBuycountText;
    @InjectView(R.id.shopcar_total_bonus_text)
    TextView shopcarTotalBonusText;
    @InjectView(R.id.shopcar_total_money_text)
    TextView shopcarTotalMoneyText;
    @InjectView(R.id.ordr_submit_bottom_text)
    TextView ordrSubmitBottomText;

    private Context context;

    private View rootView;

    private ArrayList<ShopingCarItem> shopingCarItems;
    private UserInfo userInfo=null;
    private String priceType="1";

    public ShopingCarDatasView(Context context) {
        this(View.inflate(context, R.layout.payment_center_activity, null), context);
    }

    public ShopingCarDatasView(View view, Context context) {
        super(view);
        ButterKnife.inject(this, view);

        this.context = context;
        this.rootView = view;

        this.rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));

        getCurrentUserInfo(context);

        showProducts();

        showMoney();
    }


    private void getCurrentUserInfo(Context context) {
        String currentUser = context.getSharedPreferences("config", Context.MODE_PRIVATE).getString("currentUser", "");
        if(!TextUtils.isEmpty(currentUser)){
            Gson gson=new Gson();
            userInfo = gson.fromJson(currentUser, UserInfo.class);
            priceType = userInfo.getListCus().get(0).getPriceTypeId();
        }
    }

    private void showMoney() {

        int countSum = 0;
        int priceSum = 0;

        for (ShopingCarItem item : shopingCarItems) {
             countSum += item.getOrderNumber();
             priceSum += item.getOrderNumber() *
                  item.getShopingCarItemProductEntity().getGoods().getListPrice()
                             .get(Integer.parseInt(priceType)-1);
        }

        paymentOrderPriceText.setText("您共需为订单支付：￥" + priceSum);
        shopcarTotalBuycountText.setText(countSum + " ");
        shopcarTotalMoneyText.setText("￥" + priceSum + "");
        ordrSubmitBottomText.setOnClickListener(this);
    }


    /**
     *
     */
    private void showProducts() {
        File file = new File(context.getCacheDir(), "a.txt");
        try {

            ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream(file));
            shopingCarItems = (ArrayList<ShopingCarItem>)inputStream.readObject();
            System.out.println(shopingCarItems.size());
            paymentProductList.setAdapter(new MyShopingCarItemAdapter());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    @Override
    public void onClick(View v) {

        if(userInfo==null){
            MiddleViewManager.getInstance().changeView(ConstantValue.LOGIN_VIEW);
            return;
        }



        for (ShopingCarItem item : shopingCarItems) {
            NetUtils.getJson(ConstantValue.MAKE_ORDER + "?cusId=" + userInfo.getListCus().get(0).getCusId() + "&isbn=" +
                    item.getShopingCarItemProductEntity().getGoods().getIsbn() + "&num=" + item.getOrderNumber(), new NetUtils.NetAccessListener() {
                @Override
                public void onSeccuss(String json) {

                }

                @Override
                public void onFailed(String error) {

                }
            });
        }

        Toast.makeText(context, "订单成功！", Toast.LENGTH_SHORT).show();
    }


    private class MyShopingCarItemAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return shopingCarItems.size();
        }

        @Override
        public Object getItem(int position) {
            return shopingCarItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            PaymentCenterItemsHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.payment_center_items, null);
                holder = new PaymentCenterItemsHolder(convertView);
                convertView.setTag(holder);

            } else {
                holder = (PaymentCenterItemsHolder) convertView.getTag();
            }


            ShopingCarItem item = shopingCarItems.get(position);


            Picasso.with(context).load(ConstantValue.BASEURL + item.getShopingCarItemProductEntity().getGoods().getPicPath()).fit().into(holder.getShopcarItemProdImageImg());//图片
            holder.getShopcarItemProdNameText().setText(item.getShopingCarItemProductEntity().getGoods().getGoodsName()); //商品名称
            holder.getShopcarItemProdIdText().setText(item.getShopingCarItemProductEntity().getGoods().getIsbn()); //商品编号

            holder.getShopcarItemProdPriceText().setText("￥" + item.getShopingCarItemProductEntity().getGoods().getListPrice().get(Integer.parseInt(priceType)-1) * item.getOrderNumber() + "");//商品价格
            holder.getShopcarItemProdCountText().setText(item.getOrderNumber() + ""); //商品数量
            holder.getShopcarItemSubtotalText().setText("￥" + item.getShopingCarItemProductEntity().getGoods().getListPrice().get(Integer.parseInt(priceType) - 1) * item.getOrderNumber() + ""); //小计
            return convertView;
        }


    }

}
