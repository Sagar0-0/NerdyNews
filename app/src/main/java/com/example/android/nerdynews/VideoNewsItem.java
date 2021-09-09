package com.example.android.nerdynews;

public class VideoNewsItem {
    private String image;
    private String channelName;
    private String headline;
    private String time;
    private String url;

    public VideoNewsItem(String image,String headline,String channelName,String time,String url){
        this.image=image;
        this.channelName=channelName;
        this.headline=headline;
        this.time=time;
        this.url=url;
    }

    public String getImage() {
        return image;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getHeadline() {
        return headline;
    }

    public String getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }
}
