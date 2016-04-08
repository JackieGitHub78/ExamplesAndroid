package com.example.dtit.crudrealmdatabase.com.example.dtit.Controls;

import android.content.Context;

import com.example.dtit.crudrealmdatabase.com.example.dtit.Entidades.Post;
import com.example.dtit.crudrealmdatabase.com.example.dtit.Interfaces.InterfaceMetDataBase;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by dtit on 03/03/16.
 */
public class RepositoryPostMetodos implements InterfaceMetDataBase {

    private Realm realm;
    private RealmConfiguration realmconfig;
    private Post post;


    public RepositoryPostMetodos(Context c)
    {
        realmconfig = new RealmConfiguration.Builder(c).build();
        realm = Realm.getInstance(realmconfig);
    }


    @Override
    public void addPost(Post post) {

        realm.beginTransaction();
        post = realm.createObject(Post.class);
        post.setTitle(post.getTitle());
        post.setBody(post.getBody());
        //el metodo getNextKey() se esta ocupando para poder hacer el autoincrementable asi que lo ocuparemospara
        post.setUserId(getNextKey());
        realm.commitTransaction();

    }

    @Override
    public void detelePost(int IdPost) {
        
    }

    @Override
    public void deletePostall() {

    }

    @Override
    public void updatePOstId(Post post) {

    }

    @Override
    public List<Post> readallpost(Post post) {
        return null;
    }

    @Override
    public Post findFirstPost() {
        return null;
    }

    @Override
    public int getNextKey() {
        return 0;
    }
}
