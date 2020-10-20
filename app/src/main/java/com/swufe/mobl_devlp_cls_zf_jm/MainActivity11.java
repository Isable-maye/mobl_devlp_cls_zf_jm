package com.swufe.mobl_devlp_cls_zf_jm;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//在10短按的基础上 +长按处理 +AlertDialog对话框
//week5-2 unit11

//点击接口+长按接口
public class MainActivity11 extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener  {
    private static final String TAG = "MainActivity11";
    ListView listview=null;
    ArrayList<HashMap<String, String>> listItems = new ArrayList<HashMap<String, String>>();
    SimpleAdapter listItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        //与页面布局文件中的listview关联
        listview = (ListView) findViewById(R.id.mylist);

        //添加事件监听
        //数据类型要转换
        listview.setOnItemClickListener(this);
        listview.setOnItemLongClickListener(this);

        //调用
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "Rate 11： " + i); // 标题文字
            map.put("ItemDetail", "detail" + i); // 详情描述
            listItems.add(map);
        }
        // 生成适配器的 Item 和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this,
                listItems, // listItems 数据源
                R.layout.list_item, // ListItem 的 XML 布局实现
                //此为行布局
                new String[]{"ItemTitle", "ItemDetail"},
                new int[]{R.id.itemTitle, R.id.itemDetail}
        );
        //加这句，加入布局并生效
        listview.setAdapter(listItemAdapter);
    }

    //实现AdapterView.OnItemClickListener接口
    //重写方法
    //在此方法onItemClick中处理点击后的处理
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //获取ListView中点击的数据
        Object itemAtPosition = listview.getItemAtPosition(position);

        // 删除数据项
        listItems.remove(position);
        // 更新适配器
        listItemAdapter.notifyDataSetChanged();
    }

    //有匿名类要final变量
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setMessage("请确认是否删除当前数据")
                .setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: 对话框事件处理");
                        // 删除数据项
                        listItems.remove(position);
                        // 更新适配器
                        listItemAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("否", null); builder.create().show();
        return true;
        //屏蔽短按事件 true

    }
}