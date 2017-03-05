package com.example.toast;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Btn_showToast, Btn_showToast2;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        Btn_showToast = (Button) findViewById(R.id.showToast);
        Btn_showToast.setOnClickListener(this);

        Btn_showToast2 = (Button) findViewById(R.id.showToast2);
        Btn_showToast2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.showToast:
                myToast("获取信息失败", Toast.LENGTH_SHORT);
                break;
            case R.id.showToast2:
                bottomToast("获取信息失败", Toast.LENGTH_SHORT);
                break;
        }
    }

    //设置Toast内元素样式
    private void myToast(String str, int showTime){
        Toast toast = Toast.makeText(mContext, str, showTime);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.getView().setBackgroundColor(Color.GRAY);
        TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(18);
        toast.show();
    }

    //自定义Toast样式
    private void bottomToast(String str, int showTime)
    {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_custom, (ViewGroup) findViewById(R.id.my_toast));

        ImageView img_logo = (ImageView) view.findViewById(R.id.toastImg);
        img_logo.setImageResource(R.drawable.toastimg);
        TextView tv_msg = (TextView) view.findViewById(R.id.toastMessage);
        tv_msg.setText(str);

        Toast toast = new Toast(mContext);
        toast.setGravity(Gravity.BOTTOM, 0, 100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        //toast.show();
        showMyToast(toast, 1*1000);
    }

    //控制Toast显示时间
    public void showMyToast(final Toast toast, final int showTime){
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, showTime );
    }
}
