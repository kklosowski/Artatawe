package controllers;

import javafx.scene.Parent;
import javafx.stage.Stage;

import java.util.HashMap;

public class StageSession extends Stage {

    private HashMap<String, Object> sessionData = new HashMap<String, Object>();

    public Object getSessionData(String key){
        return this.sessionData.get(key);
    }

    public void setSessionData(String key, Object value){
        this.sessionData.put(key, value);
    }

}
