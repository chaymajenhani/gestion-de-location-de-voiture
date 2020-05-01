package gestionClasses;

import classes.Parking;
import classes.Vehicule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionParking {

    List<Parking> parkings;

    public GestionParking() throws IOException, ClassNotFoundException {
        parkings = new ArrayList<Parking>();
        File f = new File("parking.txt");
        //creer un fichier pour sauvgarder les donnees
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            if (f.length() != 0) {
                //si le fichier existe déja et n'est pas vide on charge les donnees dans une liste
                ObjectInputStream ois = new ObjectInputStream(fis);

                parkings = (ArrayList) ois.readObject();

                ois.close();
                fis.close();
            }
        }
        
    }
    //methode pour sauvgarder les modifications sur la liste dans le fichier
    public void sauvgarde() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("parking.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(parkings);
        oos.close();
        fos.close();
    }

    public void ajouter(Parking p) throws IOException {
//si le parking existe déja l'ajout ne sera pas effectue

        parkings.add(p);
        sauvgarde();
        System.out.println("Parking a été ajouté avec succes");
    }

    public void modifier(Parking p) throws IOException {
        //parcourir la liste et modifer l'objet par les nouveaux donnees d'objet qui a le meme matricule
        for (int i = 0; i < parkings.size(); i++) {
            if (parkings.get(i).getId() == p.getId()) {
                parkings.set(i, p);
                sauvgarde();

            }

        }

    }
//supprimer un objet de la liste 

    public void supprimer(Parking p) throws IOException {
        parkings.remove(p);
        sauvgarde();
        System.out.println("Parking a été supprimé avec succes");
    }
    //methode qui retourne un objet vehicule s'il existe sinon null

    public Parking recherche(int id) {
        for (int i = 0; i < parkings.size(); i++) {
            if (parkings.get(i).getId() == id) {
                return parkings.get(i);
            }
        }
        return null;
    }
//retourne la liste des parkings
    public List<Parking> listeParking() {
        return parkings;
    }

    public Parking saisie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("donner les informations du parking");
        Parking p = new Parking();
        System.out.println("capcaité actuelle ");
        p.setCapaciteAct(sc.nextInt());

        System.out.println("capacité maximale ");
        p.setCapaciteMax(sc.nextInt());

        return p;
    }

    public void distribuer(Parking p1, Parking p2, Parking p3) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> cat = new ArrayList<String>();
        System.out.println("donner les categories de distribution dans le premier parking");
        while (sc.hasNextLine()) {
            cat.add(sc.nextLine());
        }
        for (int i = 0; i < p1.getCapaciteAct(); i++) {
            if (cat.contains(p1.getListeVehicule().get(i).getCategorie())) {
                p2.ajouterVehicule(p1.getListeVehicule().get(i));
            } else {
                p3.ajouterVehicule(p1.getListeVehicule().get(i));

            }
        }
        p3.vider();
    }

    public void fusionner(Parking p1, Parking p2, Parking p3) {
        int i = 0;
        while (p1.getCapaciteAct() != 0) {

            p3.ajouterVehicule(p1.getListeVehicule().get(i));
            i++;
            p1.supprimerVehicule(p1.getListeVehicule().get(i));
        }
        i = 0;
        while (p2.getCapaciteAct() != 0) {

            p3.ajouterVehicule(p2.getListeVehicule().get(i));
            i++;
            p2.supprimerVehicule(p2.getListeVehicule().get(i));
        }
        System.out.println("groupement effectué avec success");
    }

    /* public void repartition(List<Parking> lp) throws IOException, ClassNotFoundException {

        GestionVehicule gv = new GestionVehicule();
        List<Vehicule> listeVehicule = gv.listeVehicule();
        for (int i = 0; i < lp.size(); i++) {
            for (int j = 0; j < listeVehicule.size(); j++) {
                if (lp.get(i).getId() == listeVehicule.get(j).getIdParking() && listeVehicule.get(j).isDisponible() == true) {
                    lp.get(i).ajouterVehicule(listeVehicule.get(j));
                } else if (lp.get(i).getId() == listeVehicule.get(j).getIdParking() && listeVehicule.get(j).isDisponible() == false) {
                    lp.get(i).getListeVehicule().remove(j);
                }

            }
        }
        

    }*/
}
