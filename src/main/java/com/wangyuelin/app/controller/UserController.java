package com.wangyuelin.app.controller;

import com.wangyuelin.app.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    private ITest test;
//
//
    @RequestMapping("/getOneUser")
    @ResponseBody
    public RespBean getOneUser(){

        HomeBean homeBean = new HomeBean();

        Banner banner = new Banner();
        banner.setUrl("baidu");
        ArrayList<Banner> banners = new ArrayList<Banner>();
        banners.add(banner);
        homeBean.setBanners(banners);

        RecommendMedia recommendMedia = new RecommendMedia();
        recommendMedia.setName("遇见你");
        ArrayList<RecommendMedia> recommendMedias = new ArrayList<RecommendMedia>();
        recommendMedias.add(recommendMedia);
        HashMap<String, Object> recommendMediaMap = new HashMap<String, Object>();
        recommendMediaMap.put("type", 1);
        recommendMediaMap.put("list", recommendMedias);

        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        list.add(recommendMediaMap);
        homeBean.setMovies(list);

        return new RespBean(1000, "请求成功", homeBean);
    }
//
//
//    @RequestMapping("/getAll")
//    @ResponseBody
//    public List<User> getAll(){
//        logger.info("getOneUser");
//        return test.getAll();
//    }

}
