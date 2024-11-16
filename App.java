package fr.isika.cda28.exempleTableView;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	   //attributs de mon stagiaire
	ArrayList<Stagiaire> promotion;
    @Override
    
    public void init () {
    	promotion = new ArrayList<Stagiaire>();
    }
    public void start(Stage stage) {
     
    	//Première vue
    	StackPane firstView = new StackPane();
    	VBox forAndButtonVBox = new VBox();
    	FormulaireGridPane monFormulaire= new FormulaireGridPane(promotion);
    	Button gotoSecondView = new Button("Go to 2 buttons");
    	
    	firstView.getChildren().add(forAndButtonVBox);
      
    	
    	forAndButtonVBox.getChildren().addAll (monFormulaire,gotoSecondView);
    	//Seconde vue
    	VBox secondView = new VBox();
    	Button printHello = new Button("Print Hello");
    	Button gotoFirstView = new Button("Go to 1 button");
    	
    	PromotionView monTableViewStagiaire = new PromotionView(promotion);
    	secondView.getChildren().addAll(monTableViewStagiaire,printHello, gotoFirstView);
    	
    	
    	
        Scene scene = new Scene(firstView, 640, 480);//Ici firstView correspond à la root juste dessous la scene
        stage.setScene(scene);
        stage.show();
        
        //On ajoute le comportement aux boutons
        gotoSecondView.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				scene.setRoot(secondView);
				monTableViewStagiaire.monTableau.setItems (FXCollections.observableArrayList(promotion));
			}
			
		});
        
        printHello.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (Stagiaire s : promotion) {
					
					secondView.getChildren().add(new Label(s.toString()));
				}
				
			}
			
		});
        
        gotoFirstView.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				scene.setRoot(firstView);
			}
			
		});
    }

    public static void main(String[] args) {
        launch();
    }

}