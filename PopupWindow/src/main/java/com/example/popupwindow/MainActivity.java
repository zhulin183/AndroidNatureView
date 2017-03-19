package com.example.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.popupwindow.entity.Friend;
import com.example.popupwindow.util.CustomAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private ArrayList<Friend> mData = null;
    private CustomAdapter<Friend> customAdapter = null;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mContext = MainActivity.this;
        init();
    }

    private void init() {
        mData = new ArrayList<Friend>();
        mData.add(new Friend("赵日天", "下午4:20", "明天出去浪啊~~", R.mipmap.head1));
        mData.add(new Friend("叶良辰", "下午4:30", "我叶良辰表示不服~~", R.mipmap.head2));
        mData.add(new Friend("龙傲天", "下午4:30", "来啊~造作啊~", R.mipmap.head3));

        customAdapter = new CustomAdapter<Friend>(mData, R.layout.list_item) {
            @Override
            public void bindView(ViewHolder holder, Friend obj) {
                holder.setImageResource(R.id.friendIcon, obj.getFriendicon());
                holder.setText(R.id.friendname, obj.getName());
                holder.setText(R.id.friendtime, obj.getTime());
                holder.setText(R.id.friendcontent, obj.getContent());
            }
        };

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(customAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                initPopWindow(view);
                return false;
            }
        });
    }

    private void initPopWindow(View v) {
        View popView = LayoutInflater.from(mContext).inflate(R.layout.pop_item, null, false);
        Button btn_toTop = (Button) popView.findViewById(R.id.btn_toTop);
        Button btn_delete = (Button) popView.findViewById(R.id.btn_delete);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        final PopupWindow popWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //2.设置加载动画
        popWindow.setAnimationStyle(R.anim.anim_pop);
        //3.点击非PopupWindow区域，让PopupWindow会消失设置，
        // 如果没有下面的代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popWindow.setTouchable(true);
        popWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        //4.要为popWindow设置一个背景才有效
        popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //5.设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        //测量View的宽高
        popView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int popupWidth = popView.getMeasuredWidth();
        int popupHeight = popView.getMeasuredHeight();
        int xoffset = (v.getWidth() - popupWidth) /2;
        //popWindow.showAsDropDown(v, xoffset, 0);
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        popWindow.showAtLocation(v, Gravity.NO_GRAVITY, xoffset, location[1] - popupHeight);

        //6.设置popupWindow里的按钮的事件
        btn_toTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "置顶", Toast.LENGTH_SHORT).show();
                popWindow.dismiss();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
                popWindow.dismiss();
            }
        });

    }


}
