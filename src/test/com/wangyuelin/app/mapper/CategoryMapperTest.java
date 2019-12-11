package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.RecommendMedia;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    private RecommendMovieMapper recommendMovieMapper;
    @Autowired
    private TypeMapper typeMapper;

    @Test
    public void insert() throws Exception {
        Integer typeId = typeMapper.getId(1);
        System.out.println("type id:" + typeId);
        List<RecommendMedia> recs = recommendMovieMapper.getRecMovies(typeId, 2019, 6);
        System.out.println("查询得到的数目：" + recs.size());
    }





}