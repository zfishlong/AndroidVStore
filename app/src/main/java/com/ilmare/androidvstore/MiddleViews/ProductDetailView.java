package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ilmare.androidvstore.Domain.ProductList;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.Utils.ConstantValue;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ProductDetailView extends RecyclerView.ViewHolder implements View.OnClickListener {
    @InjectView(R.id.productInfo)
    LinearLayout productInfo;

    @InjectView(R.id.relTop)
    RelativeLayout relTop;

    @InjectView(R.id.productViewPager)
    ViewPager productViewPager;
    @InjectView(R.id.imgPoint)
    LinearLayout imgPoint;
    @InjectView(R.id.textProductName)
    TextView textProductName;
    @InjectView(R.id.textProductNameValue)
    TextView textProductNameValue;
    @InjectView(R.id.textProductId)
    TextView textProductId;
    @InjectView(R.id.textProductIdValue)
    TextView textProductIdValue;
    @InjectView(R.id.priceLayout)
    RelativeLayout priceLayout;
    @InjectView(R.id.textOriginalPrice)
    TextView textOriginalPrice;
    @InjectView(R.id.textOriginalPriceValue)
    TextView textOriginalPriceValue;
    @InjectView(R.id.textProdGrade)
    TextView textProdGrade;
    @InjectView(R.id.textProdGradeValue)
    ImageView textProdGradeValue;
    @InjectView(R.id.textPrice)
    TextView textPrice;
    @InjectView(R.id.textPriceValue)
    TextView textPriceValue;
    @InjectView(R.id.textProdNum)
    TextView textProdNum;
    @InjectView(R.id.prodNumValue)
    EditText prodNumValue;
    @InjectView(R.id.prod_property)
    RelativeLayout prodProperty;
    @InjectView(R.id.textColor)
    TextView textColor;
    @InjectView(R.id.textColorValue)
    TextView textColorValue;
    @InjectView(R.id.textSize)
    TextView textSize;
    @InjectView(R.id.textSizeValue)
    TextView textSizeValue;
    @InjectView(R.id.relDescription)
    RelativeLayout relDescription;
    @InjectView(R.id.relProdStock)
    RelativeLayout relProdStock;
    @InjectView(R.id.textLookProdStock)
    TextView textLookProdStock;
    @InjectView(R.id.textProdIsStock)
    TextView textProdIsStock;
    @InjectView(R.id.relProductComment)
    RelativeLayout relProductComment;
    @InjectView(R.id.textProductComment)
    TextView textProductComment;
    @InjectView(R.id.textProductCommentNum)
    TextView textProductCommentNum;
    @InjectView(R.id.textPutIntoShopcar)
    TextView textPutIntoShopcar;
    @InjectView(R.id.textProdToCollect)
    TextView textProdToCollect;

   private Context context;
    private View rootView;

    private int lastPosition=0;
    private ProductList.ProductEntity productEntity;



    public ProductDetailView(Context context) {
        this(View.inflate(context, R.layout.product_detail_activity, null), context);
    }

    public ProductDetailView(View view,Context context) {
        super(view);
        ButterKnife.inject(this, view);
        this.context=context;
        this.rootView=view;

        this.rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));


//
    }



    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public ProductList.ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductList.ProductEntity productEntity) {
        this.productEntity = productEntity;

        //初始化ViewPager
        productViewPager.setAdapter(new MyProductPagerAdapter());
        //准备指示点
        initPoint();


        //ViewPager 与指示点联动
        productViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                imgPoint.getChildAt(lastPosition).setEnabled(false);
                imgPoint.getChildAt(position).setEnabled(true);
                lastPosition=position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        //设置文本信息
        textProductNameValue.setText(productEntity.getGoodsName());
        textProductIdValue.setText(productEntity.getGoodsId());
        textOriginalPriceValue.setText("¥"+(productEntity.getPrice()+20));
        textProdGradeValue.setImageResource(R.mipmap.level_2);
        textPriceValue.setText("¥" + productEntity.getPrice() + "");

        textPutIntoShopcar.setOnClickListener(this);
        textProdToCollect.setOnClickListener(this);
    }

    private void initPoint() {
        List<View> list = new ArrayList<View>();
        for (int i = 0; i < 3; i++) {
            View point = new View(context);
            point.setEnabled(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(10, 10);
            layoutParams.leftMargin = 5;
            point.setBackgroundResource(R.drawable.point_selector);
            point.setLayoutParams(layoutParams);
            imgPoint.addView(point);
        }

        imgPoint.getChildAt(0).setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textPutIntoShopcar:
                Toast.makeText(context, "加入购物车", Toast.LENGTH_SHORT).show();

                //TODO 真的加入购物车 逻辑
                break;
            case R.id.textProdToCollect:
                Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show();

                //TODO 真的收藏
                break;
        }
    }


    private class  MyProductPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=new ImageView(context);
            Picasso.with(context).load(ConstantValue.BASEURL+productEntity.getPicPath()).fit().into(imageView);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
