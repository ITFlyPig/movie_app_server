package com.wangyuelin.app.bean;

import java.io.Serializable;
import java.util.List;

public class MovieLink {
    private long id;
    private String typeName;
    private int typeValue;
    private List<LinkItem> links;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(int typeValue) {
        this.typeValue = typeValue;
    }

    public List<LinkItem> getLinks() {
        return links;
    }

    public void setLinks(List<LinkItem> links) {
        this.links = links;
    }

    public static class LinkItem implements Serializable {
        private long id;
        private String name;
        private String link;



        public LinkItem(String name, String link) {
            this.name = name;
            this.link = link;
        }

        public LinkItem(Integer id, String name, String link) {
            if (id == null) {
                id = -1;
            }
            this.id = id;
            this.name = name;
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
