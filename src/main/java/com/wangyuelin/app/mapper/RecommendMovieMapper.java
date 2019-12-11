package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.RecommendMedia;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@CacheNamespace(eviction = LruCache.class, flushInterval = 60000L, size = 1024, readWrite = true)
@Mapper
public interface RecommendMovieMapper {

    /**
     * 获取对应类型的推荐电影
     * @param typeId 类型Id：动作、恐怖等
     * @param endYear 截止的上映年份
     * @param minRank 截止的最低评分
     * @return
     */

    @Select("SELECT movie.id, name, douban_rank, covers FROM movie " +
            "LEFT JOIN type_relationship ON movie.id = type_relationship.movie_id " +
            "WHERE type_relationship.type_id = #{typeId} AND `year`>= #{endYear} AND douban_rank >= #{minRank} " +
            "ORDER BY douban_rank DESC")
    @Results({
            @Result(property = "id", column = "id", id = true, javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "rank", column = "douban_rank", javaType = Float.class, jdbcType = JdbcType.FLOAT),
            @Result(property = "cover", column = "covers", javaType = String.class, jdbcType = JdbcType.VARCHAR),

    })
    List<RecommendMedia> getRecMovies(@Param("typeId") int typeId, @Param("endYear") int endYear, @Param("minRank") int minRank);

}
