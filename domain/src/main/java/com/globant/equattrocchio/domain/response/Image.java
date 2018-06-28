package com.globant.equattrocchio.domain.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = Image.TABLE_NAME)
public class Image extends Model implements Parcelable {
    static final String TABLE_NAME = "images";
    private static final String COLUMN_ID = "imageId";
    private static final String COLUMN_URL = "url";
    private static final String COLUMN_LARGE_URL = "largeUrl";
    @Column(name = COLUMN_ID)
    @SerializedName("id")
    @Expose
    private Integer imageId;
    @Column(name = COLUMN_URL)
    @SerializedName("url")
    @Expose
    private String url;
    @Column(name = COLUMN_LARGE_URL)
    @SerializedName("large_url")
    @Expose
    private String largeUrl;
    @SerializedName("source_id")
    @Expose
    private Object sourceId;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("site")
    @Expose
    private String site;

    private Image(Parcel in) {
        if (in.readByte() == 0) {
            imageId = null;
        } else {
            imageId = in.readInt();
        }
        url = in.readString();
        largeUrl = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

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

    public Object getSourceId() {
        return sourceId;
    }

    public void setSourceId(Object sourceId) {
        this.sourceId = sourceId;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(url);
        dest.writeString(largeUrl);
    }
}
