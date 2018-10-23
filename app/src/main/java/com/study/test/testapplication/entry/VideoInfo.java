package com.study.test.testapplication.entry;

/**
 * Create by BruceXuheng on 2018/5/30
 * description :
 **/

public class VideoInfo {

    private String videoURL;

    private String videoTitle;

    public VideoInfo(String videoURL, String videoTitle) {
        this.videoURL = videoURL;
        this.videoTitle = videoTitle;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }
}