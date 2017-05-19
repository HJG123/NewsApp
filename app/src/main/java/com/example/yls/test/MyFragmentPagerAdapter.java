package com.example.yls.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yls.test.fragment.fragment1;
import com.example.yls.test.fragment.fragment2;
import com.example.yls.test.fragment.fragment3;
import com.example.yls.test.fragment.fragment4;

/**
 * Created by yls on 2017/5/16.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"我的最爱", "科技新闻", "体育新闻","社会新闻"};
    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new fragment2();
        } else if (position == 2) {
            return new fragment3();
        }else if (position==3){
            return new fragment4();
        }
        return new fragment1();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
