package com.example.listview.entity;

/**
 * Created by zhu_lin on 2017/2/27.
 */

public class News {

    private int newsImgId;
    private String newsTitle;
    private String newsFrom;
    private String newsCommCount;

    public News(int newsImgId, String newsTitle, String newsFrom, String newsCommCount){
        this.newsImgId = newsImgId;
        this.newsTitle = newsTitle;
        this.newsFrom = newsFrom;
        this.newsCommCount = newsCommCount;
    }

    public int getNewsImgId() {
        return newsImgId;
    }

    public void setNewsImgId(int newsImgId) {
        this.newsImgId = newsImgId;
    }

    public String getNewsCommCount() {
        return newsCommCount;
    }

    public void setNewsCommCount(String newsCommCount) {
        this.newsCommCount = newsCommCount;
    }

    public String getNewsFrom() {
        return newsFrom;
    }

    public void setNewsFrom(String newsFrom) {
        this.newsFrom = newsFrom;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

}
