package com.bwie.myrecyclerview.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/2/22.
 */
public class Children {
    private String dirName;
    private List<Children2> children;

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public List<Children2> getChildren() {
        return children;
    }

    public void setChildren(List<Children2> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Children{" +
                "dirName='" + dirName + '\'' +
                ", children=" + children +
                '}';
    }
}
