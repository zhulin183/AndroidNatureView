package com.example.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.viewpager.util.MyPagerAdapter2;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {

    private ViewPager vpager_two;
    private ArrayList<View> aList;
    private ArrayList<String> sList;
    private MyPagerAdapter2 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        vpager_two = (ViewPager) findViewById(R.id.vpager_two);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_two,null,false));
        aList.add(li.inflate(R.layout.view_three, null, false));
        sList = new ArrayList<String>();
        sList.add("Page1");
        sList.add("Page2");
        sList.add("Page3");
        mAdapter = new MyPagerAdapter2(aList,sList);
        vpager_two.setAdapter(mAdapter);
    }
}
