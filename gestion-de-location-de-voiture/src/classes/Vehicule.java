package classes;

import java.util.*;



public class Vehicule {

	private static int id;

	private Matricule numImmatriculation;

	private Date dateFabrication;

	private double prixLocationParJour;

	private int nbLocation;

	private boolean disponible;

	private String couleur;

	private String marque;

	private String categorie;

	private int kilometrage;

	public Vehicule(Matricule numImmatriculation, Date dateFabrication, double prixLocationParJour, int nbLocation,
			boolean disponible, String couleur, String marque, String categorie, int kilometrage)  {
		id++;
		this.numImmatriculation = numImmatriculation;
		this.dateFabrication = dateFabrication;
		this.prixLocationParJour = prixLocationParJour;
		this.nbLocation = nbLocation;
		this.disponible = disponible;
		this.couleur = couleur;
		this.marque = marque;

		this.categorie = categorie;
		this.kilometrage = kilometrage;
	}

	public static int getId() {
		return id;
	}

	public Matricule getNumImmatriculation() {
		return numImmatriculation;
	}

	public void setNumImmatriculation(Matricule numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}

	public Date getDateFabrication() {
		return dateFabrication;
	}

	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}

	public double getPrixLocationParJour() {
		return prixLocationParJour;
	}

	public void setPrixLocationParJour(double prixLocationParJour) {
		this.prixLocationParJour = prixLocationParJour;
	}

	public int getNbLocation() {
		return nbLocation;
	}

	public void setNbLocation(int nbLocation) {
		this.nbLocation = nbLocation;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	@Override
	public String toString() {
		return "Vehicule [numImmatriculation=" + numImmatriculation.toString() + ", dateFabrication=" + dateFabrication
				+ ", prixLocationParJour=" + prixLocationParJour + ", nbLocation=" + nbLocation + ", disponible="
				+ disponible + ", couleur=" + couleur + ", marque=" + marque +  ", categorie="
				+ categorie + ", kilometrage=" + kilometrage + "]";
	}

	public void ajouter() {
		// TODO: implement
	}

	public void modifier() {
		// TODO: implement
	}

	public void supprimer() {
		// TODO: implement
	}

	public int calculerAge() {
		// TODO: implement
		return 0;
	}
	


}
