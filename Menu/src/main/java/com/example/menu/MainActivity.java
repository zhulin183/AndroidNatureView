package com.example.menu;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Toast mToast;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
//        MenuInflater menuInflater = new MenuInflater(this);
//        menuInflater.inflate(R.menu.menu, menu);
//        menu.add(Menu.NONE, Menu.FIRST + 1, 1, "编辑").setIcon(R.drawable.ic_menu_edit);
//        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "文件").setIcon(R.drawable.ic_menu_file);
//        menu.add(Menu.NONE, Menu.FIRST + 3, 3, "关于").setIcon(R.drawable.ic_menu_about);

//        super.onCreateOptionsMenu(menu);
//        MenuInflater inflater = new MenuInflater(getApplicationContext());
//        inflater.inflate(R.menu.menu, menu);
//        setMenuBackground();

        return true;
    }

    /** 设置Menu的背景图
     * 报错，有待调试
     * 原因：所继承自AppCompatActivity中已实现了LayoutInflaterCompat.setFactory
     * */
    protected void setMenuBackground() {

        LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                // 指定自定义inflate的对象
                if (name.equalsIgnoreCase("com.android.internal.view.menu.IconMenuItemView")) {
                    try {
                        LayoutInflater f = LayoutInflater.from(context);
                        final View view = f.createView(name, null, attrs);
                        new Handler().post(new Runnable() {
                            public void run() {
                                // 设置背景图片
                                view.setBackgroundResource(R.color.menu);
                            }
                        });
                        return view;
                    } catch (InflateException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case Menu.FIRST + 1:
            case R.id.action_edit:
                showToast("编辑");
                break;
            case Menu.FIRST + 2:
            case R.id.action_file:
                showToast("文件");
                break;
            case R.id.action_favorite:
                showToast("收藏");
                break;
            case R.id.action_share:
                showToast("分享");
                break;
            case Menu.FIRST + 3:
            case R.id.action_about:
                showToast("关于");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**Toast单例模式*/
    public static Toast getInstance(){
        if(mToast == null){
            mToast = Toast.makeText(mContext, "", Toast.LENGTH_LONG);
            mToast.setGravity(Gravity.BOTTOM, 0, 0);
        }
        return mToast;
    }

    /**显示toast*/
    public void showToast(String str){
        Toast toast = getInstance();
        toast.setText(str);
        toast.show();
    }
}
