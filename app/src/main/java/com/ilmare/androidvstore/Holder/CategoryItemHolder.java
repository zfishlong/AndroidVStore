package com.ilmare.androidvstore.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilmare.androidvstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CategoryItemHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.imgIcon)
    ImageView imgIcon;
    @InjectView(R.id.textContent)
    TextView textContent;
    @InjectView(R.id.item_describe)
    TextView itemDescribe;

    public CategoryItemHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.category_item, parent, false));
    }

    public CategoryItemHolder(View view) {
        super(view);
        ButterKnife.inject(this, view);
    }

    public TextView getItemDescribe() {
        return itemDescribe;
    }

    public ImageView getImgIcon() {
        return imgIcon;
    }

    public TextView getTextContent() {
        return textContent;
    }
}
