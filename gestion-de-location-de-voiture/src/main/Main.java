package main;


import java.util.Date;

import classes.Client;
import classes.Location;
import classes.Matricule;
import classes.Vehicule;
import gestionClasses.GestionClient;
import gestionClasses.GestionLocation;
import gestionClasses.GestionVehicule;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	/*	Location l = new Location(1435658, "203 tunis 1463", new Date(), new Date("01/01/2020"),
				new Date("01/02/2020"), false, "cheque");
		Location l1 = new Location(1435658, "203 tunis 1463", new Date(), new Date("01/01/2020"),
				new Date("01/02/2020"), true, "espece");
		l1.setCode(l.getCode());
		GestionLocation gt = new GestionLocation();
		gt.ajouter(l);
		gt.modifier(l1);*/

		Matricule m = new Matricule("tunis", 580, 789);
		Date d1 = new Date(2020, 03, 06);
		Vehicule v = new Vehicule(m, d1, 390, 5, true, "noir", "bmw", "2015", 200);

		Vehicule v1 = new Vehicule(m, d1, 390, 5, true, "rouge", "audi", "2015", 200);

		GestionVehicule g = new GestionVehicule();
		g.ajouter(v);
		g.modifier(v1);
		/*Client cl=new Client(14132334, "nom", "prenom", "adresse", 12354742, 12345);
		GestionClient gc=new GestionClient();
		
		gc.ajouter(cl);
		*/
		
		
		
	
	}

}
