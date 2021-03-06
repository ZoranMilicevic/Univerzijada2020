package com.example.univerzijada2020.Data;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private String telephone;
    private String address;
    private String username;
    private String password;

    public static ArrayList<User> users;
    public static User currentUser;

    public static ArrayList<User> initialiseUsers() {
        if(users == null) {
            users = new ArrayList<>();
            users.add(new User("Zoran", "Milicevic", "0631768402", "Vojvode Stepe 186", "zoki", "zokiuzina"));
            users.add(new User("Zika", "Zivkovic", "0631768402", "Vojvode stepe 190", "zika", "zika123"));
        }
        return users;
    }

    public static int findUserAndCheckPassword(String username, String password){
        int retVal = 0;
        for (User u:users){
            if(username.equals(u.getUsername())){
                if(password.equals(u.getPassword())){
                    currentUser = u;
                    return 2;
                }
                else return 1;
            }
        }
        return retVal;
    }

    public static boolean changePass(String oldPas, String newPass){
        if(currentUser.getPassword().equals(oldPas)){
            currentUser.setPassword(newPass);
            return true;
        }

        return false;
    }

    public static boolean updateUserInfo(String name, String surname, String telephone, String address){
        currentUser.setName(name);
        currentUser.setSurname(surname);
        currentUser.setTelephone(telephone);
        currentUser.setAddress(address);
        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public User(String name, String surname, String telephone, String address, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
