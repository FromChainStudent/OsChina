package com.example.oschina.module.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by YC on 2017/5/11.
 */
@DatabaseTable(tableName = "name")
public class Lv_Content {

    @DatabaseField(columnName = "content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
