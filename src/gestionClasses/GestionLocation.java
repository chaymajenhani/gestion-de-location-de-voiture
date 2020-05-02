package gestionClasses;

import classes.Client;
import classes.Location;
import classes.Parking;
import classes.Vehicule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Scanner;

public class GestionLocation {

    List<Location> locations;

    public GestionLocation() throws IOException, ClassNotFoundException {
        locations = new ArrayList<>();
        File f = new File("location.txt");
        //creer un fichier pour sauvgarder les donnees
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            if (f.length() != 0) {
                //si le fichier existe déja et n'est pas vide on charge les donnees dans une liste
                ObjectInputStream ois = new ObjectInputStream(fis);

                locations = (ArrayList) ois.readObject();

                ois.close();
                fis.close();
            }
        }

    }

    //methode pour sauvgarder les modifications sur la liste dans le fichier
    public void sauvgarde() throws FileNotFoundException, IOException {

        FileOutputStream fos = new FileOutputStream("location.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(locations);
        oos.close();
        fos.close();
    }

    public void ajouter(Location l) throws IOException, ClassNotFoundException {

        if (locations.add(l)) {
            //si l'ajout est effectué avec sccess on modifie la diponibilite de vehicule , on incremente le nb de location et supprimer la vehicule du parking
            GestionVehicule gv = new GestionVehicule();
            GestionParking gp=new GestionParking();
            Vehicule v = gv.recherche(l.getVehicule().getMatricule().toString());
            Parking p=gp.recherche(v.getIdParking());
            p.supprimerVehicule(v);
            gp.modifier(p);
            v.setDisponible(false);
            v.setNbLocation(v.getNbLocation() + 1);
            gv.modifier(v);
            sauvgarde();

        }

    }

    public void modifier(Location l) throws Exception {
        //parcourir la liste et modifer l'objet par les nouveaux donnees d'objet qui a le meme code
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getCode() == l.getCode()) {
                locations.set(i, l);
                sauvgarde();
                System.out.println("Location a été ajouté avec succes");

            }

        }

    }
//supprimer un objet de la liste 

    public void supprimer(Location l) throws IOException {
        locations.remove(l);
        sauvgarde();
        System.out.println("Location a été supprimé avec succes");
    }

    //methode qui retourne un objet location s'il existe sinon null
    public Location recherche(int code) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getCode() == code) {
                return locations.get(i);
            }
        }
        return null;
    }
//retourne la liste des locations

    public List<Location> listeLocation() {
        return locations;
    }

    //methode qui retourne la liste des clients qui n'ont pas loué des voitures depuis plus de 6 mois
    public List<Client> listClient_plus6mois() throws IOException, ClassNotFoundException {
        List<Client> clients_6mois = new ArrayList<>();
        Date auj = new Date();
        //parcourir la liste des locations
        for (Location l : locations) {
            //convertir la date en ms et calculer la difference 
            long diff = auj.getTime() - l.getDateDebut().getTime();
            int diffMois = (int) (diff / (30 * 24 * 60 * 60 * 1000));
            if (diffMois >= 6) {
                GestionClient gc = new GestionClient();
                clients_6mois.add(gc.recherche(l.getClient().getCin()));
            }
        }
        return clients_6mois;

    }

    //saisie des donnees d'une location
    public Location saisie() throws IOException, ClassNotFoundException {
        System.out.println("donner les informations de locations");
        GestionClient gc = new GestionClient();
        GestionVehicule gv = new GestionVehicule();
        Scanner sc = new Scanner(System.in);
        Location l = new Location();
        System.out.println("CIN client");
        l.setClient(gc.recherche(sc.nextInt()));
        System.out.println("Matricule Vehicule");
        l.setVehicule(gv.recherche(sc.next()));
        System.out.println("date de début");
        l.setDateDebut(new Date(sc.next()));
        System.out.println("date de fin");
        l.setDateFin(new Date(sc.next()));
        System.out.println("chauffeur (oui/non)");
        if(sc.next().equals("oui"))
            l.setChauffeur(true);
        else l.setChauffeur(false);
        System.out.println("type de paiement");
        l.setTypePaiement(sc.next());
        System.out.println("pourcentage de plein");
        l.setProp(sc.nextFloat());
        
        
        return l;

    }

}
