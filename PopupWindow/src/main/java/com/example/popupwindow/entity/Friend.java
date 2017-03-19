package com.example.popupwindow.entity;

/**
 * Created by user on 2017/3/18.
 */

public class Friend {

    private String name;
    private String time;
    private String content;
    private int friendicon;

    public Friend(String name, String time, String content, int friendicon){
        this.name = name;
        this.time = time;
        this.content = content;
        this.friendicon = friendicon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFriendicon() {
        return friendicon;
    }

    public void setFriendicon(int friendicon) {
        this.friendicon = friendicon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
