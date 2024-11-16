package fr.isika.cda28.exempleTableView;

import java.time.LocalDate;

public class Stagiaire {

	//attributs
	public String nom;
	public String prenom;
	public LocalDate dateDeNaissance;
	
	//Contructeurs
	public Stagiaire(String nom, String prenom, LocalDate birthday) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = birthday;
	}
	
	//Getters & Setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//Méthodes spécifiques
	public String toString() {
		return "Stagiaire : " + this.nom + " " + this.prenom + " né(e) le " + this.dateDeNaissance.toString();
	}
	
}
