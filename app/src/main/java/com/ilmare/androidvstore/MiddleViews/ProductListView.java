package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ilmare.androidvstore.Domain.ProductList;
import com.ilmare.androidvstore.Holder.ProductListItemsHolder;
import com.ilmare.androidvstore.Net.NetUtils;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.UIManager.MiddleViewManager;
import com.ilmare.androidvstore.Utils.ConstantValue;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ProductListView extends RecyclerView.ViewHolder implements View.OnClickListener, AdapterView.OnItemClickListener {

    @InjectView(R.id.linRank)
    LinearLayout linRank;
    @InjectView(R.id.textRankSale)
    TextView textRankSale;
    @InjectView(R.id.textRankPrice)
    TextView textRankPrice;
    @InjectView(R.id.textRankGood)
    TextView textRankGood;
    @InjectView(R.id.textRankTime)
    TextView textRankTime;
    @InjectView(R.id.productViewPager)
    ListView productListView;
    @InjectView(R.id.categoryEmptyListTv)
    TextView categoryEmptyListTv;
    @InjectView(R.id.textNull)
    TextView textNull;

    private Context context;
    private View rootView;

    private ProductList productList;
    private MyProductListAdapter adapter;

    public ProductListView(Context context) {
        this(View.inflate(context, R.layout.product_list_activity, null), context);
    }

    public ProductListView(View view, Context context) {
        super(view);
        ButterKnife.inject(this, view);
        this.rootView = view;
        this.context = context;

        this.rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));

        String url="";
        switch (MiddleViewManager.getInstance().CURRENTTAG) {

            case ConstantValue.SHOPPINGSPRING:
                url=ConstantValue.PRODUCTLISTINFO;
                getData(url);
                break;
            case ConstantValue.NEWPRODUCT:
                 url=ConstantValue.PRODUCTLISTINFO;
                getData(url);
                break;
            case ConstantValue.HOTPRODUCT:
                url=ConstantValue.PRODUCTLISTINFO;
                getData(url);
                break;
            case ConstantValue.BRANDITEM:
               url=ConstantValue.PRODUCTLISTINFO;
                getData(url);
                break;
            default:
               url=ConstantValue.PRODUCTLISTINFO;
                getData(url);
                break;

        }


        textRankSale.setOnClickListener(this);
        textRankPrice.setOnClickListener(this);
        textRankGood.setOnClickListener(this);
        textRankTime.setOnClickListener(this);

        productListView.setOnItemClickListener(this);
    }



    private void getData2(String url) {
        //初始化的操作
        NetUtils.getJson(url, new NetUtils.NetAccessListener() {
            @Override
            public void onSeccuss(String json) {
                Gson gson = new Gson();

                productList = gson.fromJson(json, ProductList.class);
                adapter = new MyProductListAdapter();
                productListView.setAdapter(adapter);

            }

            @Override
            public void onFailed(String error) {

            }
        });
    }



    private void getData(String url) {
        //初始化的操作
        NetUtils.getJson( url, new NetUtils.NetAccessListener() {
            @Override
            public void onSeccuss(String json) {
                Gson gson = new Gson();

                productList = gson.fromJson(json, ProductList.class);
                adapter = new MyProductListAdapter();
                productListView.setAdapter(adapter);

            }

            @Override
            public void onFailed(String error) {

            }
        });
    }

    private void initTextView() {
        textRankSale.setBackgroundResource(R.mipmap.segment_normal_2_bg);
        textRankPrice.setBackgroundResource(R.mipmap.segment_normal_2_bg);
        textRankGood.setBackgroundResource(R.mipmap.segment_normal_2_bg);
        textRankTime.setBackgroundResource(R.mipmap.segment_normal_2_bg);
    }

    @Override
    public void onClick(View v) {
        initTextView();
        switch (v.getId()) {
            case R.id.textRankSale:
                textRankSale
                        .setBackgroundResource(R.mipmap.segment_selected_1_bg);

                //TODO 请求网络  更新列表

                break;
            case R.id.textRankPrice:

                textRankPrice
                        .setBackgroundResource(R.mipmap.segment_selected_1_bg);
                //TODO 请求网络  更新列表
                break;
            case R.id.textRankGood:
                textRankGood
                        .setBackgroundResource(R.mipmap.segment_selected_1_bg);
                //TODO 请求网络  更新列表
                break;
            case R.id.textRankTime:
                textRankTime
                        .setBackgroundResource(R.mipmap.segment_selected_1_bg);
                //TODO 请求网络  更新列表
                break;
        }
    }


    //条目的点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ProductList.ProductEntity productEntity = productList.getListGoods().get(position);

        MiddleViewManager.getInstance().setDataToNextView(productEntity);

        MiddleViewManager.getInstance().changeView(ConstantValue.PRODUCT_DETAIL_VIEW);


    }


    private class MyProductListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return productList.getListGoods().size();
        }

        @Override
        public Object getItem(int position) {
            return productList.getListGoods().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ProductListItemsHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.product_list_items, null);
                holder = new ProductListItemsHolder(convertView);
                convertView.setTag(holder);

            } else {
                holder = (ProductListItemsHolder) convertView.getTag();
            }

            ProductList.ProductEntity productEntity = productList.getListGoods().get(position);
            holder.getTextClothesName().setText(productEntity.getGoodsName());//商品名称
            holder.getTextClothesPrice().setText("¥" + productEntity.getPrice() + "");//商品价格
            holder.getTextMarketPrice().setText("原价：¥" + (productEntity.getPrice() + 20));//原价
            Picasso.with(context).load(ConstantValue.BASEURL + productEntity.getPicPath()).fit().into(holder.getGoodsIconIv());
            return convertView;
        }
    }


    public View getRootView() {
        return rootView;
    }


}
