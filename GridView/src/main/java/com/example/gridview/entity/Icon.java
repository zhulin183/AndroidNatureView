package com.example.gridview.entity;

/**
 * Created by zhu_lin on 2017/3/2.
 */

public class Icon {

    private int IconID;
    private String IconName;

    public Icon(){}

    public Icon(int IconID, String IconName){
        this.IconID = IconID;
        this.IconName = IconName;
    }

    public int getIconID() {
        return IconID;
    }

    public void setIconID(int iconID) {
        IconID = iconID;
    }

    public String getIconName() {
        return IconName;
    }

    public void setIconName(String iconName) {
        IconName = iconName;
    }

}
