package com.example.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContent;
    private NotificationManager mNManager;
    private Notification mNotify1;
    Bitmap LargeBitmap = null;
    private Button showN, closeN;
    private static final int NOTIFYID_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContent = MainActivity.this;
        init();
    }

    private void init() {
        LargeBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_notifyicon);
        mNManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        showN = (Button) findViewById(R.id.btn_showNotify);
        closeN = (Button) findViewById(R.id.btn_closeNotify);
        showN.setOnClickListener(this);
        closeN.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_showNotify:
                //定义一个PendingIntent点击Notification后启动一个Activity
                Intent it = new Intent(mContent,ContextActivity.class);
                PendingIntent pit = PendingIntent.getActivity(mContent, 0, it, 0);

                //设置图片,通知标题,发送时间,提示方式等属性
                Notification.Builder mBuilder = new Notification.Builder(this);
                mBuilder.setContentTitle("至尊宝")       //设置大标题
                        .setContentText("曾经有一份真挚的感情摆在我的面前我没有珍惜，等我失去的时候才追悔莫及，人间最痛苦的事莫过于此...")  //设置内容
                        .setSubText("—爱你一万年")      //内容下面的一小段文字
                        .setTicker("收到至尊宝的来信。") //状态栏显示文字
                        .setLargeIcon(LargeBitmap)       //大图标
                        .setSmallIcon(R.mipmap.ic_notify_smallicon)  //小图标及状态栏图标
                        .setWhen(System.currentTimeMillis())   //消息时间
                        .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS)  //设置消息提示震动及灯光
                        .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dingling))  //设置消息提示音
                        .setAutoCancel(true)             //设置点击后取消Notification
                        .setContentIntent(pit);           //设置PendingIntent
                mNotify1 = mBuilder.build();
                mNManager.notify(NOTIFYID_1, mNotify1);
                break;
            case R.id.btn_closeNotify:
                //除了可以根据ID来取消Notification外,还可以调用cancelAll();关闭该应用产生的所有通知
                mNManager.cancel(NOTIFYID_1);           //取消Notification
                break;
        }
    }
}
