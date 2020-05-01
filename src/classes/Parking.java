package classes;

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

    public void ajouterVehicule(Vehicule v) {
        listeVehicule.add(v);
    }

    public void vider() {
        listeVehicule.clear();
    }

    @Override
    public String toString() {
        return "[capacité Actuelle=" + capaciteAct + ", capacoté maximale=" + capaciteMax + "]";
    }

    public void afficherVehicules() {

        for (int i = 0; i < listeVehicule.size(); i++) {
            System.out.println(listeVehicule.get(i).toString());
        }

    }

    public void supprimerVehicule(Vehicule v) {
        listeVehicule.remove(v);
        capaciteAct--;
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
