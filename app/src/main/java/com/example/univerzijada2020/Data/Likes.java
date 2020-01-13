package com.example.univerzijada2020.Data;

import java.util.ArrayList;

public class Likes {
    private String name;
    private int likes;

    public static ArrayList<Likes> likesList;

     public static void initializeLikes(){
         likesList =  new ArrayList<>();
         likesList.add(new Likes("Kalemegdan", 100));
         likesList.add(new Likes("Ada Ciganlija", 120));
         likesList.add(new Likes("Hram Svetog Save", 200));
     }

     public static void addLike(String name){
         for (Likes like: likesList) {
             if(like.getName().equals(name)){
                 like.setLikes(like.getLikes()+1);
             }
         }
     }

     public static int getLikes(String name){
         for (Likes like: likesList) {
             if(like.getName().equals(name)){
                 return like.getLikes();
             }
         }
         return 0;
     }

    public Likes(String name, int likes) {
        this.name = name;
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
