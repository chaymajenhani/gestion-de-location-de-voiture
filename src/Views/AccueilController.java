/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import gestionClasses.GestionClient;
import gestionClasses.GestionLocation;
import gestionClasses.GestionVehicule;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Stat.fxml"));
            rightScene.getChildren().setAll(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void AccueilView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Stat.fxml"));
        rightScene.getChildren().setAll(root);

    }

    @FXML
    private void ClientView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        rightScene.getChildren().setAll(root);

    }

    @FXML
    private void LocationView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Location.fxml"));
        rightScene.getChildren().setAll(root);

    }

    @FXML
    private void VehiculeView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Vehicule.fxml"));
        rightScene.getChildren().setAll(root);

    }

    @FXML
    private void Quitter() {
        System.exit(0);

    }

}
