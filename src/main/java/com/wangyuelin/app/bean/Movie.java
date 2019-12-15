package com.wangyuelin.app.bean;

import com.wangyuelin.app.utils.TextUtil;
import org.apache.commons.lang3.text.StrBuilder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Movie implements Serializable {
    private long id;
    private String name;
    private List<String> otherNames;
    private String quality;//影片的质量 HD BD 720  1080等
    private List<String> directors;//导演
    private List<String> actors;//演员
    private List<String> types;//类型：动作片  惊悚片
    private List<String> locations;//国家和地区
    private String language;//语言
    private int year;//上映时间
    private int duration;//电影时长，分钟为单位
    private String intro;//简介
    private float doubanRank;//豆瓣评分
    private List<MovieLink> linkTypes;//电影的资源链接
    private List<String> covers;//封面
    private List<String> froms;//表示从哪些url采集来的

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }


    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public float getDoubanRank() {
        return doubanRank;
    }

    public void setDoubanRank(float doubanRank) {
        this.doubanRank = doubanRank;
    }

    public List<MovieLink> getLinkTypes() {
        return linkTypes;
    }

    public void setLinkTypes(List<MovieLink> linkTypes) {
        this.linkTypes = linkTypes;
    }

    public List<String> getCovers() {
        return covers;
    }

    public void setCovers(List<String> covers) {
        this.covers = covers;
    }

    public List<String> getFroms() {
        return froms;
    }

    public void setFroms(List<String> froms) {
        this.froms = froms;
    }

    public  void setActorsStr(String actorsStr) {
        if (TextUtil.isEmpty(actorsStr)) {
            return;
        }
        String[] actorArray = actorsStr.split(";");
        actors = Arrays.asList(actorArray);
    }

    public void  setOtherNamesStr(String otherNamesStr){
        otherNames = toList(otherNamesStr);

    }


    public void  setDirectorsStr(String directorsStr){
        directors = toList(directorsStr);

    }


    public void  setLocationsStr(String locationsStr){
        locations = toList(locationsStr);

    }



    public void  setCoversStr(String coversStr){
        covers = toList(coversStr);

    }


    public void  setFromsStr(String fromsStr){
        froms = toList(fromsStr);

    }











    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("名称：").append(name).append("\n")
               .append("id:").append(id).append("\n")
               .append("封面:").append(toStr(covers)).append("\n")
               .append("评分:").append(doubanRank).append("\n")
               .append("别名:").append(toStr(otherNames)).append("\n")
               .append("质量:").append(quality).append("\n")
               .append("导演:").append(toStr(directors)).append("\n")
               .append("演员:").append(toStr(actors)).append("\n")
               .append("类型:").append(toStr(types)).append("\n")
               .append("地区:").append(toStr(locations)).append("\n")
               .append("语言:").append(language).append("\n")
               .append("上映时间:").append(year).append("\n")
               .append("时长:").append(duration).append("\n")
               .append("资源:").append(getMovieLinkStr(linkTypes)).append("\n")
               .append("简介:").append(intro).append("\n").append("\n").append("\n").append("\n");
       return builder.toString();
    }

    /**
     * 将字符串转为list
     * @param str
     * @return
     */
    List<String> toList(String str) {
        if (TextUtil.isEmpty(str)) {
            return null;
        }
        String[] array = str.split(";");
        return Arrays.asList(array);
    }

    /**
     * 将list转为字符串
     * @param list
     * @return
     */
    StringBuilder toStr(List<String> list) {
        StringBuilder builder = new StringBuilder();
        if (list == null) {
            return builder;
        }
        boolean first = true;
        for (String s : list) {
            if (!first) {
                builder.append(";");
            }
            builder.append(s);
            first = false;
        }
        return builder;
    }



    StringBuilder getMovieLinkStr(List<MovieLink> list) {
        StringBuilder builder = new StringBuilder();
        if (list == null) {
            return builder;
        }
        builder.append("\n");
        for (MovieLink movieLink : list) {
            builder.append(movieLink.getTypeName()).append(" ").append("\n").append("链接：");
            List<MovieLink.LinkItem> links = movieLink.getLinks();
            if (links != null) {
                for (MovieLink.LinkItem link : links) {
                    builder.append(link.getName()).append(" ").append(link.getLink()).append(",");
                }
            }
            builder.append("\n");

        }
        return builder;
    }
}
