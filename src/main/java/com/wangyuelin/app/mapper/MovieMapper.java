package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.HomeMovieBean;
import com.wangyuelin.app.bean.Movie;
import com.wangyuelin.app.bean.MovieDetail;
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
public interface MovieMapper {

    /**
     * 据id查电影
     * @param id
     * @return
     */

    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 60000)
    @Results(id = "movieResult", value = {
            @Result(property = "id", column = "id", id = true, javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "actorsStr", column = "actors", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "otherNamesStr", column = "other_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "quality", column = "quality", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "directorsStr", column = "directors", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "locationsStr", column = "locations", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "language", column = "language", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "year", column = "year", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "duration", column = "duration", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "intro", column = "intro", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "doubanRank", column = "douban_rank", javaType = float.class, jdbcType = JdbcType.FLOAT),
            @Result(property = "coversStr", column = "covers", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "fromsStr", column = "froms", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    @Select("SELECT * FROM movie WHERE id = #{id}")
    Movie get(@Param("id") long id);

}