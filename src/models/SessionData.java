package models;

import artatawe.User;

import java.util.HashMap;

public class SessionData {
    private HashMap<String, Object> sessionData = new HashMap<String, Object>();

    public User getUser(){
        return (User) this.sessionData.get("user");
    }

    public void setUser(User u){
        this.sessionData.put("user", u);
    }



}
