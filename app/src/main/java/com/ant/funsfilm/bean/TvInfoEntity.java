package com.ant.funsfilm.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by admin on 2017/4/7.
 */

public class TvInfoEntity extends ResultEntity implements MultiItemEntity {

    public static final int CLICK_ITEM_VIEW = 1;

    private String name;
    private String tvImage;
    private String tvUrl;
    private String publishTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTvImage() {
        return tvImage;
    }

    public void setTvImage(String tvImage) {
        this.tvImage = tvImage;
    }

    public String getTvUrl() {
        return tvUrl;
    }

    public void setTvUrl(String tvUrl) {
        this.tvUrl = tvUrl;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int Type;

    public TvInfoEntity(final int type) {
        Type = type;
    }

    @Override
    public int getItemType() {
        return Type;
    }
}
