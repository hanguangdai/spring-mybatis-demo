package com.mybatis.demo.pojo;

/**
 * @author daihg.ext
 * @title: Column
 * @projectName spring-mybatis-demo
 * @description:
 * @date 2019/10/25 17:46
 */
public class Column {

    private String name;
    private String type;
    private Integer length;

    public Column() {
    }

    public Column(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Column(String name, String type, Integer length) {
        this.name = name;
        this.type = type;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
