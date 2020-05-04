package gestionClasses;

import classes.Client;

import classes.ClientException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionClient {

    public List<Client> clients;

    public GestionClient() throws IOException, ClassNotFoundException {
        clients = new ArrayList<Client>();
        File f = new File("client.txt");
        //creer un fichier pour sauvgarder les donnees
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            if (f.length() != 0) {
                //si le fichier existe déja et n'est pas vide on charge les donnees dans une liste
                ObjectInputStream ois = new ObjectInputStream(fis);

                clients = (ArrayList) ois.readObject();

                ois.close();
                fis.close();
            }
        }

    }
    //methode pour sauvgarder les modifications sur la liste

    public void sauvgarde() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("client.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(clients);
        oos.close();
        fos.close();
    }

    public void ajouter(Client c) throws IOException {
//si le client existe déja l'ajout ne sera pas effectue
        if (recherche(c.getCin()) != null) {
            System.out.println("Client existe deja");
        } else {
            clients.add(c);
            sauvgarde();
            System.out.println("clienta été ajouté avec success");

        }
    }

    public void modifier(Client c) throws IOException {
        //parcourir la liste et modifer l'objet par les nouveaux donnees d'objet qui a le meme cin
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getCin() == c.getCin()) {
                clients.set(i, c);
                sauvgarde();
            }

        }

    }

//supprimer un objet de la liste 
    public void supprimer(Client c) throws IOException {
        clients.remove(c);
        sauvgarde();
        System.out.println("clienta été supprimé avec success");
    }

    //methode qui retourne un objet client s'il existe sinon null
    public Client recherche(int cin) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getCin() == cin) {
                return clients.get(i);
            }
        }
        return null;
    }
//retourne la liste des clients

    public List<Client> listeClient() {
        return clients;
    }

    public Client saisie() throws ClientException {

        Scanner sc = new Scanner(System.in);
        System.out.println("donner les informations du clients");
        Client cl = new Client();
        System.out.println("CIN: ");
        cl.setCin(sc.nextInt());
        System.out.println("Nom: ");
        cl.setNom(sc.next());
        System.out.println("Prenom: ");
        cl.setPrenom(sc.next());
        System.out.println("Adresse: ");
        cl.setAdresse(sc.next());
        System.out.println("Tel: ");
        cl.setTel(sc.nextInt());
        System.out.println("Numero de permis: ");
        cl.setNumPermis(sc.nextInt());
        return cl;

    }

}
