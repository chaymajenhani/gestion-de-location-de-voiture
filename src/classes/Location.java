package classes;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.scene.text.Text;
import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import javafx.scene.image.Image;

public class Location implements Serializable {

    public static int cpt = 0;

    private int code;

    private Client client;

    private Vehicule vehicule;

    private Date dateDebut;

    private Date dateFin;

    private boolean chauffeur;

    private String typePaiement;

    private float prop;

    public Location(Client client, Vehicule vehicule, Date dateDebut, Date dateFin,
            boolean chauffeur, String typePaiement, float prop) {

        this.code = ++cpt;
        this.client = client;
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chauffeur = chauffeur;
        this.prop = prop;

        this.typePaiement = typePaiement;
    }

    public Location() {
        this.code = ++cpt;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getProp() {
        return prop;
    }

    public void setProp(float prop) {
        this.prop = prop;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(boolean chauffeur) {
        this.chauffeur = chauffeur;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "[code=" + code + ", client= " + client.getCin() + " " + client.getNom() + " " + client.getPrenom() + ", vehicule=" + vehicule.getMatricule().toString() + ", dateDebut=" + formatter.format(dateDebut) + ", dateFin=" + formatter.format(dateFin) + ", chauffeur=" + chauffeur
                + ", prop=" + prop + ", typePaiement=" + typePaiement + "]";
    }

    public void afficherContrat() throws DocumentException, IOException {
        //creer un document
        Document document = new Document();
        try {
            //creer un fichier pdf a partir du contenu du document
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("Contrat Numero " + code + ".pdf"));
            document.open();
            Paragraph p = new Paragraph();
            //ecrire une nouvelle ligne
            p.add(Chunk.NEWLINE);
            //ecrire le contrat par les donnees de cette location
            p.add(new Paragraph("-------------------------------------"));
            p.add(new Paragraph(" Contrat de Location de Voiture "));
            p.add(new Paragraph("-------------------------------------"));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph("Contrat numero: " + String.valueOf(code) + " , " + new Date()));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph("Propriétaire du véhicule: ENSIcars"));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph("nom: " + client.getNom() + " prenom: " + client.getPrenom() + " cin " + String.valueOf(client.getCin())));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph("Marque: " + vehicule.getMarque()));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph("Matricule:  " + vehicule.getMatricule().toString()));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph(
                    "Le propriétaire s'engage à mettre à la disposition du locataire"
                    + "le véhicule en bonne conditions(freins, pneus, suspension,"
                    + " moteur, châssis)"
                    + " , avec le petit matériel nécessaire pour des petites interventions par le chauffeur (jeu de tournevis"
                    + "   , jeu de"
                    + "clés , corde de remorquage"));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph("Durée Du Contrat:  "));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph("Date de debut: " + String.valueOf(dateDebut) + "   Date de fin: " + String.valueOf(dateFin)));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph("Prix de Location:" + String.valueOf(calculeMontantTotal())));
            p.add(Chunk.NEWLINE);
            p.add(new Paragraph("contrat prend fin à la date  " + String.valueOf(dateFin) + " expiration sans préavis écrit."));

            document.add(p);
            document.close();
            pdfWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File f = new File("Contrat Numero " + code + ".pdf");
        //  System.out.println(f.exists());
        if (f.exists()) {
            // ouvrir le fichier du contrat
            Desktop.getDesktop().open(f);
        }
        else {
            System.out.println("probleme de création du fichier");
        }
    }

    public double calculeMontantTotal() {
        double x = 0;
        double mt = 0;

        //calculer la difference entre les dates en ms 
        long diff = Math.abs(dateFin.getTime() - dateDebut.getTime());
        //convertir la difference en jours
        int dureeJours = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if (chauffeur = true) {
            x = 1;
        }
        mt = (dureeJours * (vehicule.getPrixLocationParJour() + x * 50)) + prop * 100;
        return mt;

    }

}
