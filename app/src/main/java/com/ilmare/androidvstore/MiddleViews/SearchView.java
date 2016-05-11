package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ilmare.androidvstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SearchView extends RecyclerView.ViewHolder {

    @InjectView(R.id.relSearch)
    RelativeLayout relSearch;
    @InjectView(R.id.keyWordEdit)
    EditText keyWordEdit;
    @InjectView(R.id.ok)
    ImageView ok;
    @InjectView(R.id.relSpace)
    RelativeLayout relSpace;
    @InjectView(R.id.hotWordsLv)
    ListView hotWordsLv;
    private Context context;
    private View rootView;

    public SearchView(Context context) {
        this(View.inflate(context, R.layout.search_activity, null), context);
    }

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public SearchView(View view, Context context) {

        super(view);
        ButterKnife.inject(this, view);
        this.context = context;
        this.rootView = view;
        this.rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));
    }

    public ListView getHotWordsLv() {
        return hotWordsLv;
    }

    public RelativeLayout getRelSearch() {
        return relSearch;
    }

    public ImageView getOk() {
        return ok;
    }

    public RelativeLayout getRelSpace() {
        return relSpace;
    }

    public EditText getKeyWordEdit() {
        return keyWordEdit;
    }

}
