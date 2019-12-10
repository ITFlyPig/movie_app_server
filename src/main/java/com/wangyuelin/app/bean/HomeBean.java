package com.wangyuelin.app.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeBean {
    private List<Banner> banners;
    private List<HashMap<String, Object>> movies;

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public List<HashMap<String, Object>> getMovies() {
        return movies;
    }

    public void setMovies(List<HashMap<String, Object>> movies) {
        this.movies = movies;
    }
}
