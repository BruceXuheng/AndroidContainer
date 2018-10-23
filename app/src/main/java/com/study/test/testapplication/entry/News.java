package com.study.test.testapplication.entry;

/**
 * Create by BruceXuheng on 2018/6/4
 * description :
 **/

public class News {

    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }
}