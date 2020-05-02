package classes;

public class Matricule {

	private String pays;

	private int serie;

	private int numEnregistrement;

	public Matricule(String pays, int serie, int numEnregistrement) throws Errconst {
		if ((serie <= 0 || numEnregistrement <= 0))
			throw new Errconst();

		this.pays = pays;
		this.serie = serie;
		this.numEnregistrement = numEnregistrement;
	}

	@Override
	public String toString() {
		return serie + " " + pays + " " + numEnregistrement;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public int getNumEnregistrement() {
		return numEnregistrement;
	}

	public void setNumEnregistrement(int numEnregistrement) {
		this.numEnregistrement = numEnregistrement;
	}

}

class Errconst extends Exception {
}