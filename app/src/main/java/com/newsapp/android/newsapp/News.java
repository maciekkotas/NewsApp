package com.newsapp.android.newsapp;

/**
 * Created by macie on 22.06.2017.
 */

public class News {

    private String mTitle;
    private String mInfo;
    private String mImageId;
    private String mDate;
    private String mWebUrl;

    public News(String title, String info, String date, String imageId, String webUrl) {
        mTitle = title;
        mInfo = info;
        mImageId = imageId;
        mDate = date;
        mWebUrl = webUrl;

    }

    public String getTitle() {
        return mTitle;
    }

    public String getInfo() {
        return mInfo;
    }

    public String getImageId() {
        return mImageId;
    }

    public String getDate() {
        return mDate;
    }

    public String getWebUrl() {
        return mWebUrl;
    }
}
