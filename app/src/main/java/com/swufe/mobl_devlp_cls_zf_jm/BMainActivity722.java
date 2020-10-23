package com.swufe.mobl_devlp_cls_zf_jm;

//import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


//7-2 fragment 第二种 可以滑动切换+标题栏
//unit13
//都用Androidx 要统一
//此代码可运行
//所有722都是它的
public class BMainActivity722 extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_view_page722);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        BMyPageAdapter722 pageAdapter = new BMyPageAdapter722(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
}