package com.wangyuelin.app.service;

import com.wangyuelin.app.bean.Banner;
import com.wangyuelin.app.bean.HomeMovieBean;
import com.wangyuelin.app.bean.MovieDetail;
import com.wangyuelin.app.bean.RecommendMedia;
import com.wangyuelin.app.mapper.BannerMapper;
import com.wangyuelin.app.mapper.MovieMapper;
import com.wangyuelin.app.mapper.RecommendMovieMapper;
import com.wangyuelin.app.mapper.TypeMapper;
import com.wangyuelin.app.service.itf.IMovie;
import com.wangyuelin.app.utils.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @outhor wangyuelin
 * @create 2018-06-25 下午4:21
 */
@Service
public class MovieService implements IMovie {
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private RecommendMovieMapper recMapper;
    @Autowired
    private TypeMapper typeMapper;


    @Override
    public List<Banner> getBanners(int categoryId) {
        return bannerMapper.getBanners(categoryId);
    }

    @Override
    public List<HashMap<String, Object>> getRecs() {
        //查出所有分类
        List<Map<String, Object>> types = typeMapper.getAllTypes();
        if (types == null || types.size() == 0) {
            return null;
        }
        List<HashMap<String, Object>> results = new ArrayList<HashMap<String, Object>>();
        for (Map<String, Object> typeMap : types) {
            //获取type 的id
            Object idObj = typeMap.get("id");
            Integer typeId = idObj == null ? null : (Integer)idObj;
            Object nameObj = typeMap.get("value");
            Integer type = nameObj == null ? null : TextUtil.toInteger(String.valueOf(nameObj));
            String typeName = typeMap.get("name") == null ? null : String.valueOf(typeMap.get("name") + "片");
            if (typeId != null && type != null) {
                List<RecommendMedia> recommendMedias = recMapper.getRecMovies(typeId, 2019, 7);
                HashMap<String, Object> recMap = new HashMap<String, Object>();
                recMap.put("type", type);
                recMap.put("typeName", typeName);
                recMap.put("list", recommendMedias);
                results.add(recMap);
            }

        }
        return results;
    }
}