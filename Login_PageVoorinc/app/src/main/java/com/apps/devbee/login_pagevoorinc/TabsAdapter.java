package com.apps.devbee.login_pagevoorinc;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

    public class TabsAdapter extends FragmentPagerAdapter {

        List fragmentList =new ArrayList();
        List fragmentTitleList=new ArrayList();
        public void addFragment(Fragment fragment, String title){
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }
        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return (CharSequence) fragmentTitleList.get(position);
        }


        @Override
        public Fragment getItem(int i) {

            switch (i){


            }
            return (Fragment) fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
}
