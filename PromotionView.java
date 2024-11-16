package fr.isika.cda28.exempleTableView;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;

public class PromotionView extends VBox {
	// Attributs
	private ArrayList<Stagiaire> promotion;
	public TableView<Stagiaire> monTableau;
	public LocalDate dateDeNaissance;

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public PromotionView(ArrayList<Stagiaire> promotion) {
		super();
		this.promotion = promotion;
		this.monTableau = new TableView<Stagiaire>();
		// creation de la colonne Nom
		// etape 1 je cree la colonne
		TableColumn<Stagiaire, String> colonneNom = new TableColumn<Stagiaire, String>("Nom");
		// je donne une largeur à la colonne
		colonneNom.setMinWidth(100);
		// etape 3 je precise comment remplir ma colonne
		colonneNom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("nom"));
		// etape 4: j'ajoute ma colonne à ma table view

		monTableau.getColumns().add(colonneNom);

		// creation de la colonne PreNom
		// etape 1 je cree la colonne
		TableColumn<Stagiaire, String> colonnePrenom = new TableColumn<Stagiaire, String>("Prenom");
		// je donne une largeur à la colonne
		colonnePrenom.setMinWidth(100);
		// etape 3 je precise comment remplir ma colonne
		colonnePrenom.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("Prenom"));
		// etape 4: j'ajoute ma colonne à ma table view

		monTableau.getColumns().add(colonnePrenom);

		// je donne à mon tableau la liste de stagiaire à afficher
		monTableau.setItems(FXCollections.observableArrayList(this.promotion));

		// j'ajoute mon tableau au graphe de scne

		this.getChildren().add(monTableau);

		// creation de la colonne Date de naissance
		// etape 1 je cree la colonne
		TableColumn<Stagiaire, LocalDate> colonneDate = new TableColumn<Stagiaire, LocalDate>("dateDeNaissance");
		// je donne une largeur à la colonne
		colonneDate.setMinWidth(100);
		// etape 3 je precise comment remplir ma colonne
		colonneDate.setCellValueFactory(new PropertyValueFactory<Stagiaire, LocalDate>("dateDeNaissance"));
		// etape 4: j'ajoute ma colonne à ma table view

		monTableau.getColumns().add(colonneDate);

		// je donne à mon tableau la liste de stagiaire à afficher
		monTableau.setItems(FXCollections.observableArrayList(this.promotion));

		// j'ajoute mon tableau au graphe de scne

		// this.getChildren().add(monTableau); DEJA FAIT

		// Etape5 j'ajoute une gestionnaire d'évènement pour les cellules de ma colonne
		colonneNom.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Stagiaire, String>>() {
			@Override
			public void handle(CellEditEvent<Stagiaire, String> event) {
				// Je récupère l'objet qui correspond à la ligne modifiée
				((Stagiaire) monTableau.getItems().get((event.getTablePosition().getRow())))
						.setNom(event.getNewValue());// On récupère la nouvelle valeur dans l'event
			}
		});
		colonneNom.setCellFactory(TextFieldTableCell.forTableColumn()); // On autotrise à transformer la case en
																		// Textfield
		colonneNom.setEditable(true);// on autorise la modification des colonnes

	}

}
