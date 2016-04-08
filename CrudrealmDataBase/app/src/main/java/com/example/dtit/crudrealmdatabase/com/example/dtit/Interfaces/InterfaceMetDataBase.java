package com.example.dtit.crudrealmdatabase.com.example.dtit.Interfaces;

import com.example.dtit.crudrealmdatabase.com.example.dtit.Entidades.Post;

import java.util.List;

/**
 * Created by dtit on 03/03/16.
 */
public interface InterfaceMetDataBase {

    public void addPost(Post post); //agregar un objeto de tipo post a la bd
    public void detelePost(int IdPost);  //borrar un objeto de tipo post a la bd con el id
    public void deletePostall(); //borrar todo
    public void updatePOstId(Post post);  //actualizar
    public List<Post> readallpost(Post post); //seleccionar tod //
    public Post findFirstPost();
    public int getNextKey();

}
