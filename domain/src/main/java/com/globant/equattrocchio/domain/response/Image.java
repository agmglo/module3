package com.globant.equattrocchio.domain.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Image extends RealmObject {
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int imageId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("large_url")
    @Expose
    private String largeUrl;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("site")
    @Expose
    private String site;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer id) {
        this.imageId = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
