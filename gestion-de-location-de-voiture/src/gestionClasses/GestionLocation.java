package gestionClasses;

import api.ExcelApi;
import classes.Location;

public class GestionLocation {

	ExcelApi eat;

	public GestionLocation() {
		try {
			eat = new ExcelApi();
		} catch (Exception e) {
			System.out.println("probleme d'ouverture de fichier!");
			e.printStackTrace();
		}

	}

	public void ajouter(Location l) {

		int rowNum = eat.workbook.getSheet("location").getLastRowNum() + 1;
		System.out.println(rowNum);

		eat.setCellData("location", "CIN Client", rowNum, String.valueOf(l.getClient()));
		eat.setCellData("location", "Matricule Vehicule", rowNum, l.getVehicule());
	
		eat.setCellData("location", "Code location", rowNum, String.valueOf(l.getCode()));
		eat.setCellData("location", "Date debut", rowNum, l.getDateDebut().toString());
		eat.setCellData("location", "Date fin", rowNum, l.getDateFin().toString());
		eat.setCellData("location", "Date location", rowNum, l.getDateLocation().toString());
		eat.setCellData("location", "Avec/Sans Chauffeur", rowNum, String.valueOf(l.isChauffeur()));
		eat.setCellData("location", "Type de paiement", rowNum, l.getTypePaiement());
	
		
		System.out.println("ajout avec succes");

	}

	public void modifier(Location l)  {

		int rowNum = eat.searchData("location", "Code location",String.valueOf(l.getCode()));
		System.out.println(rowNum);

		eat.setCellData("location", "CIN Client", rowNum, String.valueOf(l.getClient()));
		eat.setCellData("location", "Matricule Vehicule", rowNum, l.getVehicule());
	
		eat.setCellData("location", "Code location", rowNum, String.valueOf(l.getCode()));
		eat.setCellData("location", "Date debut", rowNum, l.getDateDebut().toString());
		eat.setCellData("location", "Date fin", rowNum, l.getDateFin().toString());
		eat.setCellData("location", "Date location", rowNum, l.getDateLocation().toString());
		eat.setCellData("location", "Avec/Sans Chauffeur", rowNum, String.valueOf(l.isChauffeur()));
		eat.setCellData("location", "Type de paiement", rowNum, l.getTypePaiement());

	}

	public void supprimer(Location l)  {

		int rowNum = eat.searchData("location", "Code location",String.valueOf(l.getCode()));
		System.out.println(rowNum);
		eat.removeRow("location", rowNum);

	}

}
