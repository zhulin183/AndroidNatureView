package com.example.spinner.entity;

/**
 * Created by user on 2017/3/3.
 */

public class Bank {

    private int bankIcon;
    private String bankName;

    public Bank(){}

    public Bank(int bankIcon, String bankName){
        this.bankIcon = bankIcon;
        this.bankName = bankName;
    }

    public int getBankIcon() {
        return bankIcon;
    }

    public void setBankIcon(int bankIcon) {
        this.bankIcon = bankIcon;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


}
