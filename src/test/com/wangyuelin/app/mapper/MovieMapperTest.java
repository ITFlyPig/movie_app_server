package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.LinkTypeItem;
import com.wangyuelin.app.bean.Movie;
import com.wangyuelin.app.bean.MovieLink;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieMapperTest {
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private LinkMapper linkMapper;

    @Test
    public void query() throws Exception {
        Movie movie = movieMapper.get(20);
        List<LinkTypeItem> linkTypeItems = linkMapper.getLinkTypes(movie.getId());
        List<MovieLink> links = new ArrayList<MovieLink>();
        movie.setLinkTypes(links);
        for (LinkTypeItem linkTypeItem : linkTypeItems) {
            MovieLink movieLink = new MovieLink();
            movieLink.setTypeName(linkTypeItem.getTypeName());
            movieLink.setTypeValue(linkTypeItem.getTypeValue());
            List<MovieLink.LinkItem> linkItems = linkMapper.getLinks(linkTypeItem.getId());
            movieLink.setLinks(linkItems);
            links.add(movieLink);
        }

        System.out.println(movie);
    }





}