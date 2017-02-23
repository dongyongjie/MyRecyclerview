package com.bwie.myrecyclerview.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/2/22.
 */

public class RootBean {
    private List<Rs> rs;

    public List<Rs> getRs() {
        return rs;
    }

    public void setRs(List<Rs> rs) {
        this.rs = rs;
    }

    @Override
    public String toString() {
        return "RootBean{" +
                "rs=" + rs +
                '}';
    }
}
