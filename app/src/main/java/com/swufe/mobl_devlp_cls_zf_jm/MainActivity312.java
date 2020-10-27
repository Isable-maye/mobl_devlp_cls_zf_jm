package com.swufe.mobl_devlp_cls_zf_jm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity312 extends AppCompatActivity implements View.OnClickListener{
    TextView out,out2;//输出文本
    Button btn,btn2,btn3,btn4,btn5,btn6,btn7;//输入
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main312);

        out = (TextView) findViewById(R.id.textView);//第一个计分器得分
        out2 = (TextView) findViewById(R.id.textView2);//第二个计分器得分

        //button就是input
        btn = (Button)  findViewById(R.id.button);
        btn.setOnClickListener(this);

        btn2 = (Button)  findViewById(R.id.button2);
        btn2.setOnClickListener(this);

        btn3 = (Button)  findViewById(R.id.button3);
        btn3.setOnClickListener(this);

        btn4 = (Button)  findViewById(R.id.button4);
        btn4.setOnClickListener(this);

        btn5 = (Button)  findViewById(R.id.button5);
        btn5.setOnClickListener(this);

        btn6 = (Button)  findViewById(R.id.button6);
        btn6.setOnClickListener(this);

        btn7 = (Button)  findViewById(R.id.button7);
        btn7.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String str = out.getText().toString();
        String str2 = out2.getText().toString();
        int d =  Integer.parseInt(str);
        int d2 = Integer.parseInt(str2);
        switch (v.getId()){
            case R.id.button:
                out.setText(String.valueOf(d+3));
                break;
            case R.id.button2:
                //d=d+2;
                String s2 = String.valueOf(d+2);
                out.setText(s2);
                break;
            case R.id.button3:
                String s3 = String.valueOf(d);
                out.setText(s3);
                break;
            case R.id.button4:
               // d2=d2+3;
                String s4 = String.valueOf(d2+3);
                out2.setText(s4);
                break;
            case R.id.button5:
               // d2=d2+2;
                String s5 = String.valueOf(d2+2);
                out2.setText(s5);
                break;
            case R.id.button6:
                String s6 = String.valueOf(d2);
                out2.setText(s6);
                break;
            case R.id.button7:
                out.setText("0");
                out2.setText("0");
                break;
        }
    }
}