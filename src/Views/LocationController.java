/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import classes.Client;
import classes.Location;
import classes.Vehicule;
import gestionClasses.GestionClient;
import gestionClasses.GestionLocation;
import gestionClasses.GestionVehicule;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Chayma Jenhani
 */
public class LocationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label label;
    @FXML
    private TableView<Location> listeLocation;
    @FXML
    private TableColumn<Location, Integer> CodeCol;
    @FXML
    private TableColumn<Location, Client> clientCol;
    @FXML
    private TableColumn<Location, Vehicule> vehiculeCol;
    @FXML
    private TableColumn<Location, Date> dateDebCol;
    @FXML
    private TableColumn<Location, Date> dateFinCol;
    @FXML
    private TableColumn<Location, Boolean> chauffeurCol;
    @FXML
    private TableColumn<Location, String> typePCol;
    @FXML
    private TableColumn<Location, Float> pleinCol;

    @FXML
    private ComboBox clientField;
    @FXML
    private ComboBox vehiculeField;
    @FXML
    private DatePicker dateDebField;
    @FXML
    private DatePicker dateFinField;
    @FXML
    private ComboBox chauffeurField;
    @FXML
    private TextField typePField;
    @FXML
    private TextField pleinField;

    GestionLocation gl;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        CodeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        clientCol.setCellValueFactory(new PropertyValueFactory<>("client"));
        vehiculeCol.setCellValueFactory(new PropertyValueFactory<>("vehicule"));
        dateDebCol.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dateFinCol.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        chauffeurCol.setCellValueFactory(new PropertyValueFactory<>("chauffeur"));
        pleinCol.setCellValueFactory(new PropertyValueFactory<>("prop"));
        typePCol.setCellValueFactory(new PropertyValueFactory<>("typePaiement"));

        try {
            gl = new GestionLocation();
            listeLocation.getItems().addAll(gl.listeLocation());

            chauffeurField.setValue("Chauffeur");
            chauffeurField.getItems().addAll("oui", "non");
            clientField.setValue("Client");
            vehiculeField.setValue("Vehicule");
            GestionClient gc = new GestionClient();
            for (int i = 0; i < gc.listeClient().size(); i++) {

                clientField.getItems().add(gc.listeClient().get(i).getCin());
            }

            GestionVehicule gv = new GestionVehicule();
            for (int i = 0; i < gv.listeVehicule().size(); i++) {
                if (gv.listeVehicule().get(i).isDisponible()) {
                    vehiculeField.getItems().add(gv.listeVehicule().get(i).getMatricule().toString());
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AjouterLocation() throws IOException, ClassNotFoundException {
        Location l = new Location();
        GestionVehicule gv = new GestionVehicule();
        GestionClient gc = new GestionClient();
        l.setClient((Client) gc.recherche((int) clientField.getValue()));
        l.setVehicule((Vehicule) gv.recherche((String) vehiculeField.getValue()));
        l.setProp(Float.parseFloat(pleinField.getText()));
        l.setTypePaiement(typePField.getText());
        l.setDateDebut(new Date(dateDebField.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        l.setDateFin(new Date(dateFinField.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        boolean chauffeur = false;
        if (chauffeurField.getValue().equals("oui")) {
            chauffeur = true;
        }
        listeLocation.getItems().add(l);
        gl = new GestionLocation();
        gl.ajouter(l);

    }

}
