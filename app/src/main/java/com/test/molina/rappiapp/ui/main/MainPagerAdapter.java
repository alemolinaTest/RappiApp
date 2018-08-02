package com.test.molina.rappiapp.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.test.molina.rappiapp.ui.popular.PopularFragment;


/**
 * Created by Amolina on 02/02/17.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public MainPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return PopularFragment.newInstance(1);
            case 1:
                return PopularFragment.newInstance(2);
            case 2:
                return PopularFragment.newInstance(3);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }

}
