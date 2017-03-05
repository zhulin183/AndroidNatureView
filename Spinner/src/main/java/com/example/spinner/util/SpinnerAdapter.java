package com.example.spinner.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spinner.R;
import com.example.spinner.entity.Bank2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhu_lin on 2017/3/4.
 */

public class SpinnerAdapter extends ArrayAdapter {

    private Context mContext;
    private LinkedList<Bank2> mData;

    public SpinnerAdapter(Context context, LinkedList<Bank2> mData) {
        super(context, R.layout.simple_spinner_item, mData);
        this.mContext = context;
        this.mData = mData;
    }

    //getdropdownview决定了item中显示的样式
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.simple_spinner_dropdown_item, parent, false);
        }
        ImageView BankIcon = (ImageView) convertView.findViewById(R.id.bankIcon2);
        TextView BankName = (TextView) convertView.findViewById(R.id.bankName2);
        TextView BankNum = (TextView) convertView.findViewById(R.id.bankNum2);
        BankIcon.setImageResource(mData.get(position).getBankIcon());
        BankName.setText(mData.get(position).getBankName());
        BankNum.setText(mData.get(position).getBankNum());
        return convertView;
    }

    //getview修改了spinner中显示的样式
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.simple_spinner_item, parent, false);
        }
        ImageView BankIcon = (ImageView) convertView.findViewById(R.id.bankIcon2);
        TextView BankName = (TextView) convertView.findViewById(R.id.bankName2);
        TextView BankNum = (TextView) convertView.findViewById(R.id.bankNum2);
        BankIcon.setImageResource(mData.get(position).getBankIcon());
        BankName.setText(mData.get(position).getBankName());
        BankNum.setText(mData.get(position).getBankNum());
        return convertView;
    }


}
