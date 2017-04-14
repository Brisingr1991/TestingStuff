package com.publish.shahar91.testingstuff.miwokTabs.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Christiano on 11/04/2017.
 */

public class MiwokTabsPagerAdapter extends FragmentStatePagerAdapter {
    public MiwokTabsPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "NUMBERS";
            case 1:
                return "FAMILY";
            case 2:
                return "COLORS";
            case 3:
                return "PHRASES";
        }
        return null;
    }
}