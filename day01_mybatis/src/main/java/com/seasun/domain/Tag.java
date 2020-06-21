package com.seasun.domain;

public class Tag {
    private Integer id;
    private String tag;
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
