package com.example.spinner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spinner.entity.Bank;
import com.example.spinner.entity.Bank2;
import com.example.spinner.util.CustomAdapter;
import com.example.spinner.util.SpinnerAdapter;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Context mContext;
    //判断是否为刚进去时触发第一个item的onItemSelected的标志
    private boolean one_selected = false;
    private ArrayList<Bank> mData = null;
    private BaseAdapter myAdadpter = null;
    private Spinner spinner;

    private LinkedList<Bank2> mData2 = null;
    private SpinnerAdapter spAdapter = null;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        init();
        init2();
    }

    private void init() {
        mData = new ArrayList<Bank>();
        mData.add(new Bank(R.drawable.boc, "中国银行"));
        mData.add(new Bank(R.drawable.bms, "民生银行"));
        mData.add(new Bank(R.drawable.bzs, "招商银行"));
        mData.add(new Bank(R.drawable.bjt, "中国交通银行"));
        mData.add(new Bank(R.drawable.abc, "中国农业银行"));
        mData.add(new Bank(R.drawable.ccb, "中国建设银行"));
        mData.add(new Bank(R.drawable.icbc, "中国工商银行"));

        myAdadpter = new CustomAdapter<Bank>(mData, R.layout.spinner_item) {
            @Override
            public void bindView(ViewHolder holder, Bank obj) {
                holder.setImageResource(R.id.bankIcon, obj.getBankIcon());
                holder.setText(R.id.bankName, obj.getBankName());
            }
        };

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(myAdadpter);
        spinner.setOnItemSelectedListener(this);
    }

    private void init2() {
        mData2 = new LinkedList<Bank2>();
        mData2.add(new Bank2(R.drawable.bjt, "中国交通银行", "尾号为：4213"));
        mData2.add(new Bank2(R.drawable.abc, "中国农业银行", "尾号为：4213"));
        mData2.add(new Bank2(R.drawable.icbc, "中国工商银行", "尾号为：4213"));
        spAdapter = new SpinnerAdapter(mContext, mData2);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setAdapter(spAdapter);
    }

    /**
     *one_selected判断说明
     * Spinner会默认选中第一个值,并且会默认触发一次OnItemSelectedListener 事件
     * 解决方式：
     * 添加一个boolean值，然后设置 为false，
     * 在onItemSelected时进行判断，false说明是默认触发的，不做任何操作然后将boolean值设置为true；
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(one_selected){
            TextView text = (TextView) view.findViewById(R.id.bankName);
            Toast.makeText(mContext, text.getText().toString(), Toast.LENGTH_SHORT).show();
        }else {
            one_selected = true;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
