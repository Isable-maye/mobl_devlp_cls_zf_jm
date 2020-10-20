package com.swufe.mobl_devlp_cls_zf_jm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

//此为无错误可运行版本
//结合：使用列表+解析html数据+多线程
//1:使用列表 方法一 list
//unit9
//3：解析html数据
//week32-3：多线程
public class MainActivity4 extends ListActivity implements Runnable{
    Handler handler;
    private static final String TAG = "MainActivity4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_rate_list);

        //第一部分：解析html
        //不能在主线程中访问网络 会报错闪退
        //开启子线程
        Thread t = new Thread(this);//不要忘了this
        t.start();

        //主线程内容
        //获取网络数据
        handler = new Handler() {

            public void handleMessage(Message msg) {
                if (msg.what == 7) //what的取值要在主线程和子线程都一致
                {

                    List<String> list2 = (List<String>) msg.obj;
                    //第二部分：使用列表
                    ListAdapter adapter = new ArrayAdapter<String>(
                            MainActivity4.this,
                            android.R.layout.simple_list_item_1,
                            list2);
                    setListAdapter(adapter);
                }
                super.handleMessage(msg);
            }
        };

    }

    //子线程
    @Override
    public void run() {

        Log.i(TAG,"run：");

        //获取Msg对象，用于返回主线程

        //在子线程中获取网络数据
        //获取网络数据
        //URL url1 = null;

        String url = "https://www.usd-cny.com/bankofchina.htm";
        Document doc = null;

        try {
            // url1 = new URL(url);
            // HttpsURLConnection http = (HttpsURLConnection) url1.openConnection();

            doc = Jsoup.connect(url).get();
            Log.i(TAG,"run: " + ((org.jsoup.nodes.Document) doc).title());

            Elements tables = ((org.jsoup.nodes.Document) doc).getElementsByTag("table");

            Element table6 = tables.get(0);
            //获取TD中的数据
            Elements tds = table6.getElementsByTag("td");
            //td一行 th一列
            //列表初始化
            List<String> list1 = new ArrayList<String>();
            for (int i = 1; i < 100; i++) {
                list1.add("item" + i);
            }
            //存储数据的列表填值
            List<String> listData = new ArrayList<>();
//            String[] list_data = {};
            for(int i=0;i<tds.size();i+=6){
                Element td1 = tds.get(i); //第一列：国家名称or货币种类
                Element td2 = tds.get(i+5); //第二列：表格第6列 折算价
                //折算价是100元可以兑换成x英镑/美元/...
                String str1 = td1.text(); //获取第一列的数据--币种
                String val = td2.text(); //获取第二列的数据--汇率数字
                Log.i(TAG, "run: " + str1 + "==>" + val);
                float v = 100f / Float.parseFloat(val); //用折算价算汇率（人民币：其他）
                //获取数据并返回……
                //把数据存入数据列表
                listData.add(str1+"==>"+v);
//                list_data[i]=(str1+"==>"+v);

            }

            //字符串数组转换成字符串列表
//            List<String> dataList = Arrays.asList(list_data);

            // InputStream in = http.getInputStream();
            //String html = inputStream2String(in);
            //Log.i(TAG, "run: html=" + html);
            Message msg = handler.obtainMessage(7);
            //msg.what = 5;
            // msg.obj = "Hello from run()";
            //先msg再handler就不闪退了
            msg.obj = listData;
            handler.sendMessage(msg);
            Log.i(TAG, "run: html=" + doc);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String inputStream2String(InputStream inputStream)
            throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "gb2312");
        while (true) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    }
}