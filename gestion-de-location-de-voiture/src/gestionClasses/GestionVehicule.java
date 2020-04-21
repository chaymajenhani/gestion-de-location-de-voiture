package gestionClasses;

import api.ExcelApi;
import classes.Vehicule;

public class GestionVehicule {

	ExcelApi eat;

	public GestionVehicule() {
		try {
			eat = new ExcelApi();
		} catch (Exception e) {
			System.out.println("probleme d'ouverture de fichier!");
			e.printStackTrace();
		}

	}

	public void ajouter(Vehicule v) {

		int rowNum = eat.workbook.getSheet("Vehicule").getLastRowNum() + 1;
		System.out.println(rowNum);

		eat.setCellData("vehicule", "Kilometrage", rowNum, String.valueOf(v.getKilometrage()));
		eat.setCellData("vehicule", "Nombre de location", rowNum, String.valueOf(v.getNbLocation()));
		eat.setCellData("vehicule", "Prix de location", rowNum, String.valueOf(v.getNbLocation()));
		eat.setCellData("vehicule", "Matricule", rowNum, v.getNumImmatriculation().toString());
		eat.setCellData("vehicule", "Disponibilite", rowNum, String.valueOf(v.isDisponible()));
		eat.setCellData("vehicule", "Couleur", rowNum, v.getCouleur());
		eat.setCellData("vehicule", "Date entree", rowNum, v.getDateFabrication().toString());
		eat.setCellData("vehicule", "Categorie", rowNum, v.getCategorie());
		eat.setCellData("vehicule", "Marque", rowNum, v.getMarque());

	}

	public void modifier(Vehicule v) {

		int rowNum = eat.searchData("vehicule", "Matricule",v.getNumImmatriculation().toString());
		System.out.println(rowNum);
		eat.setCellData("vehicule", "Kilometrage", rowNum, String.valueOf(v.getKilometrage()));
		eat.setCellData("vehicule", "Nombre de location", rowNum, String.valueOf(v.getNbLocation()));
		eat.setCellData("vehicule", "Prix de location", rowNum, String.valueOf(v.getNbLocation()));
		eat.setCellData("vehicule", "Matricule", rowNum, v.getNumImmatriculation().toString());
		eat.setCellData("vehicule", "Disponibilite", rowNum, String.valueOf(v.isDisponible()));
		eat.setCellData("vehicule", "Couleur", rowNum, v.getCouleur());
		eat.setCellData("vehicule", "Date entree", rowNum, v.getDateFabrication().toString());
		eat.setCellData("vehicule", "Categorie", rowNum, v.getCategorie());
		eat.setCellData("vehicule", "Marque", rowNum, v.getMarque());


	}

	public void supprimer(Vehicule v) {

		int rowNum = eat.searchData("vehicule", "Matricule",v.getNumImmatriculation().toString());
		// System.out.println(rowNum);
		eat.removeRow("vehicule", rowNum);

	}

}
