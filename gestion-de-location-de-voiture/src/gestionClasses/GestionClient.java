package gestionClasses;

import java.util.Scanner;

import api.ExcelApi;
import classes.Client;


public class GestionClient {
	ExcelApi eat;

	public GestionClient() {
		try {
			eat = new ExcelApi();
		} catch (Exception e) {
			System.out.println("probleme d'ouverture de fichier!");
			e.printStackTrace();
		}

	}

	public void ajouter(Client c) {

		int rowNum = eat.workbook.getSheet("Client").getLastRowNum() + 1;
		System.out.println(rowNum);

		eat.setCellData("Client", "CIN", rowNum, String.valueOf(c.getCin()));
		eat.setCellData("Client", "Nom", rowNum, c.getNom());
		eat.setCellData("Client", "Prenom", rowNum, c.getPrenom());
		eat.setCellData("Client", "Adresse", rowNum,c.getAdresse());
		eat.setCellData("Client", "Numero de permis", rowNum, String.valueOf(c.getNumPermis()));

	}

	public void modifier(Client c) {

		int rowNum = eat.searchData("Client","CIN", String.valueOf(c.getCin()));
		System.out.println(rowNum);

		eat.setCellData("Client", "CIN", rowNum, String.valueOf(c.getCin()));
		eat.setCellData("Client", "Nom", rowNum, c.getNom());
		eat.setCellData("Client", "Prenom", rowNum, c.getPrenom());
		eat.setCellData("Client", "Adresse", rowNum,c.getAdresse());
		eat.setCellData("Client", "Numero de permis", rowNum, String.valueOf(c.getNumPermis()));


	}

	public void supprimer(int cin) {

		int rowNum = eat.searchData("Client","CIN", String.valueOf(cin));
		// System.out.println(rowNum);
		eat.removeRow("Client", rowNum);

	}

	public void rechercher() {
		String C;

		Scanner input = new Scanner(System.in);
		System.out.println("donner le numero de carte CIN de client a recherecher");
		C = input.nextLine();
		input.close();
		int rowNum = eat.searchData("Client","CIN", C);
		rowNum++;
		System.out.println("CIN: " + C + "NOM: " + eat.getCellData("Client", 1, rowNum) + "PRENOM"
				+ eat.getCellData("Client", 2, rowNum));

	}
}
