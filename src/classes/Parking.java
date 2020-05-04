package classes;

import gestionClasses.GestionParking;
import gestionClasses.GestionVehicule;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Parking implements Serializable {

    private static int cpt = 0;
    private int id;

    private int capaciteMax;

    private int capaciteAct;

    private List<Vehicule> listeVehicule;

    public Parking(int capaciteMax, int capaciteAct) {
        this.id = cpt++;
        this.capaciteMax = capaciteMax;
        this.capaciteAct = capaciteAct;
        listeVehicule = new ArrayList<>();

    }

    public Parking() {
        this.id = cpt++;
        listeVehicule = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public int getCapaciteAct() {
        return capaciteAct;
    }

    public void setCapaciteAct(int capaciteAct) {
        this.capaciteAct = capaciteAct;
    }

    public List<Vehicule> getListeVehicule() {
        return listeVehicule;
    }

    public void setListeVehicule(List<Vehicule> listeVehicule) {
        this.listeVehicule = listeVehicule;
    }

    public void ajouterVehicule(Vehicule v) throws IOException, ClassNotFoundException {
        listeVehicule.add(v);
        capaciteAct++;
        //sauvgarder les donnees dans le fichier
        GestionParking gp = new GestionParking();
        GestionVehicule gv=new GestionVehicule();
        v.setIdParking(this.id);
        gv.modifier(v);
        gp.modifier(this);
    }

    public void vider() throws IOException, ClassNotFoundException {
        listeVehicule.clear();
        capaciteAct=0;
        //sauvgarder les donnees dans le fichier
        GestionParking gp = new GestionParking();
        gp.modifier(this);
    }

    public void supprimerVehicule(Vehicule v) throws IOException, ClassNotFoundException {
        listeVehicule.remove(v);
        capaciteAct--;
        //sauvgarder les donnees dans le fichier
        GestionParking gp = new GestionParking();
        GestionVehicule gv=new GestionVehicule();
        v.setIdParking(-1);
        gv.modifier(v);
        gp.modifier(this);
    }

    @Override
    public String toString() {
        return "Id= " + id + ", capacité Actuelle=" + capaciteAct + ", capacoté maximale=" + capaciteMax ;
    }

    public void afficherVehicules() {

        for (int i = 0; i < listeVehicule.size(); i++) {
            System.out.println(listeVehicule.get(i).toString());
        }

    }

    public double moyennePrix() {
        double s = 0;
        int i = 0;

        Iterator<Vehicule> it = listeVehicule.iterator();
        while (it.hasNext()) {
            s = s + it.next().getPrixLocationParJour();
            i++;
        }

        return (s / i);
    }

}
