package com.ilmare.androidvstore.MiddleViews;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ilmare.androidvstore.Beans.Product;
import com.ilmare.androidvstore.Domain.ProductList;
import com.ilmare.androidvstore.Net.NetUtils;
import com.ilmare.androidvstore.R;
import com.ilmare.androidvstore.UIManager.MiddleViewManager;
import com.ilmare.androidvstore.Utils.ConstantValue;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HomeViews {

    @InjectView(R.id.relSearch)
    RelativeLayout relSearch;
    @InjectView(R.id.editSearchInfo)
    EditText editSearchInfo;
    @InjectView(R.id.ok)
    ImageView ok;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.ll_points)
    LinearLayout llPoints;
    @InjectView(R.id.custonInfoListView)
    ListView custonInfoListView;

    private View rootView;
    private Context context;
    private List<ImageView> imageViews;
    private static int[] resID = new int[]{R.mipmap.i1, R.mipmap.i2,
            R.mipmap.i3, R.mipmap.i4, R.mipmap.i5};

    private static int[] listitemID = new int[]{R.mipmap.home_classify_01,
            R.mipmap.home_classify_02, R.mipmap.home_classify_03,
            R.mipmap.home_classify_04, R.mipmap.home_classify_05};

    private boolean isStop=false;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            viewpager.setCurrentItem(currentPosition+1);
            if(!isStop){
                handler.sendEmptyMessageDelayed(0,3000);
            }
        }
    };

    private static String[] listitemStr = new String[]{"限时抢购", "促销快报",
            "新品上架", "热门单品", "推荐品牌"};

    private int currentPosition;


    public HomeViews(Context context) {
        this(View.inflate(context, R.layout.home_activity, null),context);
    }


    public HomeViews(View view, final Context context) {

        this.context = context;
        ButterKnife.inject(this, view);
        this.rootView = view;
        this.rootView.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));

        //初始化ViewPager
        viewpager.setAdapter(new MyHomeAdapter());

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                llPoints.getChildAt(currentPosition%resID.length).setEnabled(false);
                llPoints.getChildAt(position%resID.length).setEnabled(true);
                currentPosition=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initPoint();
        currentPosition = Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2) % resID.length;
        viewpager.setCurrentItem(currentPosition);



        handler.sendEmptyMessageDelayed(0, 3000);

        //初始化ListView
        custonInfoListView.setAdapter(new MyHomeListAdapter());

        custonInfoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        MiddleViewManager.getInstance().changeView(ConstantValue.PRODUCT_LIST_VIEW);
                        break;
                    case 1:
                        MiddleViewManager.getInstance().changeView(ConstantValue.PRODUCT_LIST_VIEW);
                        break;
                    case 2:
                        MiddleViewManager.getInstance().changeView(ConstantValue.PRODUCT_LIST_VIEW);
                        break;
                    case 3:
//                        NetUtils.getJson("http://bishe.java.jspee.net/goodsShowManage_goodsShow.action", new NetUtils.NetAccessListener() {
//                            @Override
//                            public void onSeccuss(String json) {
//                                Gson gson=new Gson();
//                                ProductList product=gson.fromJson(json, ProductList.class);
//                                System.out.println(product.toString());
//                            }
//                            @Override
//                            public void onFailed(String error) {
//
//                            }
//                        });
                        break;
                    case 4 :
                        MiddleViewManager.getInstance().changeView(ConstantValue.PRODUCT_LIST_VIEW);
                        break;
                }
            }
        });

    }


    private void initPoint() {

        imageViews = new ArrayList<>();
        for(int i=0;i<5;i++){
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
            imageView.setBackgroundResource(resID[i]);
            imageViews.add(imageView);
        }




        List<View> list = new ArrayList<View>();

        for (int i = 0; i < 5; i++) {
            View point = new View(context);
            point.setEnabled(false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
            layoutParams.leftMargin = 5;
            point.setBackgroundResource(R.drawable.point_selector);
            point.setLayoutParams(layoutParams);
            llPoints.addView(point);
        }

        llPoints.getChildAt(currentPosition%resID.length).setEnabled(true);
    }

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }


    private class MyHomeAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //创建对象时调用
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=imageViews.get(position % resID.length);
            container.addView(imageView);
            return imageViews.get(position % resID.length);
        }

        //销毁对象时调用
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }


    }

    private class MyHomeListAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return listitemStr.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if(convertView==null){
                convertView=View.inflate(context,R.layout.home_item,null);
                holder=new ViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }

            holder.imgIcon.setImageResource(listitemID[position]);
            holder.textContent.setText(listitemStr[position]);

            return convertView;
        }


    }

    static class ViewHolder{
        ImageView  imgIcon;
        TextView textContent;

        public ViewHolder(View view){
            imgIcon= (ImageView) view.findViewById(R.id.imgIcon);
            textContent= (TextView) view.findViewById(R.id.textContent);
        }

    }
}
