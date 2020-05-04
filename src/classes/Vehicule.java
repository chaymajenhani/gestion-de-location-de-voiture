package classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Vehicule implements Serializable {

    private Matricule matricule;

    private Date dateEntree;

    private double prixLocationParJour;

    private int nbLocation;

    private boolean disponible;

    private String couleur;

    private String marque;

    private String categorie;

    private int kilometrage;
    private int idParking;

    public Vehicule(Matricule matricule, Date dateEntree, double prixLocationParJour, int nbLocation,
            boolean disponible, String couleur, String marque, String categorie, int kilometrage, int idParking) {

        this.matricule = matricule;
        this.dateEntree = dateEntree;
        this.prixLocationParJour = prixLocationParJour;
        this.nbLocation = nbLocation;
        this.disponible = disponible;
        this.couleur = couleur;
        this.marque = marque;
        this.categorie = categorie;
        this.kilometrage = kilometrage;
        this.idParking=idParking;

    }

    public Vehicule() {
       nbLocation=0;
       disponible=false;
       idParking=-1;
      
    }

    public int getIdParking() {
        return idParking;
    }

    public void setIdParking(int idParking) {
        this.idParking = idParking;
    }

    public Matricule getMatricule() {
        return matricule;
    }

    public void setMatricule(Matricule matricule) {
        this.matricule = matricule;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
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
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        return "matricule=" + matricule.toString() + ", dateEntree=" + formatter.format(dateEntree)
                + ", prixLocationParJour=" + prixLocationParJour + ", nbLocation=" + nbLocation + ", disponible="
                + disponible + ", couleur=" + couleur + ", marque=" + marque + ", categorie="
                + categorie + ", kilometrage=" + kilometrage;
    }

    public int calculerAge() {
        Date auj = new Date();
         //calculer la difference entre les dates en ms 
        long diff = auj.getTime() - dateEntree.getTime();
        //convertir la difference en jours
        int ageJours=(int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
       
        return ageJours;
    }

}
