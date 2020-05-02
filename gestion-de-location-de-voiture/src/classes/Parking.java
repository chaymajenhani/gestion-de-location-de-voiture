package classes;

import java.util.*;

public class Parking {

	private static int cpt = 0;
	private int id;

	private int capaciteMax;

	private int capaciteAct;

	private List<Vehicule> listeVehicule;

	public Parking(int capaciteMax, int capaciteAct, List<Vehicule> listeVehicule) {
		this.id = cpt++;
		this.capaciteMax = capaciteMax;
		this.capaciteAct = capaciteAct;
		this.listeVehicule = listeVehicule;
	}

	public void ajouterVehicule(Vehicule v) {
		listeVehicule.add(v);
	}

	public void vider() {
		listeVehicule.clear();
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

	public void afficherVehicules() {

		for (int i = 0; i < listeVehicule.size(); i++)
			System.out.println("categorie:" + listeVehicule.get(i).getCategorie() + " matricule:"
					+ listeVehicule.get(i).getMarque() + "prix" + listeVehicule.get(i).getNbLocation());

	}

	public void trieCategorie() {
		ArrayList<String> listeCategorie = new ArrayList<String>();

		for (int i = 0; i < listeVehicule.size(); i++) {
			listeCategorie.add(listeVehicule.get(i).getCategorie() + String.valueOf(listeVehicule.get(i).getMarque()));
			Collections.sort(listeCategorie);

		}
		System.out.println("liste des vehicules ordonnées selon la catégorie:/n");
		for (int i = 0; i < listeCategorie.size(); i++) {
			System.out.println(listeCategorie.get(i));
		}
	}

	public void supprimerVehicule(Vehicule v) {
		listeVehicule.remove(v);
	}

}