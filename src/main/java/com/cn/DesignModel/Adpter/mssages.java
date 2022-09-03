package com.cn.DesignModel.Adpter;

/**
 * 类名:mssages
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-12-01 17:29
 **/
public class mssages {

    private Long id;

    private String date;

    private String content;

    public mssages() {
    }

    public mssages(Long id, String date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    @Override
    public String toString() {
        return "mssages{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
