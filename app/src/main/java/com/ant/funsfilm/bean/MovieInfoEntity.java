package com.ant.funsfilm.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by admin on 2017/4/7.
 */

public class MovieInfoEntity extends ResultEntity implements MultiItemEntity {

    public static final int CLICK_ITEM_VIEW = 1;

    private String name;
    private String url;
    private String publishTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int Type;

    public MovieInfoEntity(final int type) {
        Type = type;
    }

    @Override
    public int getItemType() {
        return Type;
    }
}
