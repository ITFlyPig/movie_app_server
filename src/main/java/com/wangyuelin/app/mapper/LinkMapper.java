package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.LinkType;
import com.wangyuelin.app.bean.LinkTypeItem;
import com.wangyuelin.app.bean.Movie;
import com.wangyuelin.app.bean.MovieLink;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 描述:
 *
 * @outhor wangyuelin
 * @create 2018-06-25 下午4:26
 */
@CacheNamespace(eviction = LruCache.class, flushInterval = 60000L, size = 1024, readWrite = true)
@Mapper
public interface LinkMapper {

    /**
     * 获取电影下所有的资源类型
     *
     * @param movieId
     * @return
     */
    @Results(value = {
            @Result(property = "id", column = "id", id = true, javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "from", column = "from", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "typeValue", column = "link_type", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    @Select("SELECT * FROM movie_link WHERE movie_id = #{movieId}")
    List<LinkTypeItem> getLinkTypes(@Param("movieId") long movieId);

    /**
     * 查询真正的资源
     * @param linkTypeId
     * @return
     */
    @Results(value = {
            @Result(property = "id", column = "id", id = true, javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "link", column = "link", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    @Select("SELECT id, name, link  FROM link_item WHERE movie_link_id = #{linkTypeId}")
    List<MovieLink.LinkItem> getLinks(@Param("linkTypeId") long linkTypeId);


}