package com.bwie.myrecyclerview.bean;

/**
 * Created by lenovo on 2017/2/22.
 */
public class Children2 {
    private String dirName;
    private String imgApp;

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getImgApp() {
        return imgApp;
    }

    public void setImgApp(String imgApp) {
        this.imgApp = imgApp;
    }

    @Override
    public String toString() {
        return "Children2{" +
                "dirName='" + dirName + '\'' +
                ", imgApp='" + imgApp + '\'' +
                '}';
    }
}
