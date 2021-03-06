package com.swufe.mobl_devlp_cls_zf_jm;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

//7-2 fragment 第一种
//unit13
//此代码可运行
//所有72都是这个的
public class AFragmentActivity72 extends FragmentActivity {

    private Fragment mFragments[];
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbtHome, rbtFunc, rbtSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_fragment72);
        mFragments = new Fragment[3];
        fragmentManager = getSupportFragmentManager();
        mFragments[0] = fragmentManager.findFragmentById(R.id.fragment_main);
        Log.i(" mFragments[0]", " mFragments[0]=" +  mFragments[0]);
        mFragments[1] = fragmentManager.findFragmentById(R.id.fragment_func);
        Log.i(" mFragments[1]", " mFragments[1]=" +  mFragments[1]);
        mFragments[2] = fragmentManager.findFragmentById(R.id.fragment_setting);
        Log.i(" mFragments[2]", " mFragments[2]=" +  mFragments[2]);

        fragmentTransaction = fragmentManager.beginTransaction()
                .hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
        fragmentTransaction.show(mFragments[0]).commit();


        rbtHome = (RadioButton) findViewById(R.id.radioHome);
        rbtFunc = (RadioButton) findViewById(R.id.radioFunc);
        rbtSetting = (RadioButton) findViewById(R.id.radioSetting);

        radioGroup = (RadioGroup) findViewById(R.id.bottomGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("radioGroup", "checkId=" + checkedId);
                fragmentTransaction = fragmentManager.beginTransaction()
                        .hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
                switch (checkedId) {
                    case R.id.radioHome:
                        fragmentTransaction.show(mFragments[0]).commit();
                        break;
                    case R.id.radioFunc:
                        fragmentTransaction.show(mFragments[1]).commit();
                        break;
                    case R.id.radioSetting:
                        fragmentTransaction.show(mFragments[2]).commit();
                        break;
                    default:
                        break;
                }
            }
        });

    }
}