package com.ilmare.androidvstore.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ilmare.androidvstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PaymentCenterItemsHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.shopcar_item_prodImage_rel)
    RelativeLayout shopcarItemProdImageRel;
    @InjectView(R.id.shopcar_item_prodImage_img)
    ImageView shopcarItemProdImageImg;
    @InjectView(R.id.shopcar_item_prod_layout)
    LinearLayout shopcarItemProdLayout;
    @InjectView(R.id.shopcar_item_prodName_text)
    TextView shopcarItemProdNameText;
    @InjectView(R.id.shopcar_item_prodId_text)
    TextView shopcarItemProdIdText;
    @InjectView(R.id.shopcar_item_prodPrice_text)
    TextView shopcarItemProdPriceText;
    @InjectView(R.id.shopcar_item_prodCount_text)
    TextView shopcarItemProdCountText;
    @InjectView(R.id.shopcar_item_prodCount_edit)
    EditText shopcarItemProdCountEdit;
    @InjectView(R.id.shopcar_item_subtotal_text)
    TextView shopcarItemSubtotalText;
    @InjectView(R.id.shopcar_item_delete_text)
    TextView shopcarItemDeleteText;

    public PaymentCenterItemsHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.payment_center_items, parent, false));
    }

    public PaymentCenterItemsHolder(View view) {
        super(view);
        ButterKnife.inject(this, view);
    }

    public TextView getShopcarItemSubtotalText() {
        return shopcarItemSubtotalText;
    }

    public TextView getShopcarItemProdCountText() {
        return shopcarItemProdCountText;
    }

    public ImageView getShopcarItemProdImageImg() {
        return shopcarItemProdImageImg;
    }

    public RelativeLayout getShopcarItemProdImageRel() {
        return shopcarItemProdImageRel;
    }

    public TextView getShopcarItemProdIdText() {
        return shopcarItemProdIdText;
    }

    public TextView getShopcarItemProdPriceText() {
        return shopcarItemProdPriceText;
    }

    public TextView getShopcarItemProdNameText() {
        return shopcarItemProdNameText;
    }

    public EditText getShopcarItemProdCountEdit() {
        return shopcarItemProdCountEdit;
    }

    public TextView getShopcarItemDeleteText() {
        return shopcarItemDeleteText;
    }

    public LinearLayout getShopcarItemProdLayout() {
        return shopcarItemProdLayout;
    }
}
