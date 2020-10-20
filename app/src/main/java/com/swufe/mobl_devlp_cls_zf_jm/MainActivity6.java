package com.swufe.mobl_devlp_cls_zf_jm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//此代码可运行
//6：自定义适配器adapter
//此为6-1：activity一个类 activity————MainActivity6
//6-2：adapter一个类 java class————MyAdapter
//unit10
//week5-1

public class MainActivity6 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "MainActivity6";
    ListView listview=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        //与页面布局文件中的listview关联
        listview = (ListView) findViewById(R.id.mylist);

        //添加事件监听
        //数据类型要转换
        listview.setOnItemClickListener(this);

        //调用
        ArrayList<HashMap<String, String>> listItems = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "Rate： " + i); // 标题文字
            map.put("ItemDetail", "detail" + i); // 详情描述
            listItems.add(map);
        }
        MyAdapter myAdapter = new MyAdapter(this,
                R.layout.list_item,
                listItems);

        //加这句，加入布局并生效
        listview.setAdapter(myAdapter);
    }
    //实现AdapterView.OnItemClickListener接口
    //重写方法
    //在此方法onItemClick中处理点击后的处理
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //获取ListView中点击的数据
        Object itemAtPosition = listview.getItemAtPosition(position);

        HashMap<String,String> map = (HashMap<String, String>) itemAtPosition;
        String titleStr = map.get("ItemTitle");
        String detailStr = map.get("ItemDetail");
        Log.i(TAG, "onItemClick: titleStr=" + titleStr);
        Log.i(TAG, "onItemClick: detailStr=" + detailStr);
        TextView title = (TextView) view.findViewById(R.id.itemTitle);
        TextView detail = (TextView) view.findViewById(R.id.itemDetail);
        String title2 = String.valueOf(title.getText());
        String detail2 = String.valueOf(detail.getText());
        Log.i(TAG, "onItemClick: title2=" + title2);
        Log.i(TAG, "onItemClick: detail2=" + detail2);
    }
}