package com.bwie.myrecyclerview.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/2/22.
 */
public class Rs {
    private String dirName;
    private List<Children> children;

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Rs{" +
                "dirName='" + dirName + '\'' +
                ", children=" + children +
                '}';
    }
}
