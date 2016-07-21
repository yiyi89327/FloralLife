package com.yunmeng.florallife.bean;

import java.io.Serializable;

/**
 * Created by my on 2016/7/21.
 */
public class AuthorFans implements Serializable {

    private String userName;
    private int userIconId;

    public AuthorFans(String userName, int userIconId) {
        this.userName = userName;
        this.userIconId = userIconId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserIconId() {
        return userIconId;
    }

    public void setUserIconId(int userIconId) {
        this.userIconId = userIconId;
    }
}
