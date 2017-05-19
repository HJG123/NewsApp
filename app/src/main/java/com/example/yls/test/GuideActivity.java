package com.example.yls.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.yls.test.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HJG on 2017/5/18.
 */

public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener{
    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;
    //底部小点
    private ImageView[] dots;

    //记录当前选中位置
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        //初始化页面
        initViews();

        //初始化底部小点
        initDots();
    }

    private void initViews() {
        LayoutInflater inglater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        //初始化引导图列表
        views.add(inglater.inflate(R.layout.what_new_one,null));
        views.add(inglater.inflate(R.layout.what_new_two,null));
        views.add(inglater.inflate(R.layout.what_new_three,null));
        views.add(inglater.inflate(R.layout.what_new_four,null));

        //初始化Adapter
        vpAdapter = new ViewPagerAdapter(views,this);

        vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);
        //绑定回调
        vp.setOnPageChangeListener(this);
    }

    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

        dots = new ImageView[views.size()];

        //循环取得小点图片
        for (int i = 0; i < views.size(); i++){
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);
        }

        currentIndex = 0;
        dots[currentIndex].setEnabled(false);//设置为 色，即选中状态
    }

    private void setCurrentDot(int position){
        if (position<0 || position>views.size()-1 || currentIndex==position){
            return;
        }
        dots[position].setEnabled(false);
        dots[currentIndex].setEnabled(true);

        currentIndex = position;
    }

    // 当前页面被滑动时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int position) {
        // 设置底部小点选中状态
                setCurrentDot(position);
    }

    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
