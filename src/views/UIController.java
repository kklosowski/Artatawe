package views;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class UIController {

    private Stage loginStage;
    private Stage primaryStage;
    private Map<String, Pane> views;

    public UIController(){
        this.views = new HashMap<String, Pane>();
    }

    private void addView(String name, Pane view) throws IllegalArgumentException{
        if(this.views.containsKey(name)){
            throw new IllegalArgumentException("The view with key '" + name + "' already exists.");
        }else{
            this.views.put(name, view);
        }
    }

    private Pane getView(String name) throws NullPointerException{
        if(! this.views.containsKey(name)){
            throw new NullPointerException("Exception with key '" + name + "' does not exist.");
        }else{
            return this.views.get(name);
        }
    }



}
