/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Chayma Jenhani
 */
public class AccueilController implements Initializable {

    @FXML
    private AnchorPane rightScene;

    /**
     * Initializes the controller class.
     */
    @Override
    @FXML
    //initialiser les données de l'interface
    public void initialize(URL url, ResourceBundle rb) {
        //charger la fenetre droite par les composantes de l'interface Stat
        try {
            //chargr l'interface
            Parent root = FXMLLoader.load(getClass().getResource("Stat.fxml"));
            //remplacer son contenu
            rightScene.getChildren().setAll(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    //changer la fenetre droite par l'interface Stat au clic du bouton Accueil
    private void AccueilView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Stat.fxml"));

        rightScene.getChildren().setAll(root);

    }

    @FXML
    //changer la fenetre droite par l'interface Client au clic du bouton Gestion Client
    private void ClientView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        rightScene.getChildren().setAll(root);

    }

    @FXML
    //changer la fenetre droite par l'interface Location au clic du bouton Gestion Location
    private void LocationView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Location.fxml"));
        rightScene.getChildren().setAll(root);

    }

    @FXML
    //changer la fenetre droite par l'interface Vehicule au clic du bouton Gestion Vehicule
    private void VehiculeView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Vehicule.fxml"));
        rightScene.getChildren().setAll(root);

    }

    @FXML
    //changer la fenetre droite par l'interface Parking au clic du bouton Gestion Parking
    private void ParkingView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Parking.fxml"));
        rightScene.getChildren().setAll(root);

    }

    @FXML
    //quitter
    private void Quitter() {
        System.exit(0);

    }

}
