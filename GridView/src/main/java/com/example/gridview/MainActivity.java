package com.example.gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gridview.entity.Icon;
import com.example.gridview.util.CustomAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private GridView gridView;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        init();
    }

    private void init() {
        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.drawable.icon1, "空间"));
        mData.add(new Icon(R.drawable.icon2, "搜索"));
        mData.add(new Icon(R.drawable.icon3, "笔记"));
        mData.add(new Icon(R.drawable.icon4, "计时"));
        mData.add(new Icon(R.drawable.icon5, "工具"));
        mData.add(new Icon(R.drawable.icon6, "工具箱"));
        mData.add(new Icon(R.drawable.icon7, "短消息"));
        mData.add(new Icon(R.drawable.icon8, "备忘录"));
        mData.add(new Icon(R.drawable.icon9, "浏览器"));

        mAdapter = new CustomAdapter<Icon>(mData,R.layout.grid_item) {

            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getIconID());
                holder.setText(R.id.txt_icon, obj.getIconName());
            }
        };

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                TextView text = (TextView) view.findViewById(R.id.txt_icon);
                Toast.makeText(mContext, text.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
