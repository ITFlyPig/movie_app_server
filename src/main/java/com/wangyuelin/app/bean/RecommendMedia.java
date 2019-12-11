package com.wangyuelin.app.bean;

import java.io.Serializable;

/**
 * 这里可能承载电影、电视剧、动漫等
 */
public class RecommendMedia implements Serializable {
    private long id;
    private String name;//名称
    private float rank;//评分
    private String cover;//封面
    private String type;//类型 恐怖片、动作片等

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
