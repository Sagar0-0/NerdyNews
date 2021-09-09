package com.example.android.nerdynews;

public class HomeNewsItem {
    private String image;
    private String channelName;
    private String headline;
    private String time;
    private String url;
    private String id;
    private String sectionName;

    public HomeNewsItem(String image,String headline,String channelName,String time,String url,String id,String sectionname){
        this.image=image;
        this.channelName=channelName;
        this.headline=headline;
        this.time=time;
        this.url=url;
        this.id=id;
        this.sectionName=sectionname;
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

    public String getId() {
        return id;
    }

    public String getSectionName() {
        return sectionName;
    }
}
