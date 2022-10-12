package com.cn.DesignModel.adpter;

import java.util.Date;

/**
 * 类名:account
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-12-02 11:49
 **/
public class account {

    private Long uid;

    private Date newdate;

    private String name;

    private String desc;

    public account() {
    }

    @Override
    public String toString() {
//        return "account{" +
//                "uid=" + uid +
//                ", uid=" + newdate +
//                ", uid='" + name + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
        return "{\"uid\":\"" + uid + "\", \"newdate\":\"" + newdate + "\", " +
                "\"name\":\"" + name + "\", \"desc\":\"" + desc + "\"}";
    }

    public account(Long uid, Date date, String name, String desc) {
        this.uid = uid;
        this.newdate = date;
        this.name = name;
        this.desc = desc;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return newdate;
    }

    public void setDate(Date date) {
        this.newdate = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
