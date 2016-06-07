package me.pkhope.jianwei;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkhope on 2016/6/7.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{


    private List<Fragment> fragmentList = new ArrayList<>();

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list){
        super(fm);
        fragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
