import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class AuctionController {
    private Scene view;
    private AuctionModel model;
    private LayoutDisplayController ldc;

    public AuctionController(Pane layout, Pane view){
        try{
            ldc = new LayoutDisplayController(layout, view);
            this.view = ldc.getView();
        }catch(Exception e){
            ErrorController ec;
            if(e.getMessage() == null){
                ec = new ErrorController(e);
            }else{
                ec = new ErrorController(e.getMessage());
            }
            this.view = ec.getView();
        }
    }

    public Scene getView(){
        return this.view;
    }
}
