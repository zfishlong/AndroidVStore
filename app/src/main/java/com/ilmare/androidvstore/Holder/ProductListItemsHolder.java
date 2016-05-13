package com.ilmare.androidvstore.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ilmare.androidvstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ProductListItemsHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.relImage)
    RelativeLayout relImage;
    @InjectView(R.id.goodsIconIv)
    ImageView goodsIconIv;
    @InjectView(R.id.imgIcon)
    ImageView imgIcon;
    @InjectView(R.id.imgIsNew)
    ImageView imgIsNew;
    @InjectView(R.id.imgIsBargain)
    ImageView imgIsBargain;
    @InjectView(R.id.relContent)
    RelativeLayout relContent;
    @InjectView(R.id.textClothesName)
    TextView textClothesName;
    @InjectView(R.id.textClothesPrice)
    TextView textClothesPrice;
    @InjectView(R.id.textMarketPrice)
    TextView textMarketPrice;
    @InjectView(R.id.textProductComment)
    TextView textProductComment;
    @InjectView(R.id.textProductCommentNum)
    TextView textProductCommentNum;

    public ProductListItemsHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.product_list_items, parent, false));
    }

    public ProductListItemsHolder(View view) {
        super(view);
        ButterKnife.inject(this, view);
    }

    public ImageView getImgIcon() {
        return imgIcon;
    }

    public RelativeLayout getRelImage() {
        return relImage;
    }

    public TextView getTextClothesPrice() {
        return textClothesPrice;
    }

    public TextView getTextClothesName() {
        return textClothesName;
    }

    public ImageView getImgIsNew() {
        return imgIsNew;
    }

    public TextView getTextProductCommentNum() {
        return textProductCommentNum;
    }

    public TextView getTextMarketPrice() {
        return textMarketPrice;
    }

    public RelativeLayout getRelContent() {
        return relContent;
    }

    public ImageView getImgIsBargain() {
        return imgIsBargain;
    }

    public TextView getTextProductComment() {
        return textProductComment;
    }

    public ImageView getGoodsIconIv() {
        return goodsIconIv;
    }
}
