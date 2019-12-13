package com.wangyuelin.app.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cache.decorators.LruCache;

import java.util.List;
import java.util.Map;

@CacheNamespace(eviction = LruCache.class, flushInterval = 60000L, size = 1024, readWrite = true)
@Mapper
public interface TypeMapper {

    /**
     * 获取type对应的id
     * @param type
     * @return
     */
    @Select("SELECT id FROM movie_type WHERE `value` = #{type}")
    Integer getId(@Param("type") int type);

    @Select("SELECT * FROM movie_type")
    List<Map<String, Object>> getAllTypes();

}
