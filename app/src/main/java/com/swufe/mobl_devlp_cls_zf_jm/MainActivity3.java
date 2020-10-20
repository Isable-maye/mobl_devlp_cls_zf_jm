package com.swufe.mobl_devlp_cls_zf_jm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
//week4-1内容 国庆前
//unit8 获取网络数据
//解析HTML数据 使用Jsoup
//https://jsoup.org/
//此代码会闪退
public class MainActivity3 extends AppCompatActivity {
    private static final String TAG = "MainActivity3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String url = "http://www.usd-cny.com/bankofchina.htm";
        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i(TAG,"run: " + ((org.jsoup.nodes.Document) doc).title());
        Elements tables = ((org.jsoup.nodes.Document) doc).getElementsByTag("table");

        Element table6 = tables.get(5);
        //获取TD中的数据
        Elements tds = table6.getElementsByTag("td");
        //td一行 th一列
        for(int i=0;i<tds.size();i+=8){
            Element td1 = tds.get(i); //第一列：国家名称or货币种类
            Element td2 = tds.get(i+5); //第二列：表格第6列 折算价
            //折算价是100元可以兑换成x英镑/美元/...
            String str1 = td1.text(); //获取第一列的数据--币种
            String val = td2.text(); //获取第二列的数据--汇率数字
            Log.i(TAG, "run: " + str1 + "==>" + val);
            float v = 100f / Float.parseFloat(val); //用折算价算汇率（人民币：其他）
            //获取数据并返回……

        }
    }
}