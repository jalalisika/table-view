package fr.isika.cda28.exempleTableView;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class FormulaireGridPane extends GridPane {

	//Attributs
	public ArrayList<Stagiaire> mesStagiaires;
	
	//Constructeur
	public FormulaireGridPane(ArrayList<Stagiaire> listeStagiaires) {
		
		this.mesStagiaires = listeStagiaires;
		
		//Textfield
		Label nomLbl = new Label("Nom");
		TextField nomTF = new TextField();
		
		Label prenomLbl = new Label("Prenom");
		TextField prenomTF = new TextField();
		
		Label dateNaissanceLbl = new Label("Date de naissance");
		DatePicker dateNaissanceDP = new DatePicker();
		
		ToggleButton genre1 = new ToggleButton("Masculin");
		ToggleButton genre2 = new ToggleButton("Fémninin");
		ToggleButton genre3 = new ToggleButton("Autre");
		
		ToggleGroup genreTG = new ToggleGroup();
		genreTG.getToggles().addAll(genre1,genre2,genre3);
		
	
		RadioButton cdaRB = new RadioButton("CDA");
		RadioButton alRB = new RadioButton("AL");
		
		ToggleGroup promoTG = new ToggleGroup();
		promoTG.getToggles().addAll(cdaRB,alRB);
		
		this.add(nomLbl,0,0);//Ajout du Label avec le nom
		this.add(nomTF, 1, 0, 2 ,1);
		this.add(prenomLbl,0,1);//Ajout du Label avec le prénom
		this.add(prenomTF, 1, 1, 2 ,1);
		this.add(dateNaissanceLbl,0,2,2,1);//Ajout du Label avec la date
		this.add(dateNaissanceDP, 2, 2);
		this.add(new Label("Genre"), 0, 3);
		this.add(genre1, 0, 4);
		this.add(genre2, 1, 4);
		this.add(genre3, 2, 4);
		this.add(new Label("Promo"), 0, 5);
		this.add(cdaRB, 1, 5);
		this.add(alRB, 2, 5);
		
		Button validerButton = new Button("Ajouter Stagiaire");
		this.add(validerButton, 0, 6, 4, 1);
		
		validerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Ajout du stagiaire " + nomTF.getText().toUpperCase() + " " + prenomTF.getText().toLowerCase());;
				Stagiaire monStagiaire = new Stagiaire(
						nomTF.getText().toUpperCase(), 
						prenomTF.getText().toLowerCase(),
						dateNaissanceDP.getValue());
				//System.out.println(monStagiaire);
				mesStagiaires.add(monStagiaire);
				
				for (Stagiaire s : mesStagiaires) {
					//System.out.println(s);
				}
			}
		});
	}
	
	
	
}
