package com.example.spinner.entity;

/**
 * Created by zhu_lin on 2017/3/4.
 */

public class Bank2 {

    private int BankIcon;
    private String BankName;
    private String BankNum;

    public Bank2(){}

    public Bank2(int BankIcon, String BankName, String BankNum){
        this.BankIcon = BankIcon;
        this.BankName = BankName;
        this.BankNum = BankNum;
    }

    public int getBankIcon() {
        return BankIcon;
    }

    public void setBankIcon(int bankIcon) {
        BankIcon = bankIcon;
    }

    public String getBankNum() {
        return BankNum;
    }

    public void setBankNum(String bankNum) {
        BankNum = bankNum;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }
}
