package gestionClasses;

import classes.MatriculeException;
import classes.Matricule;
import classes.Vehicule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class GestionVehicule {

    List<Vehicule> vehicules;

    public GestionVehicule() throws IOException, ClassNotFoundException {
        vehicules = new ArrayList<>();
        File f = new File("vehicule .txt");
        //creer un fichier pour sauvgarder les donnees
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            if (f.length() != 0) {
                //si le fichier existe déja et n'est pas vide on charge les donnees dans une liste
                ObjectInputStream ois = new ObjectInputStream(fis);

                vehicules = (ArrayList) ois.readObject();

                ois.close();
                fis.close();
            }
        }

    }

    //methode pour sauvgarder les modifications sur la liste dans le fichier
    public void sauvgarde() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("vehicule .txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(vehicules);
        oos.close();
        fos.close();
    }

    public void ajouter(Vehicule v) throws IOException {
//si le vehicule existe déja l'ajout ne sera pas effectue
        if (recherche(v.getMatricule().toString()) != null) {
            System.out.println("Vehicule existe déja");
        } else {
            vehicules.add(v);
            sauvgarde();
            System.out.println("Vehicule a été ajouté avec success");
        }
    }

    public void modifier(Vehicule v) throws IOException {
        //parcourir la liste et modifer l'objet par les nouveaux donnees d'objet qui a le meme matricule
        for (int i = 0; i < vehicules.size(); i++) {
            if (vehicules.get(i).getMatricule().toString().equals(v.getMatricule())) {
                vehicules.set(i, v);
                sauvgarde();
            }

        }

    }
//supprimer un objet de la liste 

    public void supprimer(Vehicule v) throws IOException {
        vehicules.remove(v);
        sauvgarde();
        System.out.println("Vehicule été supprimé avec success");
    }
    //methode qui retourne un objet vehicule s'il existe sinon null

    public Vehicule recherche(String mat) {
        for (int i = 0; i < vehicules.size(); i++) {
            if (vehicules.get(i).getMatricule().toString().equals(mat)) {
                return vehicules.get(i);
            }
        }
        return null;
    }
//retourne la liste des vehicules

    public List<Vehicule> listeVehicule() {
        return vehicules;
    }
//saisie des donnees d'une vehicule

    public Vehicule saisie() throws MatriculeException {
        System.out.println("donner les informations de vehicule");
        Scanner sc = new Scanner(System.in);
        Vehicule v = new Vehicule();
        System.out.println("Matricule");
        System.out.println("pays");
        String pays = sc.next();
        System.out.println("serie");
        int serie = sc.nextInt();
        System.out.println("numero d'enregistrement");
        int numE = sc.nextInt();
        Matricule mat = new Matricule(pays, serie, numE);
        v.setMatricule(mat);
        System.out.println("date Entree");
        v.setDateEntree(new Date(sc.next()));
        System.out.println("prix de location par jour");
        v.setPrixLocationParJour(sc.nextDouble());
        System.out.println("loué (oui/non)");
        if (sc.next().equals("oui")) {
            v.setDisponible(true);
            System.out.println("numero de parking");
            v.setIdParking(sc.nextInt());
        } else {
            v.setDisponible(false);
            v.setIdParking(-1);
        }
        System.out.println("couleur");
        v.setCouleur(sc.next());
        System.out.println("categorie");
        v.setCategorie(sc.next());
        System.out.println("marque");
        v.setMarque(sc.next());
        System.out.println("kilometrage");
        v.setKilometrage(sc.nextInt());
        System.out.println("numero de parking");
        v.setIdParking(sc.nextInt());
        return v;
    }

    public List<Vehicule> trieCategorie() {
        List<Vehicule> listTrieCat = vehicules;
        //trier la liste de vehicules selon la catégorie par l'implementation de la methode compare de l'interface Comparator
        Collections.sort(listTrieCat, new Comparator<Vehicule>() {
            @Override
            public int compare(Vehicule v1, Vehicule v2) {
                //comparer la catégorie de deux vehicules puis les reorganiser dans la liste selon la catégorie  par la methode sort 
                return v1.getCategorie().compareTo(v2.getCategorie());

            }
        });
        return listTrieCat;
    }

    public TreeMap<String, Integer> trieAge() {
        HashMap<String, Integer> map = new HashMap<>();
        TreeMap<String, Integer> mapTriee = new TreeMap<>();
        for (int i = 0; i < vehicules.size(); i++) {
            map.put(vehicules.get(i).toString(), vehicules.get(i).calculerAge());

        }
        mapTriee.putAll(map);
        return mapTriee;

    }

    public Vehicule VehiculePlusLoue() {
        int max = 0;
        int indiceMax = -1;
        //parcourir la liste des vehicules
        for (int i = 0; i < vehicules.size(); i++) {
            //rechercher le vehicule qui a le  plus grand nombre de location
            if (vehicules.get(i).getNbLocation() > max) {
                max = vehicules.get(i).getNbLocation();
            }
            indiceMax = i;
        }
        return vehicules.get(indiceMax);

    }

    public Vehicule VehiculePlusAncien() {
        int max = 0;
        int indiceMax = -1;
        //parcourir la liste des vehicule 
        for (int i = 0; i < vehicules.size(); i++) {
            //recherhcer le vehicule qui a le plus grand age
            if (vehicules.get(i).calculerAge() > max) {
                max = vehicules.get(i).calculerAge();
            }
            indiceMax = i;
        }
        //retourner le vehicule le plus ancien
        return vehicules.get(indiceMax);
    }

    public List<Vehicule> Age2et3ans() {
        List<Vehicule> liste = new ArrayList<>();
        //parcourir la liste des vehicule 
        for (int i = 0; i < vehicules.size(); i++) {
            //convertir l'age en annee
            float age = vehicules.get(i).calculerAge() / 365;
            //ajouter le vehicule qui ayant un age entre 2 et 3 ans
            if (age <= 3 && age >= 2) {
                liste.add(vehicules.get(i));
            }

        }
        return liste;
    }

    public List<Vehicule> vehiculesLoues() {
        List<Vehicule> liste = new ArrayList<>();
        //parcourir la liste des vehicule 
        for (int i = 0; i < vehicules.size(); i++) {
            //ajouter le vehicule non disponible 
            if (vehicules.get(i).isDisponible() == false) {
            } else {
                liste.add(vehicules.get(i));
            }

        }
        return liste;
    }
}
