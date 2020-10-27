package com.swufe.mobl_devlp_cls_zf_jm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity32 extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    float dollarRate = 0.125f;
    float euroRate = 0.1f;
    float wonRate = 172f;
    EditText editText;
    EditText out,out2,out3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_activity32_main);

        out = (EditText)findViewById(R.id.editText3);
        out2 = (EditText)findViewById(R.id.editText4);
        out3 = (EditText)findViewById(R.id.editText3);

    }

    //汇率转换
    public void change(View btn){
        Toast.makeText(this, "hello msg", Toast.LENGTH_SHORT).show();//消息提示
        Log.i(TAG,"abc:onClicked");
        if(btn.getId()==R.id.btn_dollar)
        {
            //dollar
        }else if (btn.getId()==R.id.btn_euro){
            //euro
        }else{
            //won
        }
    }

    //处理open按钮：传参到其他页面
    public void openOne(View btn){
        Intent config = new Intent(this, MainActivity32_2.class);//启动跳转必要的一
        //从左参数布局 跳转到右参数布局

        //方法一：页面参数传递：这种方式没办法取回参数，会陷入循环，所以用bundle
        //config.putExtra("dollar_rate_key",dollarRate);
        //config.putExtra("euro_rate_key",euroRate);
        //config.putExtra("won_rate_key",wonRate);

        //方法二：用bundle传参给其他页面
        Bundle bundle = new Bundle();
        bundle.putFloat("dollar_rate_key",dollarRate);
        bundle.putFloat("euro_rate_key",euroRate);
        bundle.putDouble("won_rate_key",wonRate);
        config.putExtras(bundle);

        Log.i(TAG,"openOne:dollarRate=" + dollarRate);
        Log.i(TAG,"openOne:euroRate=" + euroRate);
        Log.i(TAG,"openOne:wonRate=" + wonRate);
        //startActivity(config);//启动跳转 必要的二  打开新窗口  参数与Intent变量的命名一致

        //跳转页面
        startActivityForResult(config,0);//此处的requestCode应与下面结果处理函数调用的requestCode一致

    }

    //返回参数:结果处理函数
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //用bundle从其他页面获得参数
        Bundle bundle = data.getExtras();
        dollarRate= bundle.getFloat("dollar_rate_key",0);
        euroRate = bundle.getFloat("euro_rate_key",0);
        wonRate = bundle.getFloat("won_rate_key",0);
        /**
        if(requestCode==0 && requestCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            String text = null;
            if(bundle!=null){
                    text = bundle.getString("second");//why second?
            }
            Log.d("text",text);
            //将结果取回后的操作
            editText = (EditText)findViewById(R.id.editText);
            editText.setText(text);

        }
         */
    }

    //菜单栏：在activity中启用菜单栏
    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);//这里关联了res/menu/menu.xml
        return true;
    }

    //菜单栏：处理菜单事件
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();//消息提示
        if (item.getItemId()==R.menu.menu)//这里找的是menu.xml里面的控件的ID
        {
            //事件处理代码
        }
        return super.onOptionsItemSelected(item);
    }
}