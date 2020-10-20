package com.swufe.mobl_devlp_cls_zf_jm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//week2 温度转换+上传Github

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //private static String TAG = "aaaa";
    TextView out;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//加载布局，其他代码必须再次之后

        //TextView tv = findViewById(R.id.textView);
        // tv.setText("hello world");
        //not work can not change the show words

        out = (TextView) findViewById(R.id.textView2);
        edit = (EditText) findViewById(R.id.inp);
        Button btn = (Button)  findViewById(R.id.button);
        btn.setOnClickListener(this);

        // Log.d("change t to f", "onCreate：");// 后面的数据是msg的参数

        //  EditText input = findViewById(R.id.inp);
        //String str = input.getText().toString();

        //TextView tv3 = findViewById(R.id.textView3);

    }

    //监听
    // public void abc(View v){
    //   Log.i(TAG, "abc:onclicked");
    //}
    //计算在加载之后/输入之后计算，不要写在oncreate里面，点击按钮之后计算
    public void onClick(View v){
        String str = edit.getText().toString();
        double   d   =   Double.parseDouble(str);
        double d2=32+1.8*d;

        out.setText(d2+"");
    }

}