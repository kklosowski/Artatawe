package models;

import artatawe.User;

import java.util.HashMap;

public class SessionData {
    private HashMap<String, Object> sessionData = new HashMap<String, Object>();

    public void setData(String key, Object value){
        this.sessionData.put(key, value);
    }

    public User getUser() throws IllegalStateException{
        if(this.sessionData.containsKey("user")){
            if(this.sessionData.get("user") != null){
                return (User) this.sessionData.get("user");
            }
        }
        throw new IllegalStateException("The user data is not stored.");
    }


}
