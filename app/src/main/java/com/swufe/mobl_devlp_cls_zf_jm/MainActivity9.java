package com.swufe.mobl_devlp_cls_zf_jm;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
//unit11
//week5-2
//第2个内容 列表空数据视图
//此代码可运行
//基于5：自定义列表 修改
//week5-1
//unit10
//行布局文件list_item.xml


public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        //与页面布局文件中的listview关联
        ListView listView = (ListView) findViewById(R.id.mylist);
        //数据类型从string——>map<string,string>
        ArrayList<HashMap<String, String>> listItems = new ArrayList<HashMap<String, String>>();

        //不在列表添加数据
        /**
         for (int i = 0; i < 10; i++) {
         HashMap<String, String> map = new HashMap<String, String>();
         map.put("ItemTitle", "Rate 9： " + i); // 标题文字
         map.put("ItemDetail", "detail" + i); // 详情描述
         listItems.add(map);
         }
         */
        // 生成适配器的 Item 和动态数组对应的元素
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,
                listItems, // listItems 数据源
                R.layout.list_item, // ListItem 的 XML 布局实现
                //此为行布局
                new String[]{"ItemTitle", "ItemDetail"},
                new int[]{R.id.itemTitle, R.id.itemDetail}
        );
        //加这句
        listView.setAdapter(listItemAdapter);
        //空数据视图
        listView.setEmptyView(findViewById(R.id.nodata));
    }
}