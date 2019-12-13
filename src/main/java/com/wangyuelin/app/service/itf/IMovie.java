package com.wangyuelin.app.service.itf;

import com.wangyuelin.app.bean.Banner;
import com.wangyuelin.app.bean.HomeMovieBean;
import com.wangyuelin.app.bean.MovieDetail;
import com.wangyuelin.app.bean.RecommendMedia;

import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 *
 * @outhor wangyuelin
 * @create 2018-06-25 下午4:21
 */
public interface IMovie {
    /**
     * 获取电影首页的banner数据
     * @param categoryId
     * @return
     */
    List<Banner> getBanners(int categoryId);

    /**
     * 获取推荐的数据
     * @return
     */
    List<HashMap<String, Object>> getRecs();
}