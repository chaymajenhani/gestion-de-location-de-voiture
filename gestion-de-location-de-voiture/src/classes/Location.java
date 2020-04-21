package classes;

import java.util.*;

public class Location {

	private static int cpt=0;
	
	private int code;

	private int client;

	private String vehicule;

	private Date dateLocation;

	private Date dateDebut;

	private Date dateFin;

	private boolean chauffeur;


	private String typePaiement;

	public Location(int client, String vehicule, Date dateLocation, Date dateDebut, Date dateFin,
			boolean chauffeur, String typePaiement) {
		this.code = cpt++;
		this.client = client;
		this.vehicule = vehicule;
		this.dateLocation = dateLocation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.chauffeur = chauffeur;

		this.typePaiement = typePaiement;
	}

	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public String getVehicule() {
		return vehicule;
	}

	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}

	public Date getDateLocation() {
		return dateLocation;
	}

	public void setDateLocation(Date dateLocation) {
		this.dateLocation = dateLocation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(boolean chauffeur) {
		this.chauffeur = chauffeur;
	}

	

	public String getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}

	@Override
	public String toString() {
		return "Location [code=" + code + ", client=" + client + ", vehicule=" + vehicule + ", dateLocation="
				+ dateLocation + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", chauffeur=" + chauffeur
				 + ", typePaiement=" + typePaiement + "]";
	}


	public void afficherFacture() {
		// TODO: implement
	}

	public void afficherContrat() {
		// TODO: implement
	}

	public double calculeMontantTotal() {
		int duree=dateFin.getYear()-dateDebut.getYear()+1900;
		return duree;
	}

}