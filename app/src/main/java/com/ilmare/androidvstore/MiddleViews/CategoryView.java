package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ilmare.androidvstore.Beans.CategoryList;
import com.ilmare.androidvstore.Holder.CategoryItemHolder;
import com.ilmare.androidvstore.Net.NetUtils;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.Utils.ConstantValue;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CategoryView extends RecyclerView.ViewHolder {
    @InjectView(R.id.categoryList)
    ListView categoryListView;

    @InjectView(R.id.categoryEmptyListTv)
    TextView categoryEmptyListTv;

    private Context context;
    private View rootView;


    private   CategoryList categoryList;
    public CategoryView(Context context) {
        this(View.inflate(context,R.layout.category_activity, null),context);
    }

    public CategoryView(View view,Context context) {
        super(view);
        ButterKnife.inject(this, view);
        this.rootView=view;
        this.context=context;

        this.rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));


        NetUtils.getJson(ConstantValue.URI + "/category", new NetUtils.NetAccessListener() {
            @Override
            public void onSeccuss(String json) {
                Gson gson=new Gson();

                categoryList = gson.fromJson(json, CategoryList.class);
                categoryListView.setAdapter(new MyCategoryAdapter());
                categoryEmptyListTv.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailed(String error) {

            }
        });

    }

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    private class MyCategoryAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return categoryList.getCategory().size();
        }

        @Override
        public Object getItem(int position) {
            return categoryList.getCategory().get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CategoryItemHolder holder=null;
            if(convertView==null){
                convertView=View.inflate(context,R.layout.category_item,null);
                holder=new CategoryItemHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder= (CategoryItemHolder) convertView.getTag();

            }

            CategoryList.CategoryEntity categoryEntity=categoryList.getCategory().get(position);
            Picasso.with(context).load(categoryEntity.getPic()).fit().into(holder.getImgIcon());
            System.out.println(categoryEntity.getPic());
            holder.getTextContent().setText(categoryEntity.getName());
            holder.getItemDescribe().setText(categoryEntity.getTag());

            return convertView;
        }
    }

}
