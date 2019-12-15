package com.wangyuelin.app.controller;

import com.wangyuelin.app.bean.*;
import com.wangyuelin.app.service.itf.IMovie;
import com.wangyuelin.app.utils.Constant;
import com.wangyuelin.app.utils.MovieTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @outhor wangyuelin
 * @create 2018-06-25 下午4:11
 */
@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private IMovie iMovie;

    @RequestMapping("/movieHome")
    @ResponseBody
    public RespBean getHomeMovies() {
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("banners", iMovie.getBanners(Category.MOVIE.getValue()));
        dataMap.put("movies", iMovie.getRecs());
        return new RespBean(10000, "请求成功", dataMap);
    }

    @RequestMapping("/getMovieInfo")
    @ResponseBody
    public RespBean getMovieInfo(@RequestParam long movieId) {
        Movie movie = iMovie.getMovie(movieId);
        return new RespBean(10000, "请求成功", movie);
    }



}