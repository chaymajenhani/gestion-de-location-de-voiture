package classes;



public class Client {

   private int cin;

   private String nom;

   private String prenom;

   private String adresse;

   private int tel;

   private int numPermis;

public Client(int cin, String nom, String prenom, String adresse, int tel, int numPermis) {

	this.cin = cin;
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.tel = tel;
	this.numPermis = numPermis;
}

@Override
public String toString() {
	return "Client [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel
			+ ", numPermis=" + numPermis + "]";
	
}

public int getCin() {
	return cin;
}

public void setCin(int cin) {
	this.cin = cin;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public int getTel() {
	return tel;
}

public void setTel(int tel) {
	this.tel = tel;
}

public int getNumPermis() {
	return numPermis;
}

public void setNumPermis(int numPermis) {
	this.numPermis = numPermis;
}
   
   
   
   
   
   
   
  
}