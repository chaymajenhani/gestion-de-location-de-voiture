/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import classes.Client;
import classes.MatriculeException;
import classes.Location;
import classes.Parking;
import classes.Vehicule;
import com.itextpdf.text.DocumentException;
import gestionClasses.GestionClient;
import gestionClasses.GestionLocation;
import gestionClasses.GestionParking;
import gestionClasses.GestionVehicule;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, MatriculeException, DocumentException {

        //launch(args);
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----Menu principale-----");
            System.out.println("Gestion des Clients: tapez 1");
            System.out.println("Gestion des Vehicules : tapez 2");
            System.out.println("Gestion des Locations : tapez 3");
            System.out.println("Gestion des Parkings : tapez 4");
            System.out.println("Quitter : tapez 5");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    int choixCl = 0;
                    while (choixCl != 6) {
                        System.out.println("-----Gestion des Clients-----");
                        System.out.println("Ajouter Client: tapez 1");
                        System.out.println("Supprimer Client : tapez 2");
                        System.out.println("Liste des Clients : tapez 3");
                        System.out.println("Recherche Client : tapez 4");
                        System.out.println("Les clients n'ayant pas loué de véhicules depuis plus de 6 mois : tapez 5");
                        System.out.println("RETOUR : tapez 6");

                        choixCl = sc.nextInt();
                        GestionClient gc = new GestionClient();
                        switch (choixCl) {

                            case 1:
                                Client cl = gc.saisie();
                                gc.ajouter(cl);
                                break;
                            case 2:
                                System.out.println("donner le cin du client a supprimer");
                                int cin = sc.nextInt();
                                gc.supprimer(gc.recherche(cin));
                                break;
                            case 3:
                                for (int i = 0; i < gc.listeClient().size(); i++) {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                    System.out.println(gc.listeClient().get(i).toString());
                                }
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                break;
                            case 4:
                                System.out.println("donner le CIN du client à rechercher");
                                int c = sc.nextInt();
                                if (gc.recherche(c) != null) {
                                    System.out.println(gc.recherche(c).toString());
                                } else {
                                    System.out.println("Client Introuvable");
                                }
                                break;
                            case 5:
                                GestionLocation gl = new GestionLocation();

                                for (int i = 0; i < gl.listClient_plus6mois().size(); i++) {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                    System.out.println(gl.listClient_plus6mois().get(i).toString());
                                }
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                            case 6:
                                break;
                        }
                    }
                    break;

                case 2:
                    int choixV = 0;
                    while (choixV != 11) {
                        System.out.println("-----Gestion des Vehicules-----");
                        System.out.println("Ajouter Vehicule: tapez 1");
                        System.out.println("Supprimer Vehicule : tapez 2");
                        System.out.println("Liste des Vehicules : tapez 3");
                        System.out.println("Recherche Vehicule : tapez 4");
                        System.out.println("Le vehicule le plus ancien : tapez 5");
                        System.out.println("Le véhicule ayant le plus été loué : tapez 6");
                        System.out.println("Les voitures ayant un âge entre 2 et 3 ans : tapez 7");
                        System.out.println("Les véhicules actuellement loués : tapez 8");
                        System.out.println("La liste des véhicules triés selon la catégorie : tapez 9");
                        System.out.println("La liste des véhicules triés selon l'âge : tapez 10");
                        System.out.println("RETOUR : tapez 11");
                        choixV = sc.nextInt();
                        GestionVehicule gv = new GestionVehicule();

                        switch (choixV) {
                            case 1:
                                Vehicule v = gv.saisie();
                                gv.ajouter(v);
                                break;
                            case 2:
                                System.out.println("donner la matricule du vehicule a supprimer");
                                String mat = sc.next();
                                gv.supprimer(gv.recherche(mat));
                                break;
                            case 3:
                                for (int i = 0; i < gv.listeVehicule().size(); i++) {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                    System.out.println(gv.listeVehicule().get(i).toString());

                                }
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                break;
                            case 4:
                                System.out.println("donner la matricule du vehicule à rechercher");
                                String m = sc.next();
                                if (gv.recherche(m) != null) {
                                    System.out.println(gv.recherche(m).toString());
                                } else {
                                    System.out.println("Vehicule Introuvable");
                                }
                                break;
                            case 5:
                                System.out.println(gv.VehiculePlusAncien().toString());
                                break;
                            case 6:
                                System.out.println(gv.VehiculePlusLoue().toString());
                                break;
                            case 7:
                                for (int i = 0; i < gv.Age2et3ans().size(); i++) {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                    System.out.println(gv.Age2et3ans().get(i).toString());

                                }
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                break;
                            case 8:
                                for (int i = 0; i < gv.vehiculesLoues().size(); i++) {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                    System.out.println(gv.vehiculesLoues().get(i).toString());

                                }
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                break;

                            case 9:
                                for (int i = 0; i < gv.trieCategorie().size(); i++) {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                    System.out.println(gv.trieCategorie().get(i).toString());

                                }
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                break;

                            case 10:
                                for (int i = 0; i < gv.trieAge().size(); i++) {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                    System.out.println(gv.trieAge().get(i).toString());

                                }
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                break;

                            case 11:
                                break;
                        }
                    }
                    break;
                case 3:
                    int choixL = 0;
                    while (choixL != 6) {
                        System.out.println("-----Gestion des Locations----");
                        System.out.println("Ajouter Location: tapez 1");
                        System.out.println("Supprimer Location : tapez 2");
                        System.out.println("Liste des Locations : tapez 3");
                        System.out.println("Recherche Location : tapez 4");
                        System.out.println("Imprimer Contract : tapez 5");
                        System.out.println("RETOUR : tapez 6");
                        choixL = sc.nextInt();
                        GestionLocation gl = new GestionLocation();

                        switch (choixL) {
                            case 1:
                                Location v = gl.saisie();
                                gl.ajouter(v);
                                break;
                            case 2:
                                System.out.println("donner le code de location a supprimer");
                                int code = sc.nextInt();
                                gl.supprimer(gl.recherche(code));
                                break;
                            case 3:
                                for (int i = 0; i < gl.listeLocation().size(); i++) {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                    System.out.println(gl.listeLocation().get(i).toString());
                                }
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                break;
                            case 4:
                                System.out.println("donner le code de location à rechercher");
                                int c = sc.nextInt();
                                if (gl.recherche(c) != null) {
                                    System.out.println(gl.recherche(c).toString());
                                } else {
                                    System.out.println("Location Introuvable");
                                }
                                break;
                            case 5:  System.out.println("donner le code de location");
                                Location l=gl.recherche(sc.nextInt());
                                if (l != null) {
                                    l.afficherContrat();
                                } else {
                                    System.out.println("Location Introuvable");
                                }
                                break;
                            case 6:
                                break;
                        }
                    }
                    break;
                case 4:
                    int choixP = 0;
                    while (choixP != 11) {
                        System.out.println("-----Gestion des Parkings-----");
                        System.out.println("Ajouter Parking: tapez 1");
                        System.out.println("Supprimer Parking : tapez 2");
                        System.out.println("Liste des Parkings : tapez 3");
                        System.out.println("Recherche Parking : tapez 4");
                        System.out.println("Moyenne de prix des véhicules d'un parking : tapez 5");
                        System.out.println("Grouper les véhicules de 2 parking dans un troisième parking : tapez 6");
                        System.out.println("Vider un parking de ses véhicules en les distribuant à 2 autres parkings en fonction de\n"
                                + "leurs catégories.: tapez 7");
                        System.out.println("Ajouter vehicule au parking: tapez 8");
                        System.out.println("Supprimer vehicule du parking : tapez 9");
                        System.out.println("Liste des vehicules d'un parking : tapez 10");
                        System.out.println("RETOUR : tapez 11");
                        choixP = sc.nextInt();
                        GestionParking gp = new GestionParking();

                        switch (choixP) {
                            case 1:
                                Parking p = gp.saisie();
                                gp.ajouter(p);
                                break;
                            case 2:
                                System.out.println("donner le code du parking a supprimer");
                                int id = sc.nextInt();
                                gp.supprimer(gp.recherche(id));
                                break;
                            case 3:
                                for (int i = 0; i < gp.listeParking().size(); i++) {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                    System.out.println(gp.listeParking().get(i).toString());
                                }
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                                break;
                            case 4:
                                System.out.println("donner le code du parking à rechercher");
                                int code = sc.nextInt();
                                if (gp.recherche(code) != null) {
                                    System.out.println(gp.recherche(code).toString());
                                } else {
                                    System.out.println("Parking Introuvable");
                                }
                                break;
                            case 5:
                                System.out.println("donner le numéro de parking ");
                                int parc = sc.nextInt();

                                Parking parking = gp.recherche(parc);
                                if (parking != null) {
                                    System.out.println("la moyenne de prix de ce parking = " + parking.moyennePrix());
                                } else {
                                    System.out.println("Parking Introuvable");
                                }
                                break;
                            case 6:
                                System.out.println("donner le numéro parking à vider");

                                Parking pvide = gp.recherche(sc.nextInt());
                                System.out.println("donner le numéro du premier parking ");
                                Parking pcat1 = gp.recherche(sc.nextInt());
                                System.out.println("donner le numéro du deuxieme parking ");
                                Parking pcat2 = gp.recherche(sc.nextInt());
                                if (pvide != null && pcat1 != null && pcat2 != null) {
                                    gp.distribuer(pvide, pcat1, pcat2);

                                } else {
                                    System.out.println("Numeros invalides");
                                }

                                break;
                            case 7:
                                System.out.println("donner le numéro parking du groupement");

                                Parking p1 = gp.recherche(sc.nextInt());
                                System.out.println("donner le numéro du premier parking ");
                                Parking p2 = gp.recherche(sc.nextInt());
                                System.out.println("donner le numéro du deuxieme parking ");
                                Parking p3 = gp.recherche(sc.nextInt());
                                if (p1 != null && p2 != null && p3 != null) {
                                    gp.fusionner(p2, p3, p1);
                                } else {
                                    System.out.println("Numeros invalides");
                                }
                                break;
                            case 8:
                                System.out.println("donner le code du parking ");
                                Parking pajout = gp.recherche(sc.nextInt());
                                if (pajout != null) {
                                    GestionVehicule gv = new GestionVehicule();
                                    System.out.println("donner la matricule du vehicule à ajouter");
                                    Vehicule v = gv.recherche(sc.next());
                                    if (v != null) {
                                        pajout.ajouterVehicule(v);
                                    } else {
                                        System.out.println("Vehicule Introuvable");
                                    }

                                } else {
                                    System.out.println("Parking Introuvable");
                                }
                                break;
                            case 9:
                                System.out.println("donner le code du parking");
                                Parking psupp = gp.recherche(sc.nextInt());
                                if (psupp != null) {
                                    GestionVehicule gv = new GestionVehicule();
                                    System.out.println("donner la matricule du vehicule à supprimer");
                                    Vehicule v = gv.recherche(sc.next());
                                    if (v != null) {
                                        psupp.supprimerVehicule(v);
                                    } else {
                                        System.out.println("Vehicule Introuvable");
                                    }

                                } else {
                                    System.out.println("Parking Introuvable");
                                }
                                break;
                            case 10:
                                System.out.println("donner le code du parking ");
                                Parking plist = gp.recherche(sc.nextInt());
                                if (plist != null) {
                                    plist.afficherVehicules();
                                } else {
                                    System.out.println("Parking Introuvable");
                                }

                                break;

                            case 11:
                                break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("-----Fin de programme------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix Invalid");
            }

        } while (choix != 5);

    }
}
