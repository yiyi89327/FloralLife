package com.yunmeng.florallife.bean;

/**
 * Created by 59857 on 2016/7/21.
 */
public class Databean {

    private String num;
    private String psw;

    @Override
    public String toString() {
        return "Databean{" +
                "num='" + num + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }

    public Databean() {
    }

    public Databean(String num, String psw) {
        this.num = num;
        this.psw = psw;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
