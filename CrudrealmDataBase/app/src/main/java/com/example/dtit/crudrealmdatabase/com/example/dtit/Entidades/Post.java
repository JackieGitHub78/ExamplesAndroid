package com.example.dtit.crudrealmdatabase.com.example.dtit.Entidades;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by dtit on 03/03/16.
 */
public class Post extends RealmObject {

    @PrimaryKey
    private int userId;
    @Required
    private String title;
    @Required
    private String body;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
