package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.Banner;
import com.wangyuelin.app.bean.RecommendMedia;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BannerMapperTest {
    @Autowired
    private BannerMapper bannerMapper;

    @Test
    public void insert() throws Exception {
//        Banner banner = new Banner();
//        banner.setUrl("banner.com");
//        banner.setName("ceshi2");
//        Integer num = bannerMapper.insert(banner, 2);
//
//        Integer id = bannerMapper.getId(2, "banner.com", "ceshi");
//        System.out.println("查询到的id：" + id);

        List<Banner> banners = bannerMapper.getBanners(2);
        System.out.println("banner 量：" + banners.size());
    }





}