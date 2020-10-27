package com.swufe.mobl_devlp_cls_zf_jm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity32_2 extends AppCompatActivity {
    private static final String TAG = "MainActivity2";

    EditText out,out2,out3;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_activity32_main2);
        Intent intent = getIntent();
        //方法一：用extra获取传过来的参数
        //float  dollar2 = intent.getFloatExtra("dollar_rate_key",0);
        //float  euro2 = intent.getFloatExtra("euro_rate_key",0);
        //float  won2 = intent.getFloatExtra("won_rate_key",0);

        //方法二：用bundle获取传过来的参数
        Bundle bundle = intent.getExtras();
        float dollar2=bundle.getFloat("dollar_rate_key",0);
        float euro2=bundle.getFloat("euro_rate_key",0);
        float won2=bundle.getFloat("won_rate_key",0);
        //输出到日志
        Log.i(TAG,"dollar2="+dollar2);
        Log.i(TAG,"euro2="+euro2);
        Log.i(TAG,"won2="+won2);

        //把汇率输出到文本框内
        out = (EditText)findViewById(R.id.editText3);
        out.setText(String.valueOf(dollar2));
        out2 = (EditText)findViewById(R.id.editText4);
        out2.setText(String.valueOf(euro2));
        out3 = (EditText)findViewById(R.id.editText5);
        out3.setText(String.valueOf(won2));

        send = (Button)findViewById(R.id.btn_send);

    }

    //这种方式不需要这个函数
    public void showRate(View v){
       // out.setText("");
    }

    //将改动后的数字保存并传回给其他页面
    public void send_back(View btn){

        String str1=out.getText().toString();
        String str2=out2.getText().toString();
        String str3=out3.getText().toString();

        if(btn.getId()==R.id.btn_send){
            Intent intent = getIntent();
            Bundle bundle = new Bundle();
           // bundle.putFloat("second", );
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}