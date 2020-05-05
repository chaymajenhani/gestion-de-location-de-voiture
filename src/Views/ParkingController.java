/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import classes.Parking;
import classes.Vehicule;
import gestionClasses.GestionClient;
import gestionClasses.GestionLocation;
import gestionClasses.GestionParking;
import gestionClasses.GestionVehicule;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * 
 */
public class ParkingController implements Initializable {
  //declaration des composants déclarés dans le fichier FXML (interface Graphique)
    @FXML
    private TableColumn<Parking, Integer> idParkingCol;
    @FXML
    private TableColumn<Parking, Integer> capMaxCol;
    @FXML
    private TableColumn<Parking, Integer> capActCol;
    @FXML
    private TableColumn<Parking, ?> listeVehCol;
    @FXML
    private TextField capMaxField;
    @FXML
    private ComboBox listeVehField;
    @FXML
    private TextField idParcField;
    @FXML
    private Button AjouterVeh;
    @FXML
    private TableView listeParking;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //lier les données dans le fichier par les colones du tableau pour les afficher
        idParkingCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        capMaxCol.setCellValueFactory(new PropertyValueFactory<>("capaciteMax"));
        capActCol.setCellValueFactory(new PropertyValueFactory<>("capciteAct"));
        listeVehCol.setCellValueFactory(new PropertyValueFactory<>("listeVehicule"));
        try {
            GestionParking gp = new GestionParking();
            listeParking.getItems().addAll(gp.listeParking());
            //si le tableau est vide , le bouton ajouter vehicule au parking est désactivée
            if (gp.listeParking().isEmpty()) {
                AjouterVeh.setDisable(true);
            }
            GestionVehicule gv = new GestionVehicule();
            for (int i = 0; i < gv.listeVehicule().size(); i++) {
                //ajouter le vehicule disponible et qui n'est pas encore affecté à un parking a la laiste des choix des vehicule
                if (gv.listeVehicule().get(i).isDisponible() && (gv.listeVehicule().get(i).getIdParking() == -1)) {
                    listeVehField.getItems().add(gv.listeVehicule().get(i));
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void AjouterParking() throws IOException, ClassNotFoundException {
        Parking parc = new Parking();
        parc.setCapaciteMax(Integer.parseInt(capMaxField.getText()));
        //enregistrer l'objet dans le tableau
        listeParking.getItems().add(parc);
        GestionParking gp = new GestionParking();
        //enregistrer l'objet dans le fichier
        gp.ajouter(parc);

    }

    @FXML
    private void AjouterVehicule() throws IOException, ClassNotFoundException {
        int idParc = Integer.parseInt(idParcField.getText());
        GestionParking gp = new GestionParking();
       Parking parc= gp.recherche(idParc);
        parc.ajouterVehicule((Vehicule) listeVehField.getValue());

    }

}
