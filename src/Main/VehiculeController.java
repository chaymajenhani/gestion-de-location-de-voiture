package Main;

import classes.Matricule;
import classes.MatriculeException;
import classes.Vehicule;
import gestionClasses.GestionClient;
import gestionClasses.GestionVehicule;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class VehiculeController implements Initializable {

    @FXML
    private TableView<Vehicule> tableView;
    @FXML
    private TableColumn<Vehicule, Matricule> MatriculeColumn;
    @FXML
    private TableColumn<Vehicule, String> MarqueColumn;
    @FXML
    private TableColumn<Vehicule, String> CouleurColumn;
    @FXML
    private TableColumn<Vehicule, Double> Prix_locationColumn;
    @FXML
    private TableColumn<Vehicule, Integer> Nb_locationColumn;
    @FXML
    private TableColumn<Vehicule, String> CatégorieColumn;
    @FXML
    private TableColumn<Vehicule, Date> DateEntréeColumn;
    @FXML
    private TableColumn<Vehicule, Integer> IdParkingColumn;
    @FXML
    private TableColumn<Vehicule, Boolean> DisponibilitéColumn;
    @FXML
    private TableColumn<Vehicule, Integer> KilométrageColumn;

    @FXML
    private TextField paysField;
    @FXML
    private TextField serieField;
    @FXML
    private TextField numEnregField;

    @FXML
    private TextField MarqueField;
    @FXML
    private TextField CouleurField;
    @FXML
    private TextField Prix_locationField;
    @FXML
    private TextField Nb_locationField;
    @FXML
    private TextField CatégorieField;
    @FXML
    private DatePicker DateEntréeField;
    @FXML
    private TextField IdParkingField;
    @FXML
    private ComboBox DisponibiliteField;
    @FXML
    private TextField KilométrageField;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        MatriculeColumn.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        MarqueColumn.setCellValueFactory(new PropertyValueFactory<>("marque"));
        CouleurColumn.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        Prix_locationColumn.setCellValueFactory(new PropertyValueFactory<>("prixLocationParJour"));
        Nb_locationColumn.setCellValueFactory(new PropertyValueFactory<>("nbLocation"));
        CatégorieColumn.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        DateEntréeColumn.setCellValueFactory(new PropertyValueFactory<>("dateEntree"));
        IdParkingColumn.setCellValueFactory(new PropertyValueFactory<>("idParking"));
        DisponibilitéColumn.setCellValueFactory(new PropertyValueFactory<>("disponible"));
        KilométrageColumn.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));

        try {
            GestionVehicule gv = new GestionVehicule();
            tableView.getItems().addAll(gv.listeVehicule());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        DisponibiliteField.setValue("non");
        DisponibiliteField.getItems().addAll("oui", "non");

    }

    public void newCarButtonPushed() throws MatriculeException, IOException, ClassNotFoundException {
        Date dateE = new Date(DateEntréeField.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        boolean dispo = false;
        if (DisponibiliteField.getValue().equals("oui")) {
            dispo = true;
        }
        Vehicule newcar = new Vehicule(new Matricule(paysField.getText(), Integer.parseInt(serieField.getText()), Integer.parseInt(numEnregField.getText())), dateE, Double.parseDouble(Prix_locationField.getText()),
                Integer.parseInt(Nb_locationField.getText()), dispo, CouleurField.getText(), MarqueField.getText(), CatégorieField.getText(), Integer.parseInt(KilométrageField.getText()), Integer.parseInt(IdParkingField.getText()));

        //Get all the items from the table as a list, then add the new car to the list
        tableView.getItems().add(newcar);
        GestionVehicule gv = new GestionVehicule();
        gv.ajouter(newcar);

    }

}
