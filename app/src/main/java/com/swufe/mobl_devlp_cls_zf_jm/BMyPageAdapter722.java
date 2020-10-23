package com.swufe.mobl_devlp_cls_zf_jm;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BMyPageAdapter722 extends FragmentPagerAdapter {

    public BMyPageAdapter722(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new BHomeFragment722();
        }else if(position==1){
            return new BFuncFragment722();
        }else{
            return new BSettingFragment722();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    //标题栏
    @Override public CharSequence getPageTitle(int position) {
        return "Title" + position;
    }

}