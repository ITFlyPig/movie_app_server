package com.wangyuelin.app.mapper;

import com.wangyuelin.app.bean.Banner;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@CacheNamespace(eviction = LruCache.class, flushInterval = 60000L, size = 1024, readWrite = true)
@Mapper
public interface BannerMapper {

    /**
     * 获取电影、电视剧等分类下的banner id
     * @param categoryId
     * @return
     */
    @Select("SELECT * FROM banner WHERE banner.category_id = #{categoryId} AND url LIKE #{url} AND `name`LIKE #{name}")
    Integer getId(@Param("categoryId") int categoryId,@Param("url") String url,@Param("name") String name);

    /**
     * 记录banner数据
     * @param banner
     * @param categoryId
     * @return
     */
    @Insert("INSERT INTO banner(category_id, url, `name`) VALUES(#{categoryId}, #{banner.url}, #{banner.name});")
    Integer insert(@Param("banner") Banner banner, @Param("categoryId") int categoryId);

    /**
     * 查询某种类型下的需要展示的banners
     * @param categoryId
     * @return
     */
    @Select("SELECT id, `name`, url FROM banner WHERE category_id = #{categoryId}")
    @Results({
            @Result(property = "id", column = "id", id = true, javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "url", column = "url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<Banner> getBanners(@Param("categoryId") int categoryId);


}
