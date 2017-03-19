package com.example.alertdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_dialog_one;
    private Button btn_dialog_two;
    private Button btn_dialog_three;
    private Button btn_dialog_four;

    private Context mContext;
    private boolean[] checkItems;

    //setView自定义Dialog样式
    private Button btn_show;
    private View view_custom;

    private AlertDialog alertDialog = null;
    private AlertDialog.Builder builder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        init();
    }

    private void init() {
        btn_dialog_one = (Button) findViewById(R.id.btn_dialog_one);
        btn_dialog_two = (Button) findViewById(R.id.btn_dialog_two);
        btn_dialog_three = (Button) findViewById(R.id.btn_dialog_three);
        btn_dialog_four = (Button) findViewById(R.id.btn_dialog_four);
        btn_show = (Button) findViewById(R.id.btn_dialog_custom);
        btn_dialog_one.setOnClickListener(this);
        btn_dialog_two.setOnClickListener(this);
        btn_dialog_three.setOnClickListener(this);
        btn_dialog_four.setOnClickListener(this);
        btn_show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dialog_one:
                alertDialog = null;
                builder = new AlertDialog.Builder(mContext);
                alertDialog = builder.setIcon(R.mipmap.alert_icon)
                        .setTitle("警告：")
                        .setMessage("信息获取失败")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "确定", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("中立", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "中立", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
                            }
                        }).setCancelable(false)
                        .create();
                alertDialog.show();
                break;
            case R.id.btn_dialog_two:
                final String[] lesson = new String[]{"JavaWeb", "PHP", "Android", "ASP.Net", "IOS"};
                alertDialog = null;
                builder = new AlertDialog.Builder(mContext);
                alertDialog = builder.setIcon(R.mipmap.alert_icon)
                        .setTitle("选择你喜欢的课程")
                        .setItems(lesson, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "你选择了" + lesson[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelable(false)
                        .create();
                alertDialog.show();
                break;
            case R.id.btn_dialog_three:
                final String[] lesson2 = new String[]{"JavaWeb", "PHP", "Android", "ASP.Net", "IOS"};
                alertDialog = null;
                builder = new AlertDialog.Builder(mContext);
                alertDialog = builder.setIcon(R.mipmap.alert_icon)
                        .setTitle("选择你喜欢的课程")
                        .setSingleChoiceItems(lesson2, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "你选择了" + lesson2[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
                break;
            case R.id.btn_dialog_four:
                final String[] lesson3 = new String[]{"JavaWeb", "PHP", "Android", "ASP.Net", "IOS"};
                alertDialog = null;
                //定义一个用来记录个列表项状态的boolean数组
                checkItems = new boolean[]{false, false, false, false, false};
                builder = new AlertDialog.Builder(mContext);
                alertDialog = builder.setIcon(R.mipmap.alert_icon)
                        .setTitle("选择课程")
                        .setMultiChoiceItems(lesson3, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkItems[which] = isChecked;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String result = "";
                                for (int i = 0; i < checkItems.length; i++) {
                                    if (checkItems[i])
                                        result += lesson3[i] + " ";
                                }
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelable(false)
                        .create();
                alertDialog.show();
                break;
            case R.id.btn_dialog_custom:
                alertDialog = null;
                builder = new AlertDialog.Builder(mContext);
                //加载自定义的那个View,同时设置下
                final LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                view_custom = inflater.inflate(R.layout.view_dialog_custom, null, false);
                alertDialog = builder.setView(view_custom)
                        .setCancelable(false)
                        .create();

                view_custom.findViewById(R.id.btn_cancle).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                view_custom.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "确定", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

                view_custom.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "关闭", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
                break;
        }
    }
}
