
package com.example.android.nerdynews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
